import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
    }

    public void processKey(KeyStroke key) {
        // Convert to switch case
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());

        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());

        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());

        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
    }

    public void draw(Screen screen) throws IOException {
        hero.draw(screen);
    }

    private boolean canHeroMove(Position position) {
        return position.getX() <= width && position.getY() <= height;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
}
