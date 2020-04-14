package commands;

import game.Map;
import geometry.Position;

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
