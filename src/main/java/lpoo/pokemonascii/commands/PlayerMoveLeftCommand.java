package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Game;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveLeftCommand implements Command {
    private Game game;

    public PlayerMoveLeftCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        Position position = game.getMap().getPlayer().getPosition().left();
        game.getMap().movePlayer(position);
    }
}
