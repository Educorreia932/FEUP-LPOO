import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;

    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = createWalls();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
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

    public void draw(TextGraphics graphics) {
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        return position.getX() <= width && position.getY() <= height;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
}
