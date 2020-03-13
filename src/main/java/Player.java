public class Player extends Creature {
    Inventory inventory;

    Player(int x, int y) {
        super(x, y, "@");
        inventory = new Inventory();
    }
}
