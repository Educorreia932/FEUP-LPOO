package lpoo.pokemonascii.pokemon;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PokemonSpeciesTest {
    private PokemonSpecies species;

    @Test
    public void testSingleType() {
        species = new PokemonSpecies(25);
        assertEquals(species.getName(), "PIKACHU");
        assertEquals(species.getPrimaryType().getType(), Type.ELECTRIC);
    }

    @Test
    public void testDualType() {
        species = new PokemonSpecies(1);
        assertEquals(species.getName(), "BULBASAUR");
        assertEquals(species.getPrimaryType().getType(), Type.GRASS);
        assertEquals(species.getSecondaryType().getType(), Type.POISON);
    }
}
