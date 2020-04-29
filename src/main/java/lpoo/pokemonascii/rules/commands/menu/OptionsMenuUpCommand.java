package lpoo.pokemonascii.rules.commands.menu;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.OptionsMenuController;
import lpoo.pokemonascii.rules.commands.Command;

public class OptionsMenuUpCommand implements Command {
    private OptionsMenuController menu;

    public OptionsMenuUpCommand(OptionsMenuController menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.changeSelectedOption(Position.Direction.UP);
    }
}
