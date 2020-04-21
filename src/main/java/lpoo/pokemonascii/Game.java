package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.GameController;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException {
        int gamemode = 1;
        GameView gameGui = new GameView(300, 110);
        GameController gameController = new GameController(gameGui);

        gameController.run(gamemode);
    }
}
