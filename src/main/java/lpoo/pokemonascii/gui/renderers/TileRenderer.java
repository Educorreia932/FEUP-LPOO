package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Tile;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileRenderer extends Renderer {
    private List<Tile> tiles;

    public TileRenderer(List<Tile> tiles) {
        this.tiles = tiles;

        Image grass = new Image("tiles\\grass");

        sprite = new Sprite(new ArrayList<>(Collections.singletonList(grass)));
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (Tile t : tiles){
            sprite.setCurrentImage(t.getState().ordinal());
            drawSprite(sprite, t.getPosition(), graphics, true);
        }
    }
}
