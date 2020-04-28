package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.WorldView;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GameController {
    private GameView gui;

    public enum GameMode {
        WORLD,
        BATTLE,
        ENDGAME
    }

    public GameController(GameView gui) {
        this.gui = gui;
    }

    public void run(GameMode gamemode) throws IOException, SAXException, ParserConfigurationException {
        WorldModel world = new WorldModel();

        while (!gamemode.equals(GameMode.ENDGAME)) {
            switch (gamemode) {
                case WORLD:
                    WorldView worldGui = new WorldView(gui.getScreen(), gui.getGraphics(), world);
                    WorldController worldController = new WorldController(worldGui, world);

                    gamemode = worldController.start();
                    break;
                case BATTLE:
                    BattleModel battle = new BattleModel(6);
                    BattleView battleGui = new BattleView(gui.getScreen(), gui.getGraphics(), battle);
                    BattleController battleController = new BattleController(battleGui, battle);

                    gamemode = battleController.start();
                    break;
            }
        }
    }
}
