package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.GameController;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException {
        GameController.GameMode gameMode = GameController.GameMode.WORLD;
        GameView gameGui = new GameView(300, 110);
        GameController gameController = new GameController(gameGui);

        gameController.run(gameMode);
    }
}
