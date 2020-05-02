package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.Position;

public class OptionsMenuController {
    private OptionsMenuModel options;

    public OptionsMenuController(OptionsMenuModel options) {
        this.options = options;
    }

    public void changeSelectedOption(Position.Direction direction) {
        options.setSelectedOption(direction);
    }

    public Option getSelectedOption() {
        return options.getOptions().get(options.getSelectedOption());
    }

    public void setOptions(OptionsMenuModel options) {
        this.options = options;
    }
}
