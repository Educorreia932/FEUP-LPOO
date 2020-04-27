package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.rules.BattleController;

public class UsePokemonMoveCommand implements Command {
    private BattleController battle;
    private PokemonMove move;

    public UsePokemonMoveCommand(BattleController battle, PokemonMove move) {
        this.battle = battle;
        this.move = move;
    }

    @Override
    public void execute() {
        battle.usePokemonMove(move);
    }
}
