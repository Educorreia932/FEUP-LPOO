package lpoo.pokemonascii.data;

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
        zone = MapZone.DOWNLEFT; //Start zone
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
                break;
            case UPRIGHT:
                break;
            case DOWNRIGHT:
                break;
            case DOWNLEFT:
                break;
        }
    }

}
