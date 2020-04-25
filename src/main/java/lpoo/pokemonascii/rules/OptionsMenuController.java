package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.OptionsMenuModel;
import lpoo.pokemonascii.data.Position;


public class OptionsMenuController {
    private OptionsMenuModel options;

    public OptionsMenuController(OptionsMenuModel options) {
        this.options = options;
    }

    public void changeSelectedOption(Position.Direction direction) {
        options.setSelectedOption(direction);
    }
}
