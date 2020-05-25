package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.tile.PokemonTile;
import lpoo.pokemonascii.data.tile.Tiles;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Route6 extends WorldModel{
    private MapZone zone;

    public Route6() throws IOException, SAXException, ParserConfigurationException {
        super();
        zone = MapZone.DOWNLEFT; //Start zone
        tiles.setRanges(zone);
        updatePokemonTiles();
        updateElements();
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
                for (int line = 0; line < 8; line++){  //Left patch
                    for(int row = 0; row < 4; row++)
                        tiles.add(new PokemonTile(26*2 + 26*row, 16*line));
                }

                for(int row = 0; row < 9; row++)   //Down patch
                    tiles.add(new PokemonTile(26*6 + 26*row, 16*7));


                for (int line = 0; line < 4; line++){  //Right patch
                    for(int row = 0; row < 6; row++)
                        tiles.add(new PokemonTile(26*9 + 26*row, 16*line));
                }

                break;
            case UPRIGHT:
                for (int line = 0; line < 3; line++){  //Top patch
                    for(int row = 0; row < 7; row++)
                        tiles.add(new PokemonTile(26*row, 16 + 16*line));
                }

                for (int line = 0; line < 3; line++){  //Left patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*row, 16*7 + 16*line));
                }

                for (int line = 0; line < 6; line++){  //Right patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*5 + 26*row, 16*4 + 16*line));
                }

                break;
            case DOWNRIGHT:

                for (int line = 0; line < 2; line++){  //Right Top patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*row,16*line));
                }

                for (int line = 0; line < 5; line++){  //Left patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*5 + 26*row,16*line));
                }

                for (int line = 0; line < 4; line++){  //Right Bottom patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*row,16*5 + 16*line));
                }

                break;
            case DOWNLEFT:

                for (int line = 0; line < 4; line++){  //Right Bottom patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new PokemonTile(26*14 + 26*row,16*5 + 16*line));
                }

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
            tiles.setRanges(zone);
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
}
