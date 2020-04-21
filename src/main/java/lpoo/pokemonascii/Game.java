package lpoo.pokemonascii;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.BattleController;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {


        int gamemode = 1;

        switch (gamemode) {
            case 0:
                WorldModel world = new WorldModel();
                WorldView gui = new WorldView(300, 110, world);
                WorldController controller = new WorldController(gui, world);

                controller.start();
                break;
            case 1:
                BattleModel battle = new BattleModel(20);
                BattleView gui1 = new BattleView(300, 110, battle);
                BattleController controller1 = new BattleController(gui1, battle);

                controller1.start();
                break;
        }
    }
}
