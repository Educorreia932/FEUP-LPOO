package lpoo.pokemonascii.pokemon;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PokemonTypeTest {
    private PokemonType pokemonType;

    @Test
    public void testNormalType() {
        pokemonType = new PokemonType("NORMAL");
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GHOST), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 0.5f);
    }

    @Test
    public void testFireType() {
        pokemonType = new PokemonType("FIRE");
        assertEquals(pokemonType.getDamageMultiplier(Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ICE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.BUG), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DRAGON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 2.0f);
    }

    @Test
    public void testWaterType() {
        pokemonType = new PokemonType("WATER");
        assertEquals(pokemonType.getDamageMultiplier(Type.FIRE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DRAGON), 0.5f);
    }

    @Test
    public void testElectricType() {
        pokemonType = new PokemonType("ELECTRIC");
        assertEquals(pokemonType.getDamageMultiplier(Type.WATER), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ELECTRIC), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GROUND), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.FLYING), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DRAGON), 0.5f);
    }

    @Test
    public void testGrassType() {
        pokemonType = new PokemonType("GRASS");
        assertEquals(pokemonType.getDamageMultiplier(Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.WATER), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.FLYING), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.BUG), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DRAGON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 0.5f);
    }

    @Test
    public void testIceType() {
        pokemonType = new PokemonType("ICE");
        assertEquals(pokemonType.getDamageMultiplier(Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ICE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.FLYING), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DRAGON), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 0.5f);
    }

    @Test
    public void testFightingType() {
        pokemonType = new PokemonType("FIGHTING");
        assertEquals(pokemonType.getDamageMultiplier(Type.NORMAL), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ICE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.FLYING), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.PSYCHIC), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.BUG), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GHOST), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.DARK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 2.0f);
    }

    @Test
    public void testPoisonType() {
        pokemonType = new PokemonType("POISON");
        assertEquals(pokemonType.getDamageMultiplier(Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GROUND), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.GHOST), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(Type.STEEL), 0.0f);
    }
}
