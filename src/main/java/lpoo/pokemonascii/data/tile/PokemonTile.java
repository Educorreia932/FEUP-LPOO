package lpoo.pokemonascii.data.tile;

import java.util.Random;

public abstract class PokemonTile extends Tile {
    protected int probability;

    public PokemonTile(int x, int y, int width, int height) {
        super(x, y, width, height);
        probability = 5;
    }

    public boolean foundPokemon() {
        Random rand = new Random();
        return rand.nextInt(probability) == 0;
    }
}
