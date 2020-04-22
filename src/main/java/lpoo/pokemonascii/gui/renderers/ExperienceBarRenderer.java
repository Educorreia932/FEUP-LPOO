package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonExperience;
import lpoo.pokemonascii.gui.Sprite;


public class ExperienceBarRenderer extends BarRenderer {
    private Pokemon pokemon;

    public ExperienceBarRenderer(int x, int y, Pokemon pokemon) {
        super(x, y);
        this.pokemon = pokemon;
        barWidth = 106;

        sprite = new Sprite("bar\\experience_bar");
    }

    @Override
    public void draw(TextGraphics graphics) {
        percentage = PokemonExperience.getExperiencePercentage(pokemon);

        for (int i = 0; i < barWidth * percentage; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);
    }
}
