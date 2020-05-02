package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;


public class BattleOptionsRenderer extends OptionsMenuRenderer {
    public BattleOptionsRenderer(OptionsMenuModel options) {
        super(options, 230, 123, 100, 18);

        position = new Position(200, 112);
        background = new Sprite("battle_options");
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
    }
}
