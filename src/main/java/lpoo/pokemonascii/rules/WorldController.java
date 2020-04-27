package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.QuitCommand;

import java.io.IOException;

public class WorldController {
    private WorldView gui;
    private WorldModel world;
    boolean inBattle = false;

    public WorldController(WorldView gui, WorldModel world) {
        this.gui = gui;
        this.world = world;
    }

    public GameController.GameMode start() throws IOException {
        while (true) {
            gui.drawWorld();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                return GameController.GameMode.ENDGAME;

            if (inBattle){
                gui.drawWorld();
                inBattle = false;
                return GameController.GameMode.BATTLE;
            }
        }
    }

    public void movePlayer(Position.Direction direction) {
        if (world.canPlayerMove(direction)){
            world.setPlayerPosition(direction);
            if (world.foundPokemon())
                inBattle = true;
        }
    }

    public void setPlayerState(Player.State state) {
        world.getPlayer().setState(state);
    }
}
