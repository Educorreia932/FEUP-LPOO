
public class Creature extends Element {
    Creature(int x, int y, String character) {
        super(x, y, character);
    }

    public void move(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
}
