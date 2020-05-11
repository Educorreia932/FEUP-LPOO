package lpoo.pokemonascii.rules.commands.optionsmenu;

import lpoo.pokemonascii.rules.BattleController;
import lpoo.pokemonascii.rules.commands.Command;

public class ChangeOptionsMenuCommand implements Command {
    private BattleController battle;
    private BattleController.OptionsMenu options;

    public ChangeOptionsMenuCommand(BattleController battle, BattleController.OptionsMenu options) {
        this.battle = battle;
        this.options = options;
    }

    @Override
    public void execute() {
        battle.setOptionsMenu(options);
    }
}
