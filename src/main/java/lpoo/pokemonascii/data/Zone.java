package lpoo.pokemonascii.data;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

enum MapZone {
    UPLEFT,
    UPRIGHT,
    DOWNRIGHT,
    DOWNLEFT
}

public class Zone extends WorldModel{
    private MapZone zone;

    public void setZone(MapZone zone) {
        this.zone = zone;
    }

    public Zone() throws IOException, SAXException, ParserConfigurationException {
        super();
        zone = MapZone.DOWNLEFT;
    }

}
