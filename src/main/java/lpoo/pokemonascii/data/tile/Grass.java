package lpoo.pokemonascii.data.tile;

public class Grass extends PokemonTile {

    public static int grassWIDTH = 26;
    public static int grassHEIGHT = 16;

    public Grass(int x, int y){
        super(x, y, 26, 16);
    }

    public Grass(int x, int y, int width, int height){
        super(x, y, width, height);
    }
}
