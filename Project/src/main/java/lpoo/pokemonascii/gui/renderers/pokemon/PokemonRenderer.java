package lpoo.pokemonascii.gui.renderers.pokemon;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class PokemonRenderer implements Renderer {
    private final Pokemon pokemon;
    private Sprite sprite;
    private final Position position;

    public PokemonRenderer(int x, int y, Pokemon pokemon) {
        this.pokemon = pokemon;
        this.position = new Position(x, y);

        List<Image> images = new ArrayList<>();
        images.add(new Image("pokemon" + File.separator + "front" + File.separator + pokemon.getPokedexNumber()));
        images.add(new Image("pokemon" + File.separator + "back" + File.separator + pokemon.getPokedexNumber()));

        sprite = new Sprite(images);
    }

    @Override
    public void draw(TextGraphics graphics) {
        sprite.setCurrentImage(pokemon.getFacingDirection().ordinal());
        drawSprite(sprite, position, graphics, true);
    }

    public void setPokemon(Pokemon pokemon) {
        List<Image> images = new ArrayList<>();
        images.add(new Image("pokemon" + File.separator + "front" + File.separator + pokemon.getPokedexNumber()));
        images.add(new Image("pokemon" + File.separator + "back" + File.separator + pokemon.getPokedexNumber()));

        sprite = new Sprite(images);
    }
}
