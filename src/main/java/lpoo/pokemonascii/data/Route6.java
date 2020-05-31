package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.tile.GrassPatch;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Random;


public class Route6 extends WorldModel{
    private MapZone zone;
    private int range_max;
    private int range_min;

    public Route6() throws IOException, SAXException, ParserConfigurationException {
        super();
        zone = MapZone.DOWNLEFT; //Start zone
        updatePokemonTiles();
        updateElements();
        setRanges();
    }

    private void updateElements() {
        elements.clear();

        switch(zone){
            case UPLEFT:
                elements.add(new Obstacle(6, 127, 390, 16)); // water
                elements.add(new Obstacle(0, 0, 52, 128)); // trees
                break;
            case UPRIGHT:
                elements.add(new Obstacle(187, 0, 26, 144)); // trees
                break;
            case DOWNRIGHT:
                elements.add(new Obstacle(187, 0, 26, 80)); // trees
                elements.add(new Obstacle(57, 80, 130, 64)); // upperFence
                elements.add(new Obstacle(5, 144, 52, 16)); // lowerFence
                break;
            case DOWNLEFT:
                elements.add(new Obstacle(0, 0, 390, 16)); // water
                elements.add(new Obstacle(31, 31, 26, 48)); // trees
                elements.add(new Obstacle(57, 79, 130, 80)); // left most fence
                elements.add(new Obstacle(161, 143, 104, 16)); // left most lower fence
                elements.add(new Obstacle(343, 143, 52, 16)); // right most lower fence
                break;
        }
    }

    void updatePokemonTiles(){
        tiles.clear();

        switch(zone){
            case UPLEFT:
                tiles.add(new GrassPatch(26*2, 0, 8, 4)); //Left patch
                tiles.add(new GrassPatch(26*6, 16*7, 1, 9)); //Down patch
                tiles.add(new GrassPatch(26*9, 0, 4, 6)); //Right patch
                break;
            case UPRIGHT:
                tiles.add(new GrassPatch(0, 16, 3, 7)); //Top patch
                tiles.add(new GrassPatch(0, 16*7, 3, 2)); //Left patch
                tiles.add(new GrassPatch(26*5, 16*4, 6, 2)); //Right patch
                break;
            case DOWNRIGHT:
                tiles.add(new GrassPatch(0, 0, 2, 2)); //Right Top patch
                tiles.add(new GrassPatch(26*5, 0, 5, 2)); //Left patch
                tiles.add(new GrassPatch(0, 16*5, 4, 2)); //Right Bottom patch
                break;
            case DOWNLEFT:
                tiles.add(new GrassPatch(26*14, 16*5, 4, 2)); //Right Bottom patch
                break;
        }
    }

    public boolean zoneUpdate(Position.Direction direction){
        Position position = player.getPosition(direction);
        boolean changed = false;

        // Check if the player is off screen borders
        if(position.getX() > 380){

            switch(zone){
                case UPLEFT:
                    changed = true;
                    zone = MapZone.UPRIGHT;
                    break;
                case DOWNLEFT:
                    changed = true;
                    zone = MapZone.DOWNRIGHT;
                    break;
            }
            if(changed)
                player.setPosition(new Position(0, position.getY()));
        }

        else if(position.getX() < 0){

            switch(zone){
                case UPRIGHT:
                    changed = true;
                    zone = MapZone.UPLEFT;
                    break;
                case DOWNRIGHT:
                    changed = true;
                    zone = MapZone.DOWNLEFT;
                    break;
            }
            if(changed)
                player.setPosition(new Position(371, position.getY()));
        }

        else if(position.getY() > 140){

            switch(zone){
                case UPRIGHT:
                    zone = MapZone.DOWNRIGHT;
                    changed = true;
                    break;

            }
            if(changed)
                player.setPosition(new Position(position.getX(),0));

        }

        else if(position.getY() < 0){

            switch(zone){
                case DOWNRIGHT:
                    zone = MapZone.UPRIGHT;
                    changed = true;
                    break;
            }
            if(changed)
                player.setPosition(new Position(position.getX(),70+16*4));

        }

        if(changed){
            updateElements();
            updatePokemonTiles();
            setRanges();
        }

        return changed;
    }

    public String getImage(){
        String file;

        switch(zone){
            case UPLEFT:
                file = "1";
                break;
            case UPRIGHT:
                file = "2";
                break;
            case DOWNRIGHT:
                file = "3";
                break;
            case DOWNLEFT:
                file = "4";
                break;
            default:
                file = "1";
        }
        return file;
    }

    public int getPokemonNumber(){
        Random rand = new Random();
        return rand.nextInt(range_max -  range_min +1 ) + range_min;
    }

    public void setRanges(){
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
}
