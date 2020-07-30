package lpoo.pokemonascii.data.pokemon;

public abstract class PokemonExperience {
    private static final int FAST = 800000;
    private static final int MEDIUM_FAST= 1000000;
    private static final int MEDIUM_SLOW = 1059860;
    private static final int SLOW = 1250000;

    public static int getLevelExperience(int totalExperience, int level) {
        switch (totalExperience) {
            case FAST:
                return (int) (4 * Math.pow(level, 3) / 5);
            case MEDIUM_FAST:
                return (int) (Math.pow(level, 3));
            case MEDIUM_SLOW:
                return (int) (6 / 5 * Math.pow(level, 3) - 15 * Math.pow(level, 2) + 100 * level - 140);
            case SLOW:
                return (int) (5 * Math.pow(level, 3) / 4);
        }

        return 0;
    }

    public static float getExperiencePercentage(Pokemon pokemon) {
        int totalExperience = pokemon.getSpecies().getTotalExperience();

        int l1 = pokemon.getLevel();
        int l2 = l1 + 1;

        float e = pokemon.getExperience();
        float e1 = getLevelExperience(totalExperience, l1);
        float e2 = getLevelExperience(totalExperience, l2);

        return (e - e1) / (e2 - e1);
    }
}
