package lpoo.pokemonascii;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.State;
import lpoo.pokemonascii.rules.state.World;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StateTest {
    private Battle battle;
    private World world;
    private GameState gameState;
    private State state;

    @Before
    public void init() throws IOException, SAXException, ParserConfigurationException {
        Screen screen = Mockito.mock(Screen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        gameState = new GameState();
        battle = new Battle(screen, textGraphics);
        world = new World(screen, textGraphics);
        state = battle;
    }

    @Test
    public void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        assertEquals(null, gameState.getGamemode());

        gameState.setState(battle);
        assertEquals(battle, gameState.getGamemode());

        gameState.setState(world);
        assertEquals(world, gameState.getGamemode());

        gameState.setState(state);
        assertEquals(state, gameState.getGamemode());

        gameState.setState(null);
        assertEquals(null, gameState.getGamemode());
    }

}
