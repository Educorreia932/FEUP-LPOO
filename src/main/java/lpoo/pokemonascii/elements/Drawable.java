package lpoo.pokemonascii.elements;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Image;

public class Drawable implements DrawableElement {
    private Position position;
    private Image image;

    public Drawable(String file_name, int x, int y) {
        image = new Image(file_name);
        position = new Position(x, y);
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
