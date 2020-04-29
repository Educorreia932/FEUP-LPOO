package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.BattleOptionsModel;
import lpoo.pokemonascii.data.options.FightOptionsModel;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import java.util.ArrayList;
import java.util.List;

public class OptionsMenuRenderer extends Renderer {
    private final int X_DISPLACEMENT = 100;
    private final int Y_DISPLACEMENT = 20;

    private Position position;
    private OptionsMenuModel options;
    private List<TextRenderer> optionsNames;
    private Sprite background;
    private Sprite arrow = new Sprite("selectionArrow");

    public OptionsMenuRenderer(OptionsMenuModel options) {
        this.options = options;
        optionsNames = new ArrayList<>();
        int x = 230;
        int y = 122;
        int xOffset = 0;
        int yOffset = 0;

        for (Option option : options.getOptions()) {
            optionsNames.add(new TextRenderer(x + xOffset, y + yOffset, option.getName()));

            xOffset += X_DISPLACEMENT;

            if (xOffset >= X_DISPLACEMENT * Math.sqrt(options.getOptions().size())) {
                xOffset = 0;
                yOffset += Y_DISPLACEMENT;
            }
        }

        if (options instanceof BattleOptionsModel) {
            position = new Position(200, 112);
            background = new Sprite("battle_options");
        }

        else if (options instanceof FightOptionsModel) {
            position = new Position(0, 112);
            background = new Sprite("fight_options");
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(background, position, graphics, false);

        for (int i = 0; i < optionsNames.size(); i++) {
            TextRenderer optionName = optionsNames.get(i);

            if (i == options.getSelectedOption())
                drawSprite(arrow, optionName.getPosition().left(13).up(1), graphics, true);

            optionsNames.get(i).draw(graphics);
        }
    }
}
