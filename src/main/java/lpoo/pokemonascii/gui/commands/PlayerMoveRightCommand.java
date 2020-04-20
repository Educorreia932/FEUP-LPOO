package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.data.Direction;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveRightCommand implements Command {
    private WorldController controller;

    public PlayerMoveRightCommand(WorldController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.movePlayer(Direction.RIGHT);
//        world.changePlayerImage(Player.direction.RIGHT);
    }
}
