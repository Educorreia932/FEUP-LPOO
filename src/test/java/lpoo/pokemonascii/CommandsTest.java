/*
package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.rules.commands.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandsTest {
    private WorldModel world;

    @Before
    public void init(){
        world = new WorldModel();
        world.removeObstacles();
    }

    @Test
    public void testLeft(){
        world.movePlayer(new Position(4, 4));
        Position position = new Position(0, 4);
        Command left = new PlayerMoveLeftCommand(world);

        left.execute();
        assertEquals(position, world.getPlayer().getPosition());
    }

    @Test
    public void testRight(){
        world.movePlayer(new Position(4, 4));

        Position position = new Position(8, 4);
        Command right = new PlayerMoveRightCommand(world);
        right.execute();

        assertEquals(position, world.getPlayer().getPosition());
    }

    @Test
    public void testUp(){
        world.movePlayer(new Position(4, 4));

        Position position = new Position(4, 0);
        Command up = new PlayerMoveUpCommand(world);
        up.execute();
        assertEquals(position, world.getPlayer().getPosition());
    }

    @Test
    public void testDown(){
        world.movePlayer(new Position(4, 4));

        Position position = new Position(4, 8);
        Command down = new PlayerMoveDownCommand(world);
        down.execute();
        assertEquals(position, world.getPlayer().getPosition());
    }
}
*/
