package lpoo.pokemonascii.data;

import java.util.List;

public class PokemonStats {
    int hp, attack, defense, sp_atk, sp_def, speed;

    public PokemonStats(List<Integer> stats) {
        this.hp = stats.get(0);
        this.attack = stats.get(1);
        this.defense = stats.get(2);
        this.sp_atk = stats.get(3);
        this.sp_def = stats.get(4);
        this.speed = stats.get(5);
    }
}
