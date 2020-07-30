package lpoo.pokemonascii.gui.renderers.bar;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.List;

public class HealthBarRenderer extends BarRenderer {
    enum Health {
        HIGH,
        MEDIUM,
        LOW,
    }

    private Pokemon pokemon;

    public HealthBarRenderer(int x, int y, Pokemon pokemon) {
        super(x, y);
        this.pokemon = pokemon;
        barWidth = 80;

        List<Image> images = new ArrayList<>();

        images.add(new Image("bar\\green_life_bar"));
        images.add(new Image("bar\\yellow_life_bar"));
        images.add(new Image("bar\\red_life_bar"));

        sprite = new Sprite(images);
    }

    public void draw(TextGraphics graphics) {
        percentage = pokemon.getCurrentHealthPercentage();

        if (percentage <= 0.2)
            sprite.setCurrentImage(Health.LOW.ordinal());

        else if (percentage <= 0.5)
            sprite.setCurrentImage(Health.MEDIUM.ordinal());

        else
            sprite.setCurrentImage(Health.HIGH.ordinal());

        super.draw(graphics);
    }
}
