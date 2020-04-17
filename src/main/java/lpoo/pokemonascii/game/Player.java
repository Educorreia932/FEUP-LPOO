package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.pokemon.Pokemon;

import java.util.List;

public class Player implements CollidingElement, DrawableElement {
    private Position position;
    private String name;
    private List<Pokemon> pokemons;
    private Collider collider;
    private Image image;

    Player() {
        image = new Image("player\\red_front");
        position = new Position(100, 50);
        collider = new Collider(image);
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
