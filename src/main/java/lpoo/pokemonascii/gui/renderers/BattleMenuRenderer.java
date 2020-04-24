package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;

public class BattleMenuRenderer extends Renderer {
    private final Sprite optionsSprite;

    public BattleMenuRenderer() {
        this.sprite = new Sprite("battle_menu");
        optionsSprite = new Sprite("battle_options");
    }

    @Override
    public void draw(TextGraphics graphics) {
        Position position = new Position(0, 112);
        drawSprite(sprite, position, graphics, false);
        drawSprite(optionsSprite,position.right(200), graphics, false);
    }
}
