package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.rules.BattleController;

public class CatchPokemonCommand implements Command {
    private BattleController battle;

    public CatchPokemonCommand(BattleController battle) {
        this.battle = battle;
    }

    @Override
    public void execute() {
        
    }
}
