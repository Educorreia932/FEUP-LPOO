package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;
import lpoo.pokemonascii.rules.BattleController;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class BattleMenuRenderer implements Renderer {
    private Sprite sprite;
    private OptionsRenderer options;

    public BattleMenuRenderer(OptionsMenuModel options) {
        this.sprite = new Sprite("battle_menu");
        this.options = new BattleOptionsRenderer(options);
    }

    @Override
    public void draw(TextGraphics graphics) {
        Position position = new Position(0, 112);
        drawSprite(sprite, position, graphics, false);
        options.draw(graphics);
    }

    public void setOptionsMenu(BattleController.OptionsMenu optionsMenu, BattleModel battle) {
        switch (optionsMenu) {
            case FIGHT:
                options = new FightOptionsRenderer(battle.getOptions());
        }
    }
}
