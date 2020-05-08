package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonRenderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import java.io.IOException;

public class PokemonSummaryView {
    private Screen screen;
    private TextGraphics graphics;
    private TextRenderer pokedexNumber;
    private TextRenderer pokemonSpecies;
    private TextRenderer pokemonName;
    private PokemonRenderer pokemon;
    private Sprite background;
    private Sprite info;

    public PokemonSummaryView(Screen screen, TextGraphics graphics, PokemonSummaryModel model) {
        this.screen = screen;
        this.graphics = graphics;

        pokedexNumber = new TextRenderer(0, 0, String.valueOf(model.getPokemon().getPokedexNumber()));
        pokemonSpecies = new TextRenderer(0, 0, model.getPokemon().getName());
        pokemonName = new TextRenderer(0, 0, model.getPokemon().getName());
        pokemon = new PokemonRenderer(50, 50, model.getPokemon());
    }

    public void draw() throws IOException {
        pokedexNumber.draw(graphics);
        pokemonSpecies.draw(graphics);
        pokemonName.draw(graphics);
        pokemon.draw(graphics);

        screen.refresh();
    }
}
