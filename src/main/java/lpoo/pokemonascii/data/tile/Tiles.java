package lpoo.pokemonascii.data.tile;

import lpoo.pokemonascii.data.MapZone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tiles extends Tile{
    private List<Tile> tiles;
    private int range_max;
    private int range_min;

    public Tiles() {
        super(0,0,0,0);
        range_min = 0;
        range_max = 0;

        tiles = new ArrayList<>();
    }

    public void setRanges(MapZone zone){
        switch (zone){
            case DOWNLEFT:
                range_min = 0;
                range_max = 37;
                break;
            case DOWNRIGHT:
                range_min = 38;
                range_max = 74;
                break;
            case UPRIGHT:
                range_min = 75;
                range_max = 111;
                break;
            case UPLEFT:
                range_min = 112;
                range_max = 151;
                break;
        }
    }

    public int getPokemonNumber(){
        Random rand = new Random();
        return rand.nextInt(range_max -  range_min +1 ) + range_min;
    }

    public void add(Tile tile){
        tiles.add(tile);
    }

    public void clear(){
        tiles.clear();
    }

    public List<Tile> getTiles(){
        return tiles;
    }
}
