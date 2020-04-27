package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveRightCommand implements Command {
    private WorldController controller;

    public PlayerMoveRightCommand(WorldController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.movePlayer(Position.Direction.RIGHT);
        controller.setPlayerState(Player.State.RIGHT);
    }
}
