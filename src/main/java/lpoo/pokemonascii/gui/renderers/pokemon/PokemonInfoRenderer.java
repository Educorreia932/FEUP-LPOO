package lpoo.pokemonascii.gui.renderers.pokemon;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonStats;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;
import lpoo.pokemonascii.gui.renderers.bar.ExperienceBarRenderer;
import lpoo.pokemonascii.gui.renderers.bar.HealthBarRenderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class PokemonInfoRenderer implements Renderer {
    private Position position;
    private Sprite sprite;
    private Pokemon pokemon;
    private TextRenderer pokemonName;
    private TextRenderer pokemonLevel;
    private TextRenderer pokemonHealth;
    private ExperienceBarRenderer experience;
    private HealthBarRenderer healthBar;

    public PokemonInfoRenderer(Pokemon pokemon) {
        this.pokemon = pokemon;

        switch (pokemon.getFacingDirection()) {
            case FRONT: // TODO: Strategy Pattern ?
                sprite = new Sprite("adversary_pokemon_info");
                position = new Position(20, 10);
                pokemonName = new TextRenderer(position.getX() + 11, position.getY() + 5, pokemon.getName(), "battle");
                pokemonLevel = new TextRenderer(position.getX() + 103, position.getY() + 5, "Lv" + pokemon.getLevel(), "battle");
                healthBar = new HealthBarRenderer(position.getX() + 65, position.getY() + 17, pokemon);
                experience = null; // TODO: Introduce Null object
                break;
            case BACK:
                sprite = new Sprite("trainer_pokemon_info");
                position = new Position(215, 74);
                pokemonName = new TextRenderer(position.getX() + 26, position.getY() + 5, pokemon.getName(), "battle");
                pokemonLevel = new TextRenderer(position.getX() + 119, position.getY() + 5, "Lv" + pokemon.getLevel(), "battle");
                pokemonHealth = new TextRenderer(position.getX() + 100, position.getY() + 22, pokemon.getCurrentHealth() + "/" +pokemon.getStat(PokemonStats.Stat.HP), "battle");
                healthBar = new HealthBarRenderer(position.getX() + 80, position.getY() + 17, pokemon);
                experience = new ExperienceBarRenderer(position.getX() + 54, position.getY() + 33, pokemon);
                break;
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
        pokemonName.draw(graphics);
        pokemonLevel.draw(graphics);
        healthBar.draw(graphics);

        if (experience != null)
            experience.draw(graphics);

        if (pokemonHealth != null) {
            pokemonHealth.setText(pokemon.getCurrentHealth() + "/" + pokemon.getStat(PokemonStats.Stat.HP));
            pokemonHealth.draw(graphics);
        }
    }
}
