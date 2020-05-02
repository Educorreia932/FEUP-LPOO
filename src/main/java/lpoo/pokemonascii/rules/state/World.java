package lpoo.pokemonascii.rules.commands.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;

import java.awt.*;
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
    public void start() throws IOException {
        controller.start();
    }
}
