package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
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

    public int start() throws IOException {
        while (true) {
            gui.drawWorld();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                return -1;
        }
    }

    public void movePlayer(Position.Direction direction) {
        if (world.canPlayerMove(direction))
            world.setPlayerPosition(direction);
    }

    public void setPlayerState(Player.State state) {
        world.getPlayer().setState(state);
    }
}
