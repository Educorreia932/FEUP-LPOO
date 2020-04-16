package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;

public class Obstacle implements CollidingElement {
    Position position;
    Rect hitbox;

    Obstacle(int x, int y, int width, int height) {
        position = new Position(x, y);
        hitbox = new Rect(width, height);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Rect getHitbox() {
        return hitbox;
    }
}
