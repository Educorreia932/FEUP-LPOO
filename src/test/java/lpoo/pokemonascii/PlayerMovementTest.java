package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveDownCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveLeftCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveRightCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveUpCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static lpoo.pokemonascii.data.Player.X_MOVEMENT;
import static lpoo.pokemonascii.data.Player.Y_MOVEMENT;

public class PlayerMovementTest {
    private WorldModel world;
    private WorldController controller;
    private Command command;

    @Before
    public void init() {
        world = new WorldModel();
        controller = new WorldController(Mockito.mock(WorldView.class), world);
    }

    @Test
    public void PlayerMoveUpTest() {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveUpCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.up(Y_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveDownTest() {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveDownCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.down(Y_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveRightTest() {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveRightCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.right(X_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveLeftTest() {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveLeftCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.left(X_MOVEMENT), after);
    }
}
