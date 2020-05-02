package lpoo.pokemonascii.rules.observer;

import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.World;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Observer{
    private AudioInputStream battleIn;
    private AudioInputStream worldIn;
    private Clip clip;

    public Music(GameState game) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        gamemode = game;
        gamemode.addObserver(this);

        worldIn = AudioSystem.getAudioInputStream(new File("data\\Music\\town.wav"));
        battleIn = AudioSystem.getAudioInputStream(new File("data\\Music\\battle.wav"));
        clip = AudioSystem.getClip();
    }

    @Override
    public void update() throws IOException, LineUnavailableException {
        clip.stop();
        clip.close();
        if(gamemode.getGamemode() instanceof World){
            clip.open(worldIn);
            clip.start();
        }
        else if(gamemode.getGamemode() instanceof Battle){
            clip.open(battleIn);
            clip.start();
        }

    }
}
