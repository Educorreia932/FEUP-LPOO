package lpoo.pokemonascii.gui.renderers.pokemon;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.PokemonType;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;

public class PokemonTypeRenderer implements Renderer {
    Position position;
    Sprite sprite;

    public PokemonTypeRenderer(int x, int y, PokemonType type) {
        position = new Position(x, y);
        sprite = new Sprite("types\\" + type.getType().name().toLowerCase());
    }

    @Override
    public void draw(TextGraphics graphics) {
        Sprite.drawSprite(sprite, position, graphics, true);
    }

    public void setType(PokemonType type) {
        sprite = new Sprite("types\\" + type.getType().name().toLowerCase());
    }
}
