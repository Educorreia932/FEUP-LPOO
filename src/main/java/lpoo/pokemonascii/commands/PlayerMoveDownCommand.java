package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Game;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveDownCommand implements Command {
    private Game game;

    public PlayerMoveDownCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        Position position = game.getMap().getPlayer().getPosition().down();
        game.getMap().movePlayer(position);
    }
}
