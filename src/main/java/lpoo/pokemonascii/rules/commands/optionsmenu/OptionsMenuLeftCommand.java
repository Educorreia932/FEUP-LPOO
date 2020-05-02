package lpoo.pokemonascii.rules.commands.optionsmenu;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.OptionsMenuController;
import lpoo.pokemonascii.rules.commands.Command;

public class OptionsMenuLeftCommand implements Command {
    private OptionsMenuController menu;

    public OptionsMenuLeftCommand(OptionsMenuController menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.changeSelectedOption(Position.Direction.LEFT);
    }
}
