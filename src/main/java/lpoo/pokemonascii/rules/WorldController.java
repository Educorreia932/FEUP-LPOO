package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Direction;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.gui.commands.Command;
import lpoo.pokemonascii.gui.commands.QuitCommand;

import java.io.IOException;

public class WorldController {
    private WorldView gui;
    private WorldModel world;

    public WorldController(WorldView gui, WorldModel world) {
        this.gui = gui;
        this.world = world;
    }

    public void start() throws IOException {
        while (true) {
            gui.drawWorld(world);

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                break;
        }
    }

    public void movePlayer(Direction direction) {
        if (world.canPlayerMove(direction))
            world.setPlayerPosition(direction);
    }
}
