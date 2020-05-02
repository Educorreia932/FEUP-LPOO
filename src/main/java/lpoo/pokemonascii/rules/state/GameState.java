package lpoo.pokemonascii.rules.commands.state;

import lpoo.pokemonascii.Game;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.GameController;

import java.io.IOException;

public class GameState {
    private State gamemode;
    private GameController controller;
    private GameView view;

    public GameState(State state, GameView gui) throws IOException {
        view = gui;
        controller = new GameController(view);
        gamemode = state;
    }

    public void changeState(State state){
        gamemode = state;
    }

    public void run() throws IOException {
        gamemode.start();
    }


}
