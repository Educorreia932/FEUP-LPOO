package lpoo.pokemonascii.pokemon;

enum Type {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL;
}

public class PokemonType {
    private static final float Z = 0.0f;
    private static final float W = 0.5f;
    private static final float N = 1.0f;
    private static final float S = 2.0f;

    private static final float[][] effectivenessTable = new float[][]{
        {N, N, N, N, N, N, N, N, N, N, N, N, W, Z, N, N, W}, // Normal
        {N, W, W, N, S, S, N, N, N, N, N, S, W, N, W, N, S}, // Fire
        {N, S, W, N, W, N, N, N, S, N, N, N, S, N, W, N, N}, // Water
        {N, N, S, W, W, N, N, N, Z, S, N, N, N, N, W, N, N}, // Electric
        {N, W, S, N, W, N, N, W, S, W, N, W, S, N, W, N, W}, // Grass
        {N, W, W, N, S, W, N, N, S, S, N, N, N, N, S, N, W}, // Ice
        {S, N, N, N, N, S, N, W, N, W, W, W, S, Z, N, S, S}, // Fighting
        {N, N, N, N, S, N, N, W, W, N, N, N, W, W, N, N, Z}, // Poison
        {N, S, N, S, W, N, N, S, N, Z, N, W, S, N, N, N, S}, // Ground
        {N, N, N, W, S, N, S, N, N, N, N, S, W, N, N, N, W}, // Flying
        {N, N, N, N, N, N, S, S, N, N, W, N, N, N, N, Z, W}, // Psychic
        {N, W, N, N, S, N, W, W, N, W, S, N, N, W, N, S, W}, // Bug
        {N, S, N, N, N, S, W, N, W, S, N, S, N, N, N, N, W}, // Rock
        {Z, N, N, N, N, N, N, N, N, N, S, N, N, S, N, W, N}, // Ghost
        {N, N, N, N, N, N, N, N, N, N, N, N, N, N, S, N, W}, // Dragon
        {N, N, N, N, N, N, W, N, N, N, S, N, N, S, N, W, N}, // Dark
        {N, W, W, W, N, S, N, N, N, N, N, N, S, N, N, N, W}  // Steel
    };

    private Type type;

    public PokemonType(String type) {
        this.type = Type.valueOf(type);
    }

    public float getDamageMultiplier(Type defensiveType) {
        return effectivenessTable[type.ordinal()][defensiveType.ordinal()];
    }

    public float getDamageMultiplier(PokemonType defensiveType) {
        return effectivenessTable[type.ordinal()][defensiveType.getType().ordinal()];
    }

    public Type getType() {
        return type;
    }
}
