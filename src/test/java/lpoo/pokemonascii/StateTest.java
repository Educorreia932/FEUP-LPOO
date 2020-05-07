package lpoo.pokemonascii;

import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.State;
import lpoo.pokemonascii.rules.state.World;
import org.junit.Before;
import org.junit.Test;
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
    public void init() throws IOException, SAXException, ParserConfigurationException, LineUnavailableException, UnsupportedAudioFileException {
        gameState = new GameState();
        battle = new Battle();
        world = gameState.getWorld();
        state = battle;
    }

    @Test
    public void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        assertEquals(world, gameState.getState());

        gameState.setState(battle);
        assertEquals(battle, gameState.getState());

        gameState.setState(world);
        assertEquals(world, gameState.getState());

        gameState.setState(state);
        assertEquals(state, gameState.getState());

        gameState.setState(null);
        assertEquals(null, gameState.getState());
    }

}
