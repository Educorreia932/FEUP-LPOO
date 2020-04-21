package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.GameController;


import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {

        int gamemode = 0;
        GameView gameGui = new GameView(300, 110);
        GameController gameController = new GameController(gameGui);

        gameController.run(gamemode);

    }
}
