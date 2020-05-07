package lpoo.pokemonascii.data.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokemonIV {
    private List<Integer> IVs;

    public PokemonIV() {
        IVs = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 6; i++)
            IVs.add(rand.nextInt(32));
    }

    public int getIV(int i) {
        return IVs.get(i);
    }
}
