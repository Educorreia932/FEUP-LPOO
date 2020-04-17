package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Game;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveRightCommand implements Command {
    private Game game;

    public PlayerMoveRightCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        Position position = game.getMap().getPlayer().getPosition().right();
        game.getMap().movePlayer(position);
    }
}
