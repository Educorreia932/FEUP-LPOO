abstract class Creature extends Element {
    private int health;

    Creature(int x, int y, int health) {
        super(x, y);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
