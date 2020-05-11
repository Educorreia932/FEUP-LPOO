package lpoo.pokemonascii.data.SoundEffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class SoundEffect {
    private String soundFile;
    private static final String AUDIO_PATH = "data\\audio\\";
    protected Clip clip;
    protected AudioInputStream in;

    public SoundEffect(String soundFile){
        this.soundFile = soundFile;
    }

    public void play(){
        try {
            in = AudioSystem.getAudioInputStream(new File(AUDIO_PATH + soundFile));
            clip = AudioSystem.getClip();
            clip.open(in);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        clip.start();
    }
}
