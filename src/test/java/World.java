import com.googlecode.lanterna.graphics.TextGraphics;

public class World {
    Player player;

    public World() {
        player = new Player(10, 10);
    }

    public void draw(TextGraphics graphics) {
        player.draw(graphics);
    }
}
