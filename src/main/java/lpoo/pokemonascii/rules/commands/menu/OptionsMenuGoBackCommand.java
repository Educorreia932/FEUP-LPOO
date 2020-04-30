package lpoo.pokemonascii.rules.commands.menu;

import lpoo.pokemonascii.rules.BattleController;
import lpoo.pokemonascii.rules.commands.Command;

public class OptionsMenuGoBackCommand implements Command {
    private BattleController battle;

    public OptionsMenuGoBackCommand(BattleController battle) {
        this.battle = battle;
    }

    @Override
    public void execute() {
        battle.setOptionsMenu();
    }
}
