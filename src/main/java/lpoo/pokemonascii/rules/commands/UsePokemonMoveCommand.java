package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.rules.BattleController;

public class UsePokemonMoveCommand implements Command {
    private BattleController battle;
    private PokemonMove move;
    private Pokemon pokemon;

    public UsePokemonMoveCommand(BattleController battle, Pokemon pokemon, PokemonMove move) {
        this.battle = battle;
        this.move = move;
        this.pokemon = pokemon;
    }

    @Override
    public void execute() {
        battle.usePokemonMove(pokemon, move);
    }
}
