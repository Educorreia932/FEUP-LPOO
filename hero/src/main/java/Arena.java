import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        // TODO: Make it impossible to a coin to spawn in the same position as the hero
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));

        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        // TODO: Make it impossible to a monster to spawn in the same position as the hero
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));

        return monsters;
    }

    public void retrieveCoins() {
        Coin toRemove = null;

        for (Coin coin : coins)
            if (coin.getPosition().equals(hero.getPosition())) {
                toRemove = coin;
                break;
            }

        if (toRemove != null)
            coins.remove(toRemove);
    }

    public void moveMonsters() {
        for (Monster monster : monsters)
            monster.move();
    }

    public void verifyMonsterCollisions() {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(hero.getPosition())) {
                break;
            }
    }

    public void processKey(KeyStroke key) {
        // Convert to switch case
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());

        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());

        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());

        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#DEB887"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);

        hero.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls)
            if (position.equals(wall.getPosition()))
                return false;

        return position.getX() <= width && position.getY() <= height;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
}
