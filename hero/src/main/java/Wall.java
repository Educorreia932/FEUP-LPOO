import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;

    public Wall(int c, int i) {
        position = new Position(c, i);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF7777"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "▮");
    }
}
