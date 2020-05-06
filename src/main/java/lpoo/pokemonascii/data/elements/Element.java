package lpoo.pokemonascii.data.elements;

import lpoo.pokemonascii.data.Position;

public class Element {
    Position position;
    private Position previousPosition;

    public Element(int x, int y) {
        position = new Position(x, y);
        previousPosition = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        previousPosition = this.position;
        this.position = position;
    }

    public Position getPreviousPosition() {
        return previousPosition;
    }
}
