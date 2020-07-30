package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.tile.PokemonTile;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.commands.ChangedStateCommand;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.state.GameState;

public class WorldController implements Controller {
    private WorldView gui;
    private WorldModel world;
    private GameState.Gamemode gamemode;

    public WorldController(WorldView gui, WorldModel world) {
        this.gui = gui;
        this.world = world;
        gamemode = GameState.Gamemode.WORLD;
    }

    public GameState.Gamemode start(GameState game) {
        gamemode = GameState.Gamemode.WORLD;
        gui.running = true;

        Thread view = new Thread(gui);
        view.start();

        while (gamemode == GameState.Gamemode.WORLD) {
            Command command;
            command = gui.getNextCommand(this);
            command.execute();
        }

        gui.running = false;
        view.interrupt();

        return gamemode;
    }

    public void movePlayer(Position.Direction direction) {
        if (world.canPlayerMove(direction)){
            world.setPlayerPosition(direction);
            CollidingElement tile = world.isPlayerInTile();

            if (tile instanceof PokemonTile)
                if (((PokemonTile) tile).foundPokemon())
                    new ChangedStateCommand(this, GameState.Gamemode.BATTLE).execute();
        }

        else if(world.zoneUpdate(direction))
            gui.setBackground(world.getImage(), world.getPlayer());
    }

    public void setPlayerState(Player.State state) {
        world.getPlayer().setState(state);
    }

    @Override
    public void setGamemode(GameState.Gamemode gamemode) {
        this.gamemode = gamemode;
    }

}
