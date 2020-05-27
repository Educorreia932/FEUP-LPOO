package lpoo.pokemonascii;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.BattleController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class PokemonMoveTest {
    private BattleModel model;
    private BattleController controller;


    @Before
    public void init() throws ParserConfigurationException, SAXException, IOException {
        model = new BattleModel(new Player(), 1);
        controller = new BattleController(Mockito.mock(BattleView.class), model);
    }

    @Test
    public void testUsePokemonMove(){
        Pokemon trainerPokemon = model.getTrainerPokemon();
        Pokemon foePokemon = model.getAdversaryPokemon();

        int HPt = trainerPokemon.getCurrentHealth();
        int HPf = foePokemon.getCurrentHealth();

        PokemonMove moveT = trainerPokemon.getMoves().get(0);
        PokemonMove moveF = foePokemon.getMoves().get(0);

        controller.usePokemonMove(trainerPokemon, moveF);
        controller.usePokemonMove(foePokemon, moveT);

        int damageT, damageF;

        //Damage for trainer pokemon
        if (trainerPokemon.getSpecies().getSecondaryType() != null)
            damageT = (int) (moveF.getType().getDamageMultiplier(trainerPokemon.getSpecies().getPrimaryType()) *
                    moveF.getType().getDamageMultiplier(trainerPokemon.getSpecies().getSecondaryType()) *
                    moveF.getPower());

        else
            damageT = (int) (moveF.getType().getDamageMultiplier(trainerPokemon.getSpecies().getPrimaryType()) * moveF.getPower());

        //Damage for Foe pokemon
        if (trainerPokemon.getSpecies().getSecondaryType() != null)
            damageF = (int) (moveT.getType().getDamageMultiplier(trainerPokemon.getSpecies().getPrimaryType()) *
                    moveT.getType().getDamageMultiplier(trainerPokemon.getSpecies().getSecondaryType()) *
                    moveT.getPower());

        else
            damageF = (int) (moveT.getType().getDamageMultiplier(trainerPokemon.getSpecies().getPrimaryType()) * moveT.getPower());

        assertEquals(foePokemon.getCurrentHealth(), Math.max(HPf - damageT, 0));
        assertEquals(trainerPokemon.getCurrentHealth(), Math.max(HPt - damageF, 0));
    }
}
