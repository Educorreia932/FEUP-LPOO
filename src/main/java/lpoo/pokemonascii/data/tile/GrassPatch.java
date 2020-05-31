package lpoo.pokemonascii.data.tile;

import java.util.ArrayList;
import java.util.List;

public class GrassPatch extends Grass {
    private List<Tile> tiles;

    public GrassPatch(int x, int y, int lines, int rows) {
        super(x, y, rows * grassWIDTH, lines * grassHEIGHT);
        tiles = new ArrayList<>();

        createTiles(x, y, lines, rows);
    }

    private void createTiles(int x, int y, int lines, int rows) {
        for (int line = 0; line < lines; line++) {
            for (int row = 0; row < rows; row++)
                tiles.add(new Grass(x + grassWIDTH * row, y + grassHEIGHT * line));
        }
    }
}
