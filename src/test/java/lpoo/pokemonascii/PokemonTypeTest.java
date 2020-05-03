package lpoo.pokemonascii;

import lpoo.pokemonascii.data.pokemon.PokemonType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class PokemonTypeTest {
    private PokemonType pokemonType;

    @Test
    public void testNormalType() {
        pokemonType = new PokemonType("NORMAL");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GHOST), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 0.5f);
    }

    @Test
    public void testFireType() {
        pokemonType = new PokemonType("FIRE");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ICE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.BUG), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DRAGON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 2.0f);
    }

    @Test
    public void testWaterType() {
        pokemonType = new PokemonType("WATER");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FIRE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DRAGON), 0.5f);
    }

    @Test
    public void testElectricType() {
        pokemonType = new PokemonType("ELECTRIC");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.WATER), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ELECTRIC), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GROUND), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FLYING), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DRAGON), 0.5f);
    }

    @Test
    public void testGrassType() {
        pokemonType = new PokemonType("GRASS");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.WATER), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FLYING), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.BUG), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DRAGON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 0.5f);
    }

    @Test
    public void testIceType() {
        pokemonType = new PokemonType("ICE");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FIRE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.WATER), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ICE), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GROUND), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FLYING), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DRAGON), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 0.5f);
    }

    @Test
    public void testFightingType() {
        pokemonType = new PokemonType("FIGHTING");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.NORMAL), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ICE), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FLYING), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.PSYCHIC), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.BUG), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GHOST), 0.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.DARK), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 2.0f);
    }

    @Test
    public void testPoisonType() {
        pokemonType = new PokemonType("POISON");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GRASS), 2.0f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.POISON), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GROUND), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.ROCK), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.GHOST), 0.5f);
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.STEEL), 0.0f);
    }

    @Test
    public void testGroundType() {
        pokemonType = new PokemonType("GROUND");
        assertEquals(pokemonType.getDamageMultiplier(PokemonType.Type.FLYING), 0.0f);
    }
}
