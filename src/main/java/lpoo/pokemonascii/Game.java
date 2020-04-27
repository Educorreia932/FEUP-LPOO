package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.GameController;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        GameController.GameMode gameMode = GameController.GameMode.WORLD;
        GameView gameGui = new GameView(400, 160);
        GameController gameController = new GameController(gameGui);

        gameController.run(gameMode);
    }
}
