package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonExperience;
import lpoo.pokemonascii.gui.Sprite;


public class ExperienceBarRenderer extends Renderer {
    private Pokemon pokemon;
    private Position position;
    private static int BAR_WIDTH = 106;

    public ExperienceBarRenderer(int x, int y, Pokemon pokemon) {
        this.position = new Position(x, y);
        this.pokemon = pokemon;

        sprite = new Sprite("bar\\experience_bar");
    }

    @Override
    public void draw(TextGraphics graphics) {
        float percentage = PokemonExperience.getExperiencePercentage(pokemon);

        for (int i = 0; i < BAR_WIDTH * percentage; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);
    }
}
