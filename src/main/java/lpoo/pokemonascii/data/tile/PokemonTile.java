package lpoo.pokemonascii.data.tile;

import java.util.Random;

public class PokemonTile extends Tile {
    protected int probability;

    public PokemonTile(int x, int y) {
        super(x, y, 26, 16);
        probability = 5;
    }

    public boolean foundPokemon() {
        Random rand = new Random();
        return rand.nextInt(probability) == 0;
    }
}
