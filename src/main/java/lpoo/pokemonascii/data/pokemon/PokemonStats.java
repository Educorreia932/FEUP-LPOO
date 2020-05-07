package lpoo.pokemonascii.data.pokemon;

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

    public float calculateStat(PokemonStats stats, Stat stat, int iv, int level) {
        float baseStat = stats.getStat(stat);

        if (stat == Stat.HP)
            return (((2 * baseStat + iv) * level) / 100) + level + 10;

        else
            return (((2 * baseStat + iv) * level) / 100) + 5;
    }
}
