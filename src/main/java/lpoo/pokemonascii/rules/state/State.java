package lpoo.pokemonascii.rules.state;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface State {
    void start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException;
}
