package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.WorldController;

public class PlayerMoveUpCommand implements Command {
    private WorldController controller;

    public PlayerMoveUpCommand(WorldController world) {
        this.controller = world;
    }

    @Override
    public void execute() {
        controller.movePlayer(Position.Direction.UP);
        controller.setPlayerState(Player.State.BACK);
    }
}
