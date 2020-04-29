package lpoo.pokemonascii.gui.renderers.pokemon;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;

import java.util.ArrayList;
import java.util.List;

public class PokemonRenderer extends Renderer {
    private Pokemon pokemon;

    public PokemonRenderer(Pokemon pokemon) {
        this.pokemon = pokemon;

        List<Image> images = new ArrayList<>();
        images.add(new Image("pokemon\\front\\" + pokemon.getPokedexNumber()));
        images.add(new Image("pokemon\\back\\" + pokemon.getPokedexNumber()));

        sprite = new Sprite(images);
    }

    @Override
    public void draw(TextGraphics graphics) {
        sprite.setCurrentImage(pokemon.getFacingDirection().ordinal());
        drawSprite(sprite, pokemon.getPosition(), graphics, true);
    }
}
