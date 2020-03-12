import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class World {
    Player player;

    public World() {
        player = new Player(10, 10);
    }

    public void draw(TextGraphics graphics) {
        player.draw(graphics);
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
