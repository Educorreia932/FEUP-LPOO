package commands;

import game.Map;
import geometry.Position;

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
