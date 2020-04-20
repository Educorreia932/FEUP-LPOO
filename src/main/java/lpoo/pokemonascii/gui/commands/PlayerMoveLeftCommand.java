package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.data.Direction;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveLeftCommand implements Command {
    private WorldController controller;

    public PlayerMoveLeftCommand(WorldController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.movePlayer(Direction.LEFT);
//        world.changePlayerImage(Player.direction.LEFT);
    }
}
