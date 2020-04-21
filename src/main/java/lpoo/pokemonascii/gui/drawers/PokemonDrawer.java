package lpoo.pokemonascii.gui.drawers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;

public class PokemonDrawer extends Drawer {
    private Pokemon pokemon;

    public PokemonDrawer(Pokemon pokemon) {
        this.pokemon = pokemon;
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
