package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Player;
import lpoo.pokemonascii.game.World;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveRightCommand implements Command {
    private World world;

    public PlayerMoveRightCommand(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        Position position = world.getPlayer().getPosition().right();
        world.movePlayer(position);
        world.changePlayerImage(Player.direction.RIGHT);
    }
}
