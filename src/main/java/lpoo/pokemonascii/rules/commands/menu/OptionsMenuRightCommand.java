package lpoo.pokemonascii.rules.commands.menu;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.rules.OptionsMenuController;
import lpoo.pokemonascii.rules.commands.Command;

public class OptionsMenuRightCommand implements Command {
    private OptionsMenuController menu;

    public OptionsMenuRightCommand(OptionsMenuController menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.changeSelectedOption(Position.Direction.RIGHT);
    }
}
