package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.Route6;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveDownCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveLeftCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveRightCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveUpCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static lpoo.pokemonascii.data.Player.X_MOVEMENT;
import static lpoo.pokemonascii.data.Player.Y_MOVEMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMovementTest {
    private static WorldModel world;
    private static WorldController controller;
    private Command command;

    @BeforeAll
    static void init() throws ParserConfigurationException, SAXException, IOException {
        world = new Route6();
        controller = new WorldController(Mockito.mock(WorldView.class), world);
    }

    @Test
    public void PlayerMoveUpTest() throws ParserConfigurationException, SAXException, IOException {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveUpCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.up(Y_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveDownTest() throws ParserConfigurationException, SAXException, IOException {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveDownCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.down(Y_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveRightTest() throws ParserConfigurationException, SAXException, IOException {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveRightCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.right(X_MOVEMENT), after);
    }

    @Test
    public void PlayerMoveLeftTest() throws ParserConfigurationException, SAXException, IOException {
        Position before = world.getPlayerPosition();

        command = new PlayerMoveLeftCommand(controller);
        command.execute();

        Position after = world.getPlayerPosition();

        assertEquals(before.left(X_MOVEMENT), after);
    }
}
