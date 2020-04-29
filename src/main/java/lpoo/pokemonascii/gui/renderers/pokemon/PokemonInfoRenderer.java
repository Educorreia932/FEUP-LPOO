package lpoo.pokemonascii.gui.renderers.pokemon;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;
import lpoo.pokemonascii.gui.renderers.bar.ExperienceBarRenderer;
import lpoo.pokemonascii.gui.renderers.bar.HealthBarRenderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

public class PokemonInfoRenderer extends Renderer {
    private Position position;
    private TextRenderer pokemonName;
    private TextRenderer pokemonLevel;
    private ExperienceBarRenderer experience;
    private HealthBarRenderer health;

    public PokemonInfoRenderer(Pokemon pokemon) {
        switch (pokemon.getFacingDirection()) {
            case FRONT: // TODO: Strategy Pattern ?
                sprite = new Sprite("adversary_pokemon_info");
                position = new Position(20, 10);
                pokemonName = new TextRenderer(position.getX() + 11, position.getY() + 5, pokemon.getName());
                pokemonLevel = new TextRenderer(position.getX() + 103, position.getY() + 5, "Lv" + pokemon.getLevel());
                health = new HealthBarRenderer(position.getX() + 65, position.getY() + 17, pokemon);
                experience = null; // TODO: Introduce Null object
                break;
            case BACK:
                sprite = new Sprite("trainer_pokemon_info");
                position = new Position(215, 74);
                pokemonName = new TextRenderer(position.getX() + 26, position.getY() + 5, pokemon.getName());
                pokemonLevel = new TextRenderer(position.getX() + 119, position.getY() + 5, "Lv" + pokemon.getLevel());
                health = new HealthBarRenderer(position.getX() + 80, position.getY() + 17, pokemon);
                experience = new ExperienceBarRenderer(position.getX() + 54, position.getY() + 33, pokemon);
                break;
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
        pokemonName.draw(graphics);
        pokemonLevel.draw(graphics);
        health.draw(graphics);

        if (experience != null)
            experience.draw(graphics);
    }
}
