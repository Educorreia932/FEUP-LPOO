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
        BACKGROUND
    }

    private Pokemon pokemon;
    private Position position;
    private static int BAR_WIDTH = 80;

    HealthBarRenderer(int x, int y, Pokemon pokemon) {
        this.position = new Position(x, y);
        this.pokemon = pokemon;

        List<Image> images = new ArrayList<>();

        images.add(new Image("health_bar\\green_life_bar"));
        images.add(new Image("health_bar\\yellow_life_bar"));
        images.add(new Image("health_bar\\red_life_bar"));
        images.add(new Image("health_bar\\life_bar_background"));

        sprite = new Sprite(images);
    }

    @Override
    public void draw(TextGraphics graphics) {
        //TODO: Maybe have two sprites
        sprite.setCurrentImage(Health.BACKGROUND.ordinal());

        for (int i = 0; i < BAR_WIDTH; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);

        sprite.setCurrentImage(Health.HIGH.ordinal());

        for (int i = 0; i < BAR_WIDTH; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);
    }
}
