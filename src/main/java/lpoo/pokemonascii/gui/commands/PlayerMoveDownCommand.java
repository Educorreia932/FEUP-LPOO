package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.data.Direction;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveDownCommand implements Command {
    private WorldController controller;

    public PlayerMoveDownCommand(WorldController world) {
        this.controller = world;
    }

    @Override
    public void execute() {
        controller.movePlayer(Direction.DOWN);
//        world.changePlayerImage(Player.direction.FRONT);
    }
}
