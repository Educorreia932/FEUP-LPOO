import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Creature {
    Monster(int x, int y, int health) {
        super(x, y, health);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "m");
    }

    public Position move() {
        return getPosition(); // TODO: Change
    }
}
