import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Creature extends Element {
    Creature(int x, int y, String character) {
        super(x, y, character);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    public void move(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
}
