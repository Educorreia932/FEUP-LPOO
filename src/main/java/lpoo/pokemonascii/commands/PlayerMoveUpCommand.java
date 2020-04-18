package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Map;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveUpCommand implements Command {
    private Map map;

    public PlayerMoveUpCommand(Map map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Position position = map.getPlayer().getPosition().up();
        map.movePlayer(position);
    }
}
