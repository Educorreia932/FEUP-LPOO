package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonRenderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import java.io.IOException;

public class PokemonSummaryView {
    private Screen screen;
    private Sprite background;
    private Sprite info;
    private Sprite selectedBar;
    private TextGraphics graphics;
    private TextRenderer pokedexNumber;
    private TextRenderer pokemonSpecies;
    private TextRenderer pokemonName;
    private PokemonRenderer pokemon;

    public PokemonSummaryView(Screen screen, TextGraphics graphics, PokemonSummaryModel model) {
        this.screen = screen;
        this.graphics = graphics;

        background = new Sprite("summary\\pokemon_background");
        info = new Sprite("summary\\pokemon_info");
        selectedBar = new Sprite("summary\\selected_bar");

        pokedexNumber = new TextRenderer(280, 23, String.valueOf(model.getPokemon().getPokedexNumber()));
        pokemonSpecies = new TextRenderer(80, 21, model.getPokemon().getName());
        pokemonName = new TextRenderer(280, 38, model.getPokemon().getName());
        pokemon = new PokemonRenderer(50, 35, model.getPokemon());
    }

    public void draw() throws IOException {
        Sprite.drawSprite(info, 0, 16, graphics);
        Sprite.drawSprite(background, 0, 16, graphics);
        Sprite.drawSprite(selectedBar, graphics);

        pokedexNumber.draw(graphics);
        pokemonSpecies.draw(graphics);
        pokemonName.draw(graphics);
        pokemon.draw(graphics);

        screen.refresh();
    }
}
