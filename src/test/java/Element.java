import com.googlecode.lanterna.graphics.TextGraphics;
import javafx.geometry.Pos;

// Represents an element present in the world
abstract public class Element {
    Position position;
    String character;

    Element(int x, int y, String character) {
        position = new Position(x, y);
        this.character = character;
    }

    abstract public void draw(TextGraphics graphics);

    public Position getPosition() {
        return position;
    }
}
