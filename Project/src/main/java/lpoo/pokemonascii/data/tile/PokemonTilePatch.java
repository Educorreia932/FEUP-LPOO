package lpoo.pokemonascii.data.tile;

import java.util.List;

public class PokemonTilePatch extends PokemonTile {
    private List<? extends PokemonTile> tiles;

    public PokemonTilePatch(int x, int y, int height, int width, List<? extends PokemonTile> tiles) {
        super(x, y, width, height);
        this.tiles = tiles;
    }

}
