package lpoo.pokemonascii;

import lpoo.pokemonascii.rules.observer.Music;
import lpoo.pokemonascii.rules.observer.Observer;
import lpoo.pokemonascii.rules.state.GameState;
import org.junit.Before;
import org.junit.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class ObserverTest {
    private Observer observer;
    private GameState gamestate;

    @Before
    public void init() throws LineUnavailableException {
        gamestate = new GameState();
        observer = new Music(gamestate);
    }

    @Test
    public void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        gamestate.setState(null);
        //verify(observer, times(1)).update();
    }
}
