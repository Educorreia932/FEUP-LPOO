package lpoo.pokemonascii;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.BattleController;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokemonMoveTest {

    public int getDamage(Pokemon pokemon, PokemonMove move){
        if (pokemon.getSpecies().getSecondaryType() != null)
            return (int) (move.getType().getDamageMultiplier(pokemon.getSpecies().getPrimaryType()) *
                    move.getType().getDamageMultiplier(pokemon.getSpecies().getSecondaryType()) *
                    move.getPower());

        else
            return (int) (move.getType().getDamageMultiplier(pokemon.getSpecies().getPrimaryType()) * move.getPower());
    }

    @Property
    public void testUsePokemonMove(@ForAll @IntRange(max = 151) int pokemon) throws IOException, SAXException, ParserConfigurationException {
        BattleModel model = new BattleModel(new Player(), pokemon);
        BattleController controller = new BattleController(Mockito.mock(BattleView.class), model);

        Pokemon trainerPokemon = model.getTrainerPokemon();
        Pokemon foePokemon = model.getAdversaryPokemon();

        int HPt = trainerPokemon.getCurrentHealth();
        int HPf = foePokemon.getCurrentHealth();

        PokemonMove moveT = trainerPokemon.getMoves().get(new Random().nextInt(4));
        PokemonMove moveF = trainerPokemon.getMoves().get(new Random().nextInt(4));

        int damageF = getDamage(trainerPokemon, moveF); //Damage trainer pokemon is going to take
        int damageT = getDamage(foePokemon, moveT); //Damage foe pokemon is going to take

        controller.usePokemonMove(trainerPokemon, moveT); //Attack
        controller.usePokemonMove(foePokemon, moveF);

        assertEquals(foePokemon.getCurrentHealth(), Math.max(HPf - damageT, 0));
        assertEquals(trainerPokemon.getCurrentHealth(), Math.max(HPt - damageF, 0));
    }
}
