package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.observer.Observer;
import lpoo.pokemonascii.rules.state.GameState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ObserverTest {
    private static Observer observer;
    private static GameState gamestate;

    @BeforeAll
    static void init() throws ParserConfigurationException, SAXException, IOException {
        GameView gui = Mockito.mock(GameView.class);
        gamestate = new GameState(gui);
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
