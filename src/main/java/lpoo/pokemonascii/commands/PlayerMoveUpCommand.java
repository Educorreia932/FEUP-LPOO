package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Game;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveUpCommand implements Command {
    private Game game;

    public PlayerMoveUpCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        Position position = game.getMap().getPlayer().getPosition().up();
        game.getMap().movePlayer(position);
    }
}
