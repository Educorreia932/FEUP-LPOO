package lpoo.pokemonascii.game;

import lpoo.pokemonascii.commands.Command;
import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements CollidingElement, DrawableElement {
    private Position position;
    private String name;
    private List<Pokemon> pokemons;
    private Collider collider;
    private Sprite sprite;

    Player() {
        position = new Position(100, 50);
        Image front= new Image("player\\red_front");
        Image back= new Image("player\\red_back");
        Image left= new Image("player\\red_left");
        Image right= new Image("player\\red_right");

        sprite = new Sprite(new ArrayList<>(Arrays.asList(front, back, left, right)));
        collider = new Collider(front);
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public Image getCurrentImage() {
        return sprite.getCurrentImage();
    }

    public void updateImage(Command command){
        sprite.updateImage(command);
    }
}
