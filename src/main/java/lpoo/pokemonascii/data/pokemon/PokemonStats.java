package lpoo.pokemonascii.data.pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonStats {
    enum Stat {
        HP,
        ATTACK,
        DEFENSE,
        SP_ATTACK,
        SP_DEFENSE,
        SPEED
    }

    private List<Integer> stats;

    public PokemonStats(List<Integer> stats) {
        this.stats = stats;
    }

    public int getStat(Stat stat) {
        return stats.get(stat.ordinal());
    }

    public int getStat(int i) {
        return stats.get(i);
    }

    public static PokemonStats calculateStats(PokemonStats baseStats, PokemonIV IVs, int level) {
        List<Integer> stats = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            float baseStat = baseStats.getStat(i);

            if (i == Stat.HP.ordinal())
                stats.add((int) ((((2 * baseStat + IVs.getIV(i) /* + (ev /4) */) * level) / 100) + level + 10));

            else
                stats.add((int) ((((2 * baseStat + IVs.getIV(i) /* + (ev /4) */) * level) / 100) + 5));
        }

        return new PokemonStats(stats);
    }
}
