package lpoo.pokemonascii.rules.commands.player;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.Command;

public class PlayerMoveLeftCommand implements Command {
    private WorldController controller;

    public PlayerMoveLeftCommand(WorldController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.movePlayer(Position.Direction.LEFT);
        controller.setPlayerState(Player.State.LEFT);
    }
}
