package lpoo.pokemonascii.rules.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class World implements State {
    private WorldView view;
    private WorldModel model;
    private WorldController controller;

    public World(GameView gui) {
        model = new WorldModel();
        view = new WorldView(gui.getScreen(), gui.getGraphics(), model);
        controller = new WorldController(view, model);
    }

    public World() {
        model = new WorldModel();
        controller = new WorldController(view, model);
    }

    @Override
    public void start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException {
        game.setState(this);

        switch (controller.start(game)) {
            case BATTLE:
                game.setState(new Battle(game.getGui()));
                break;
            case EXIT:
                game.setState(null);
                break;
        }
    }
}

