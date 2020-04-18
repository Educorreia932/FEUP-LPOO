package lpoo.pokemonascii.commands;

import lpoo.pokemonascii.game.Player;
import lpoo.pokemonascii.game.World;
import lpoo.pokemonascii.geometry.Position;

public class PlayerMoveLeftCommand implements Command {
    private World world;

    public PlayerMoveLeftCommand(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        Position position = world.getPlayer().getPosition().left();
        world.movePlayer(position);
        world.changePlayerImage(Player.direction.LEFT);
    }
}
