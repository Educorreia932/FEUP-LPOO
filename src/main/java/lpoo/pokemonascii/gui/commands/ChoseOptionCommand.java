package lpoo.pokemonascii.gui.commands;

import lpoo.pokemonascii.rules.BattleController;

public class ChoseOptionCommand implements Command {
    private BattleController battle;

    public ChoseOptionCommand(BattleController battle) {
        this.battle = battle;
    }

    @Override
    public void execute() {
        battle.executeOption(battle.getOptions().getSelectedOption());
    }
}
