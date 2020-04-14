package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Map;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveRightCommand implements Command {
    private Map map;

    public PlayerMoveRightCommand(Map map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Position position = map.getPlayer().getPosition().right();
        map.movePlayer(position);
    }
}
