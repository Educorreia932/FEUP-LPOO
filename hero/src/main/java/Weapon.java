public class Weapon extends Item {
    int damage;

    Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
