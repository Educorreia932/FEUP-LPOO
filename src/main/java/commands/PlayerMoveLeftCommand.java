package commands;

import game.Map;
import geometry.Position;

public class PlayerMoveLeftCommand implements Command {
    private Map map;

    public PlayerMoveLeftCommand(Map map) {
        this.map = map;
    }

    @Override
    public void execute() {
        Position position = map.getPlayer().getPosition().left();
        map.movePlayer(position);
    }
}
