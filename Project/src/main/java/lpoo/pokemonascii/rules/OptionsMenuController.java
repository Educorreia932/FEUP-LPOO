package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;

public class OptionsMenuController {
    private OptionsMenuModel options;

    public OptionsMenuController(OptionsMenuModel options) {
        this.options = options;
    }

    public void changeSelectedOption(Position.Direction direction) {
        options.setSelectedOption(direction);
    }

    public Option getSelectedOption() {
        return options.getOptions().get(options.getSelectedOptionNumber());
    }

    public void setOptions(OptionsMenuModel options) {
        this.options = options;
    }
}
