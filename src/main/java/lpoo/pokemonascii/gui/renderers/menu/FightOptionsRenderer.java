package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;


public class FightOptionsRenderer extends OptionsRenderer {
    public FightOptionsRenderer(OptionsMenuModel options) {
        super(options, 30, 123, 115, 18);

        position = new Position(0, 112);
        background = new Sprite("fight_options");
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
    }
}
