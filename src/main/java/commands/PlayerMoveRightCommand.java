package commands;

import game.Map;
import geometry.Position;

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
