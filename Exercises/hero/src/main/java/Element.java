import com.googlecode.lanterna.graphics.TextGraphics;

abstract class Element {
    private Position position;

    Element(int x, int y) {
        this.position = new Position(x, y);
    }

    abstract public void draw(TextGraphics graphics);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
