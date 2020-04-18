package lpoo.pokemonascii.gui;

import lpoo.pokemonascii.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sprite {
    private List<Image> images;

    private enum direction {
        FRONT, BACK, LEFT, RIGHT
    }

    private direction current;

    public Sprite(List<Image> images) {
        this.images = images;
        current = direction.FRONT;
    }

    public Sprite(String filename) {
        Image image = new Image(filename);
        this.images = new ArrayList<>(Collections.singletonList(image));
        current = direction.FRONT;
    }

    public Image getCurrentImage(){
        return images.get(current.ordinal());
    }

    public void updateImage(Command command){
        if (command instanceof PlayerMoveUpCommand)
            current = direction.BACK;
        else if (command instanceof PlayerMoveRightCommand)
            current = direction.RIGHT;
        else if (command instanceof PlayerMoveLeftCommand)
            current = direction.LEFT;
        else if (command instanceof PlayerMoveDownCommand)
            current = direction.FRONT;
    }
}
