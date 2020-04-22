package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.List;

public class HealthBarRenderer extends Renderer {
    enum Health {
        HIGH,
        MEDIUM,
        LOW,
    }

    private Pokemon pokemon;
    private Position position;
    private static int BAR_WIDTH = 80;
    private float percentage;

    HealthBarRenderer(int x, int y, Pokemon pokemon) {
        this.position = new Position(x, y);
        this.pokemon = pokemon;

        List<Image> images = new ArrayList<>();

        images.add(new Image("bar\\green_life_bar"));
        images.add(new Image("bar\\yellow_life_bar"));
        images.add(new Image("bar\\red_life_bar"));

        sprite = new Sprite(images);
    }

    @Override
    public void draw(TextGraphics graphics) {
        float percentage = pokemon.getCurrentHealthPercentage();

        if (percentage <= 0.2)
            sprite.setCurrentImage(Health.LOW.ordinal());

        else if (percentage <= 0.5)
            sprite.setCurrentImage(Health.MEDIUM.ordinal());

        else
            sprite.setCurrentImage(Health.HIGH.ordinal());

        for (int i = 0; i < BAR_WIDTH * percentage; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);
    }
}
