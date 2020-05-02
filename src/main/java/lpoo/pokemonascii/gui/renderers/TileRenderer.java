package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Grass;
import lpoo.pokemonascii.data.Tile;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class TileRenderer implements Renderer {
    private List<Tile> tiles;
    private Sprite grassSprite;
    private Sprite sprite;

    public TileRenderer(List<Tile> tiles) {
        this.tiles = tiles;

        Image grass = new Image("tiles\\grass");
        grassSprite = new Sprite(new ArrayList<>(Arrays.asList(grass)));
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (Tile t : tiles){
            if (t instanceof Grass){
                sprite = grassSprite;
                sprite.setCurrentImage( ((Grass) t).getState().ordinal());
                drawSprite(sprite, t.getPosition(), graphics, true);
            }
        }
    }
}
