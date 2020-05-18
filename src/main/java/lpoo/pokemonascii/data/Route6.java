package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.tile.Grass;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Route6 extends WorldModel{
    private MapZone zone;

    public void setZone(MapZone zone) {
        this.zone = zone;
    }

    public Route6() throws IOException, SAXException, ParserConfigurationException {
        super();
        zone = MapZone.DOWNRIGHT; //Start zone
        addPokemonTiles();
        addElements();
    }

    private void addElements() {
        switch(zone){
            case UPLEFT:
                elements.add(new Obstacle(161-26*6, 111+16, 26+26*14, 16)); // water
                elements.add(new Obstacle(0, 0, 26*2, 16*8)); // trees
                break;
            case UPRIGHT:
                elements.add(new Obstacle(161+26, 0, 26, 16*9)); // trees
                break;
            case DOWNRIGHT:
                elements.add(new Obstacle(161+26, 0, 26, 16*5)); // trees
                elements.add(new Obstacle(161-26*4, 16*5, 26*5, 16*4)); // upperFence
                elements.add(new Obstacle(161-26*6, 16*9, 26*2, 16)); // lowerFence
                break;
            case DOWNLEFT:
                elements.add(new Obstacle(0, 111-16*7, 26*15, 16)); // water
                elements.add(new Obstacle(161-5*26, 111-16*5, 26, 16*3)); // trees
                elements.add(new Obstacle(161-4*26, 111-16*2, 26*5, 16*5)); // left most fence
                elements.add(new Obstacle(161, 111+16*2, 26*4, 16)); // left most lower fence
                elements.add(new Obstacle(161+26*7, 111+16*2, 26*2, 16)); // right most lower fence
                break;
        }
    }

    void addPokemonTiles(){
        switch(zone){
            case UPLEFT:
                for (int line = 0; line < 8; line++){  //Left patch
                    for(int row = 0; row < 4; row++)
                        tiles.add(new Grass(26*2 + 26*row, 16*line));
                }

                for(int row = 0; row < 9; row++)   //Down patch
                    tiles.add(new Grass(26*7 + 26*row, 16*7));


                for (int line = 0; line < 4; line++){  //Right patch
                    for(int row = 0; row < 6; row++)
                        tiles.add(new Grass(26*8 + 26*row, 16*line));
                }

                break;
            case UPRIGHT:

                for (int line = 0; line < 3; line++){  //Top patch
                    for(int row = 0; row < 7; row++)
                        tiles.add(new Grass(26*row, 16 + 16*line));
                }

                for (int line = 0; line < 3; line++){  //Left patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new Grass(26*row, 16*7 + 16*line));
                }

                for (int line = 0; line < 6; line++){  //Right patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new Grass(26*5 + 26*row, 16*4 + 16*line));
                }

                break;
            case DOWNRIGHT:

                for (int line = 0; line < 2; line++){  //Right Top patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new Grass(26*row,16*line));
                }

                for (int line = 0; line < 5; line++){  //Left patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new Grass(26*5 + 26*row,16*line));
                }

                for (int line = 0; line < 4; line++){  //Right Bottom patch
                    for(int row = 0; row < 2; row++)
                        tiles.add(new Grass(26*row,16*5 + 16*line));
                }

                break;
            case DOWNLEFT:
                break;
        }
    }

}
