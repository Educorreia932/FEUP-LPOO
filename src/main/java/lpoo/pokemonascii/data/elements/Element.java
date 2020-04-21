package lpoo.pokemonascii.data.elements;

import lpoo.pokemonascii.data.Position;

public class Element {
    Position position;

    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
