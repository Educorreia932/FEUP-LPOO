package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.BattleController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Battle implements State {
    private BattleController controller;
    private BattleModel model;
    private BattleView view;

    public Battle(GameView gui, Player player) throws ParserConfigurationException, SAXException, IOException {
        model = new BattleModel(player);
        view = new BattleView(gui.getScreen(), gui.getGraphics(), model);
        controller = new BattleController(view, model);
    }

    @Override
    public void start(GameState game, GameView gui) {
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

