package lpoo.pokemonascii.gui;

import java.util.List;

public class Sprite {
    private List<Image> images;
    private enum position {
        FRONT, BACK, LEFT, RIGHT
    }
    private position current;

    public Sprite(List<Image> images) {
        this.images = images;
        current = position.FRONT;
    }

    public Image getCurrent(){
        return images.get(current.ordinal());
    }

}
