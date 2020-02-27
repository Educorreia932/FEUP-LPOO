import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int c, int i) {
        super(c, i);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8B4513"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "\u2588");
    }
}
