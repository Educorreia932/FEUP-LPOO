package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.PokemonSummaryView;
import lpoo.pokemonascii.rules.PokemonSummaryController;

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
