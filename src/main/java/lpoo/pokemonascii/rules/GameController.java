package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.WorldView;
import org.xml.sax.SAXException;

import java.io.IOException;

public class GameController {
    private GameView gui;

    public GameController(GameView gui) {
        this.gui = gui;
    }

    public int run(int gamemode) throws IOException, SAXException {
        while (gamemode > -1){
            switch (gamemode) {
                case 0:
                    WorldModel world = new WorldModel();
                    WorldView worldGui = new WorldView(gui.getScreen(), gui.getGraphics(), world);
                    WorldController worldController = new WorldController(worldGui, world);

                    gamemode = worldController.start();
                    break;
                case 1:
                    BattleModel battle = new BattleModel(20);
                    BattleView battleGui = new BattleView(gui.getScreen(), gui.getGraphics(), battle);
                    BattleController battleController = new BattleController(battleGui, battle);

                    gamemode = battleController.start();
                    break;
            }
        }

        return 0;
    }
}
