package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Player;
import lpoo.pokemonascii.game.World;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveUpCommand implements Command {
    private World world;

    public PlayerMoveUpCommand(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        Position position = world.getPlayer().getPosition().up();
        world.movePlayer(position);
        world.changePlayerImage(Player.direction.BACK);
    }
}
