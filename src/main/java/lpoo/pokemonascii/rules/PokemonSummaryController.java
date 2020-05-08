package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.gui.PokemonSummaryView;
import lpoo.pokemonascii.rules.state.GameState;

import java.io.IOException;

public class PokemonSummaryController  {
    private PokemonSummaryView gui;
    private PokemonSummaryModel model;

    public PokemonSummaryController(PokemonSummaryView gui, PokemonSummaryModel model) {
        this.gui = gui;
        this.model = model;
    }

    public GameState.Gamemode start(GameState game) throws IOException {
        while (true) {
            gui.draw();
        }
    }
}
