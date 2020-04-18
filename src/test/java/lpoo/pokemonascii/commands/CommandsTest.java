package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Map;
import lpoo.pokemonascii.geometry.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandsTest {
    private Map map;

    @Before
    public void init(){
        map = new Map();
        map.removeObstacles();
    }

    @Test
    public void testLeft(){
        map.movePlayer(new Position(4, 4));
        Position position = new Position(0, 4);
        Command left = new PlayerMoveLeftCommand(map);

        left.execute();
        assertEquals(position, map.getPlayer().getPosition());
    }

    @Test
    public void testRight(){
        map.movePlayer(new Position(4, 4));

        Position position = new Position(8, 4);
        Command right = new PlayerMoveRightCommand(map);
        right.execute();

        assertEquals(position, map.getPlayer().getPosition());
    }

    @Test
    public void testUp(){
        map.movePlayer(new Position(4, 4));

        Position position = new Position(4, 0);
        Command up = new PlayerMoveUpCommand(map);
        up.execute();
        assertEquals(position, map.getPlayer().getPosition());
    }

    @Test
    public void testDown(){
        map.movePlayer(new Position(4, 4));

        Position position = new Position(4, 8);
        Command down = new PlayerMoveDownCommand(map);
        down.execute();
        assertEquals(position, map.getPlayer().getPosition());
    }
}
