package lpoo.pokemonascii;

import lpoo.pokemonascii.rules.observer.Observer;
import lpoo.pokemonascii.rules.state.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class ObserverTest {
    private Observer observer;
    private GameState gamestate;

    @Before
    public void init() throws LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException, IOException {
        gamestate = new GameState();
        observer = Mockito.mock(Observer.class);
        gamestate.addObserver(observer);
    }

    @Test
    public void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        gamestate.setState(null);
        verify(observer, times(1)).update();

        List<Observer> observers = new ArrayList<>();
        observers.add(observer);

        assertEquals(observers, gamestate.getObservers());
    }
}
