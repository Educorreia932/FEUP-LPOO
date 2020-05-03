package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.*;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveDownCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveLeftCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveRightCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveUpCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static lpoo.pokemonascii.data.Player.X_MOVEMENT;
import static lpoo.pokemonascii.data.Player.Y_MOVEMENT;
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
        Position up = new Position(current.getX(), current.getY() - Y_MOVEMENT);
        Position down = new Position(current.getX(), current.getY() + Y_MOVEMENT);
        Position left = new Position(current.getX() - X_MOVEMENT, current.getY());
        Position right = new Position(current.getX() + X_MOVEMENT, current.getY());

        assertEquals(up, player.getPosition(Position.Direction.UP));
        assertEquals(down, player.getPosition(Position.Direction.DOWN));
        assertEquals(left, player.getPosition(Position.Direction.LEFT));
        assertEquals(right, player.getPosition(Position.Direction.RIGHT));
    }

    @Test
    public void testStateChange(){
        WorldModel model = new WorldModel(player);
        WorldView gui = Mockito.mock(WorldView.class);
        WorldController worldController = new WorldController(gui, model);

        Command up = new PlayerMoveUpCommand(worldController);
        Command down = new PlayerMoveDownCommand(worldController);
        Command left = new PlayerMoveLeftCommand(worldController);
        Command right = new PlayerMoveRightCommand(worldController);

        up.execute();
        assertEquals(Player.State.BACK, player.getState());

        down.execute();
        assertEquals(Player.State.FRONT, player.getState());

        left.execute();
        assertEquals(Player.State.LEFT, player.getState());

        right.execute();
        assertEquals(Player.State.RIGHT, player.getState());
    }
}
