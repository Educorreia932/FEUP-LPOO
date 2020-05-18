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
                break;
            case UPRIGHT:
                break;
            case DOWNRIGHT:
                break;
            case DOWNLEFT:
                elements.add(new Obstacle(161-26*6, 111+16, 26+26*14, 16)); // water
                elements.add(new Obstacle(0, 0, 26*2, 16*8)); // trees
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
