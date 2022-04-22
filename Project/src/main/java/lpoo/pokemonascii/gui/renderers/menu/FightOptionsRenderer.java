package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.options.fight.FightOption;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;

import java.io.File;

public class FightOptionsRenderer extends OptionsMenuRenderer {
    private final OptionsMenuModel model;
    private final TextRenderer movePP;
    private final TextRenderer moveType;

    public FightOptionsRenderer(OptionsMenuModel options) {
        super(options, 30, 123, 115, 18);

        position = new Position(0, 112);
        background = new Sprite("fight_options");
        model = options;
        movePP = new TextRenderer(334, 123, getSelectedMovePP(), "normal");
        moveType = new TextRenderer(319, 139, getSelectedMoveType(), "normal");
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);

        movePP.setText(getSelectedMovePP());
        moveType.setText(getSelectedMoveType());

        movePP.draw(graphics);
        moveType.draw(graphics);
    }

    private String getSelectedMovePP() {
        PokemonMove move = ((FightOption) model.getSelectedOption()).getMove();

        return move.getCurrentPP() + "/"  + move.getTotalPP();
    }

    private String getSelectedMoveType() {
        return ((FightOption) model.getSelectedOption()).getMove().getType().getName();
    }
}
