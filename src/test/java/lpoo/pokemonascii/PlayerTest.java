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

    @Test
    public void testGetPosition(){
        Position current = player.getPosition();
        Position up = new Position(current.getX(), current.getY() - 4);
        Position down = new Position(current.getX(), current.getY() + 4);
        Position left = new Position(current.getX() - 4, current.getY());
        Position right = new Position(current.getX() + 4, current.getY());

        assertEquals(up, player.getPosition(Position.Direction.UP));
        assertEquals(down, player.getPosition(Position.Direction.DOWN));
        assertEquals(left, player.getPosition(Position.Direction.LEFT));
        assertEquals(right, player.getPosition(Position.Direction.RIGHT));
    }

}
