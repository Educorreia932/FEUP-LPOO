package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.Collider;
import lpoo.pokemonascii.data.elements.CollidingElement;

import java.util.List;

public class Player implements CollidingElement {
    private Position position;
    private String name;
    private List<Pokemon> pokemons;
    private Collider collider;
    private State state;

    public enum State {
        FRONT,
        BACK,
        RIGHT,
        LEFT,
    }

    public Player() {
        position = new Position(100, 50);
        state = State.FRONT;
        collider = new Collider(0, 0); // TODO: This is temporary, only for debug purposes
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public Position getPosition(Position.Direction direction) {
        switch (direction) {
            case UP:
                return position.up();
            case DOWN:
                return position.down();
            case RIGHT:
                return position.right();
            case LEFT:
                return position.left();
        }

        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}