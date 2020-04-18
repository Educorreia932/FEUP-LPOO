package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Player;
import lpoo.pokemonascii.game.World;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveDownCommand implements Command {
    private World world;

    public PlayerMoveDownCommand(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        Position position = world.getPlayer().getPosition().down();
        world.movePlayer(position);
        world.changePlayerImage(Player.direction.FRONT);
    }
}
