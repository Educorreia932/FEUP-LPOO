package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

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
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Transparency
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + pokemon.getPosition().getX(), j + pokemon.getPosition().getY(), characters[j][i]);
            }
        }
    }
}
