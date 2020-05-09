package lpoo.pokemonascii.data.tile;

import lpoo.pokemonascii.data.tile.Tile;

import java.util.Random;

public class PokemonTile extends Tile {
    protected int probability;

    public PokemonTile(int x, int y, int width, int height) {
        super(x, y, width, height);
        probability = 1;
    }

    public boolean foundPokemon() {
        Random rand = new Random();
        return rand.nextInt(probability) == 0;
    }
}
