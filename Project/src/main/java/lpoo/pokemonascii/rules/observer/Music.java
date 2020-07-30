package lpoo.pokemonascii.rules.observer;

import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.World;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Observer{
    private static final String AUDIO_PATH = "data\\audio\\";

    private Clip clip;

    public Music(GameState game) throws LineUnavailableException {
        gamemode = game;
        gamemode.addObserver(this);
        clip = AudioSystem.getClip();
    }

    @Override
    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();

        if (gamemode.getState() instanceof World){
            AudioInputStream worldIn = AudioSystem.getAudioInputStream(new File(AUDIO_PATH + "town.wav"));
            clip = AudioSystem.getClip();
            clip.open(worldIn);
            clip.start();
        }

        else if(gamemode.getState() instanceof Battle){
            AudioInputStream battleIn = AudioSystem.getAudioInputStream(new File(AUDIO_PATH + "battle.wav"));
            clip = AudioSystem.getClip();
            clip.open(battleIn);
            clip.start();
        }

        try {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); // Reduce volume by 30 decibels.
        }

        catch (IllegalArgumentException ignored) {

        }
    }
}
