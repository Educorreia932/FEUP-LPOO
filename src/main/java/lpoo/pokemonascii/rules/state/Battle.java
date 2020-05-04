package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.BattleController;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Battle implements State {
    private BattleController controller;
    private BattleModel model;
    private BattleView view;

    public Battle(GameView gui) throws ParserConfigurationException, SAXException, IOException {
        model = new BattleModel(6);
        view = new BattleView(gui.getScreen(), gui.getGraphics(), model);
        controller = new BattleController(view, model);
    }

    public Battle() throws ParserConfigurationException, SAXException, IOException {
        model = new BattleModel(6);
        controller = new BattleController(model);
    }

    @Override
    public void start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException {
        game.setState(this);

        switch (controller.start(game)) {
            case WORLD:
                game.setState(game.getWorld());
                break;
            case EXIT:
                game.setState(null);
                break;
        }
    }
}

