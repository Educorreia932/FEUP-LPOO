package lpoo.pokemonascii.rules.state;


import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public interface State {
    void start(GameState game) throws IOException, LineUnavailableException;
}
