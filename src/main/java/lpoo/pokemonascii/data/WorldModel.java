package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.data.tile.Tiles;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WorldModel {
    protected Player player;
    protected List<CollidingElement> elements;
    protected Tiles tiles;

    public WorldModel() throws IOException, SAXException, ParserConfigurationException {
        player = new Player();
        elements = new ArrayList<>();
        tiles = new Tiles();
    }

    public WorldModel(Player player) {
        this.player = player;
        elements = new ArrayList<>();
    }

    public void setPlayerPosition(Position.Direction direction) {
        player.setPosition(player.getPosition(direction));
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public boolean canPlayerMove(Position.Direction direction) {
        Position position = player.getPosition(direction);

        // Check if the player moves off screen borders
        if (position.getX() < 0 || position.getX() > 380 || position.getY() < 0 || position.getY() > 140)
            return false;

        // Check if the player collides with anything
        return getCollidingElement(position, elements) == null;
    }

    public CollidingElement isPlayerInTile(){
        Position position = player.getPosition();
        return getCollidingElement(position, tiles.getTiles());
    }

    public CollidingElement getCollidingElement(Position position, List< ? extends CollidingElement> colliders) {
        for (CollidingElement c : colliders)
            if (c.collides(position, player))
                return c;

        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract boolean zoneUpdate(Position.Direction direction);

    public abstract String getImage();

    public int getPokemonNumber(){
        return tiles.getPokemonNumber();
    }
}
