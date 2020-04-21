package lpoo.pokemonascii;

import lpoo.pokemonascii.data.pokemon.PokemonSpecies;
import lpoo.pokemonascii.data.pokemon.PokemonType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PokemonSpeciesTest {
    private PokemonSpecies species;

    @Test
    public void testSingleType() {
        species = new PokemonSpecies(25);
        assertEquals(species.getName(), "PIKACHU");
        assertEquals(species.getPrimaryType().getType(), PokemonType.Type.ELECTRIC);
    }

    @Test
    public void testDualType() {
        species = new PokemonSpecies(1);
        assertEquals(species.getName(), "BULBASAUR");
        assertEquals(species.getPrimaryType().getType(), PokemonType.Type.GRASS);
        assertEquals(species.getSecondaryType().getType(), PokemonType.Type.POISON);
    }
}
