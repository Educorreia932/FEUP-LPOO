package lpoo.pokemonascii;

import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        WorldModel world = new WorldModel();
        WorldView gui = new WorldView(300, 110);
        WorldController controller = new WorldController(gui, world);

        controller.start();
    }
}
