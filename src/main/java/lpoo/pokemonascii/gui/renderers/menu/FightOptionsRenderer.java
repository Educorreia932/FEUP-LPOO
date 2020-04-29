package lpoo.pokemonascii.gui.renderers.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.List;

public class FightOptionsRenderer extends OptionsRenderer {
    public FightOptionsRenderer(List<PokemonMove> moves) {
        super(createMovesOptions(moves), 30, 123, 115, 18);

        position = new Position(0, 112);
        background = new Sprite("fight_options");
    }

    private static OptionsMenuModel createMovesOptions(List<PokemonMove> moves) {
        List<Option> options = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            try {
                options.add(new Option(moves.get(i).getName().toUpperCase()));
            }

            catch (IndexOutOfBoundsException e) {
                options.add(new Option("-"));
            }
        }

        return new OptionsMenuModel(options);
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
    }
}
