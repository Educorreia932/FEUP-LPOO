package lpoo.pokemonascii.gui;

import lpoo.pokemonascii.commands.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprite {
    private List<Image> images;
    private int current = 0;

    public Sprite(List<Image> images) {
        this.images = images;
    }

    public Sprite(String filename) {
        Image image = new Image(filename);
        this.images = new ArrayList<>(Collections.singletonList(image));
    }

    public Image getCurrentImage(){
        return images.get(current);
    }

    public void setCurrentImage(int current) {
        this.current = current;
    }
}
