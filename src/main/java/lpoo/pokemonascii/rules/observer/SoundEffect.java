package lpoo.pokemonascii.rules.observer;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundEffect extends Observer {
    private static final String AUDIO_PATH = "data\\audio\\";

    private Clip clip;

    public SoundEffect() {

    }

    @Override
    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

    }
}
