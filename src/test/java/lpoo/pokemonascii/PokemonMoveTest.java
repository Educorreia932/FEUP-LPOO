package lpoo.pokemonascii;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.BattleController;

import org.junit.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;


public class PokemonMoveTest {
    @Test
    public void testUsePokemonMove() throws ParserConfigurationException, SAXException, IOException {
        BattleModel battle = new BattleModel(new Pokemon(1, 1, Pokemon.FacingDirection.BACK));

        Pokemon trainerPokemon = battle.getTrainerPokemon();
        Pokemon foePokemon = battle.getAdversaryPokemon();

        int trainerPokemonHP = trainerPokemon.getCurrentHealth();
        int foePokemonHP = foePokemon.getCurrentHealth();

        PokemonMove move = new PokemonMove("Tackle");

        BattleController controller = new BattleController(Mockito.mock(BattleView.class), battle);
        controller.usePokemonMove(trainerPokemon, move);
        controller.usePokemonMove(foePokemon, move);

        assertEquals(foePokemon.getCurrentHealth(), Math.max(foePokemonHP - move.getPower(), 0));
        assertEquals(trainerPokemon.getCurrentHealth(), Math.max(trainerPokemonHP - move.getPower(), 0));
    }
}
