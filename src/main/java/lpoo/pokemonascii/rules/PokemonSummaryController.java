package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.gui.PokemonSummaryView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.state.GameState;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PokemonSummaryController  {
    private PokemonSummaryView gui;
    private PokemonSummaryModel model;

    public PokemonSummaryController(PokemonSummaryView gui, PokemonSummaryModel model) {
        this.gui = gui;
        this.model = model;
    }

    public GameState.Gamemode start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException {
        while (true) {
            gui.draw();
        }
    }
}
