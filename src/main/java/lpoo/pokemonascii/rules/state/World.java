package lpoo.pokemonascii.rules.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;


public class World implements State {
    private WorldView view;
    private WorldModel model;
    private WorldController controller;

    public World(Screen screen, TextGraphics graphics) {
        model = new WorldModel();
        view = new WorldView(screen, graphics, model);
        controller = new WorldController(view, model);
    }

    @Override
    public void start(GameState game) throws IOException, LineUnavailableException {
        game.setState(this);
        controller.start(game);
    }
}

