package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Sprite;

public class PokemonInfoRenderer extends Renderer {
    private Position position;
    private TextRenderer pokemonName;
    private HealthBarRenderer health;

    public PokemonInfoRenderer(Pokemon pokemon) {
        switch (pokemon.getFacingDirection()) {
            case FRONT: // TODO: Strategy Pattern ?
                sprite = new Sprite("adversary_pokemon_bar");
                position = new Position(20, 10);
                pokemonName = new TextRenderer(26, 14, pokemon.getName());
                health = new HealthBarRenderer(85, 27, pokemon);
                break;
            case BACK:
                sprite = new Sprite("trainer_pokemon_bar");
                position = new Position(215, 74);
                pokemonName = new TextRenderer(234, 78, pokemon.getName());
                health = new HealthBarRenderer(295, 91, pokemon);
                break;
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
        pokemonName.draw(graphics);
        health.draw(graphics);
    }
}
