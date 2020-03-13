import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class World {
    List<Wall> walls;
    Player player;

    private List<Wall> createWalls() {
        int width = 20;
        int height = 20;

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

    public World() {
        player = new Player(10, 10);
        walls = createWalls();
    }

    public void draw(TextGraphics graphics) {
        player.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                player.move(player.getPosition().getX(), player.getPosition().getY() - 1);
                break;
            case ArrowDown:
                player.move(player.getPosition().getX(), player.getPosition().getY() + 1);
                break;
            case ArrowLeft:
                player.move(player.getPosition().getX() - 1, player.getPosition().getY());
                break;
            case ArrowRight:
                player.move(player.getPosition().getX() + 1, player.getPosition().getY());
                break;
        }
    }
}
