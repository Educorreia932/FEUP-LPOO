package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.PokemonTile;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.state.GameState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class WorldController {
    private WorldView gui;
    private WorldModel world;
    boolean inBattle = false;

    public WorldController(WorldView gui, WorldModel world) {
        this.gui = gui;
        this.world = world;
    }

    public void start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        while (true) {
            gui.drawWorld();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand){
                game.setState(null);
                break;
            }

            if (inBattle){
                inBattle = false;
                break;
            }
        }
    }

    public void movePlayer(Position.Direction direction) {
        if (world.canPlayerMove(direction)){
            world.setPlayerPosition(direction);
            CollidingElement tile = world.isPlayerInTile();
            if (tile instanceof PokemonTile)
                inBattle = ((PokemonTile) tile).foundPokemon();
        }
    }

    public void setPlayerState(Player.State state) {
        world.getPlayer().setState(state);
    }
}
