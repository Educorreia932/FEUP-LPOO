package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Map;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveDownCommand implements Command {
    private Map map;

    public PlayerMoveDownCommand(Map map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Position position = map.getPlayer().getPosition().down();
        map.movePlayer(position);
    }
}
