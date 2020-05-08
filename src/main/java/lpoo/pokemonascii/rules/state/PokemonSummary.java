package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.PokemonSummaryView;
import lpoo.pokemonascii.rules.PokemonSummaryController;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PokemonSummary implements State {
    private PokemonSummaryModel model;
    private PokemonSummaryView view;
    private PokemonSummaryController controller;

    public PokemonSummary(GameView gui, Pokemon pokemon) {
        model = new PokemonSummaryModel(pokemon);
        view = new PokemonSummaryView(gui.getScreen(), gui.getGraphics(), model);
        controller = new PokemonSummaryController(view, model);
    }

    @Override
    public void start(GameState game) throws UnsupportedAudioFileException, IOException, LineUnavailableException, ParserConfigurationException, SAXException {
        game.setState(this);

        controller.start(game);
    }
}
