package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.PokemonSummaryView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.state.GameState;

public class PokemonSummaryController implements Controller {
    private PokemonSummaryView gui;
    private PokemonSummaryModel model;
    private GameState.Gamemode gamemode;

    public PokemonSummaryController(PokemonSummaryView gui, PokemonSummaryModel model) {
        this.gui = gui;
        this.model = model;
        gamemode = GameState.Gamemode.SUMMARY;
    }

    public GameState.Gamemode start(GameState game) {
        gamemode = GameState.Gamemode.SUMMARY;

        while (gamemode == GameState.Gamemode.SUMMARY) {
            gui.draw();

            Command command;
            command = gui.getNextCommand(this);
            command.execute();
        }

        return gamemode;
    }

    @Override
    public void setGamemode(GameState.Gamemode gamemode) {
        this.gamemode = gamemode;
    }

    public void changeSelectedPokemon(Position.Direction direction) {
        int selectedPokemon = model.getSelectedPokemon();

        switch (direction) {
            case UP:
                model.setSelectedPokemon(Math.max(selectedPokemon - 1, 0));
                break;
            case DOWN:
                model.setSelectedPokemon(Math.min(selectedPokemon + 1, model.getPokemons().size() - 1));
                break;
        }
    }
}
