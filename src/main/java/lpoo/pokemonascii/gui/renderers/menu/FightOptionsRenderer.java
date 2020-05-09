package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.options.fight.FightOption;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;


public class FightOptionsRenderer extends OptionsMenuRenderer {
    private OptionsMenuModel model;
    private TextRenderer movePP;
    private TextRenderer moveType;

    public FightOptionsRenderer(OptionsMenuModel options) {
        super(options, 30, 123, 115, 18);

        position = new Position(0, 112);
        background = new Sprite("fight_options");
        model = options;
//        movePP = new TextRenderer(340, 120, String.valueOf(getSelectedMovePP()), "normal");
        moveType = new TextRenderer(319, 139, getSelectedMoveType(), "normal");
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);

        moveType.setText(getSelectedMoveType());
        moveType.draw(graphics);
    }

    private int getSelectedMovePP() {
        return ((FightOption) model.getOptions().get(model.getSelectedOption())).getMove().getPP();
    }

    private String getSelectedMoveType() {
        return ((FightOption) model.getOptions().get(model.getSelectedOption())).getMove().getType().getName();
    }
}
