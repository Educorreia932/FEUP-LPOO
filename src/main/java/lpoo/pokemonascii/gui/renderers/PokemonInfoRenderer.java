package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

public class PokemonInfoRenderer extends Renderer {
    private Position position;
    private TextRenderer pokemonName;

    public PokemonInfoRenderer(Pokemon pokemon) {
        switch (pokemon.getFacingDirection()) {
            case FRONT:
                sprite = new Sprite("adversary_pokemon_bar");
                position = new Position(20, 10);
                pokemonName = new TextRenderer(26, 14, pokemon.getName());
                break;
            case BACK:
                sprite = new Sprite("trainer_pokemon_bar");
                position = new Position(215, 74);
                pokemonName = new TextRenderer(234, 78, pokemon.getName());
                break;
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                // Transparency
                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + position.getX(), j + position.getY(), characters[j][i]);
            }
        }

        pokemonName.draw(graphics);
    }
}
