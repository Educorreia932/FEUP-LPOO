package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;

    @Before
    public void init(){
        player = new Player();
    }

    @Test
    public void testSetGetsStates(){
        player.setState(Player.State.BACK);
        assertEquals(Player.State.BACK, player.getState());

        player.setState(Player.State.FRONT);
        assertEquals(Player.State.FRONT, player.getState());

        player.setState(Player.State.LEFT);
        assertEquals(Player.State.LEFT, player.getState());

        player.setState(Player.State.RIGHT);
        assertEquals(Player.State.RIGHT, player.getState());
    }

}
