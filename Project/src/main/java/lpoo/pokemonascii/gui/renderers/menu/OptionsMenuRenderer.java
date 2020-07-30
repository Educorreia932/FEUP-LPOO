package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import java.util.ArrayList;
import java.util.List;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public abstract class OptionsMenuRenderer implements Renderer {
    protected Position position;
    private OptionsMenuModel options;
    protected List<TextRenderer> optionsNames;
    protected Sprite background;
    private Sprite arrow = new Sprite("selectionArrow");

    public OptionsMenuRenderer(OptionsMenuModel options, int x, int y, int xDisplacement, int yDisplacement) {
        this.options = options;
        optionsNames = new ArrayList<>();
        int xOffset = 0;
        int yOffset = 0;

        for (Option option : options.getOptions()) {
            optionsNames.add(new TextRenderer(x + xOffset, y + yOffset, option.getName(), "battle"));

            xOffset += xDisplacement;

            if (xOffset >= xDisplacement * Math.sqrt(options.getOptions().size())) {
                xOffset = 0;
                yOffset += yDisplacement;
            }
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(background, position, graphics, false);

        for (int i = 0; i < optionsNames.size(); i++) {
            TextRenderer optionName = optionsNames.get(i);

            if (i == options.getSelectedOptionNumber())
                drawSprite(arrow, optionName.getPosition().left(13).up(1), graphics, true);

            optionsNames.get(i).draw(graphics);
        }
    }
}
