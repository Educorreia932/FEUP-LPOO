package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.data.Direction;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveUpCommand implements Command {
    private WorldController controller;

    public PlayerMoveUpCommand(WorldController world) {
        this.controller = world;
    }

    @Override
    public void execute() {
        controller.movePlayer(Direction.UP);
//        world.changePlayerImage(Player.direction.BACK);
    }
}
