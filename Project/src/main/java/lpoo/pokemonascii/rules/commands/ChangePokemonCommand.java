package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.rules.BattleController;

public class ChangePokemonCommand implements Command {
    private BattleController battle;

    public ChangePokemonCommand(BattleController battle) {
        this.battle = battle;
    }

    @Override
    public void execute() {
        battle.changePlayerPokemon();
        battle.getGui().changePokemon(battle.getModel().getTrainerPokemon());
    }
}
