import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {
    private float health;

    Monster(int x, int y, float health) {
        super(x, y);
        this.health = health;
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
