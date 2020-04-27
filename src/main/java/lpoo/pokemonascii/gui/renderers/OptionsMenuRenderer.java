package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Option;
import lpoo.pokemonascii.data.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.List;

public class OptionsMenuRenderer extends Renderer {
    OptionsMenuModel options;
    List<TextRenderer> optionsNames;
    private final int X_DISPLACEMENT = 100;
    private final int Y_DISPLACEMENT = 20;
    Sprite arrow = new Sprite("selectionArrow");

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
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (int i = 0; i < optionsNames.size(); i++) {
            TextRenderer optionName = optionsNames.get(i);

            if (i == options.getSelectedOption())
                drawSprite(arrow, optionName.getPosition().left(13).up(1), graphics, true);

            optionsNames.get(i).draw(graphics);
        }
    }
}
