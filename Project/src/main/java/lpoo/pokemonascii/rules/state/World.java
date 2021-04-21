package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.Route6;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.WorldView;
import lpoo.pokemonascii.rules.WorldController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class World implements State {
    private WorldView view;
    private WorldModel model;
    private WorldController controller;

    public World(GameView gui) throws ParserConfigurationException, SAXException, IOException {
        model = new Route6();
        view = new WorldView(gui.getScreen(), gui.getGraphics(), model);
        controller = new WorldController(view, model);
    }

    @Override
    public void start(GameState game, GameView gui) throws IOException, ParserConfigurationException, SAXException {
        game.setState(this);

        switch (controller.start(game)) {
            case BATTLE:
                game.setState(new Battle(gui, game.getWorld().getModel().getPlayer(), model.getPokemonNumber()));
                break;
            case SUMMARY:
                game.setState(new PokemonSummary(gui, model.getPlayer().getPokemons()));
                break;
            case EXIT:
                game.setState(null);
                break;
        }
    }

    public WorldModel getModel() {
        return model;
    }
}

