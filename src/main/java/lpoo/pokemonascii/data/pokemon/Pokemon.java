package lpoo.pokemonascii.data.pokemon;

import lpoo.pokemonascii.data.Position;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class Pokemon {
    public enum facingDirection {
        FRONT,
        BACK
    }

    private Position position;
    private PokemonSpecies species;
    private String name;
    private PokemonStats stats;
    private float currentHealth;
    private int experience;
    private List<PokemonMove> moves;
    private facingDirection direction;

    public Pokemon(Integer pokedex_number, facingDirection direction) throws IOException, SAXException {
        species = new PokemonSpecies(pokedex_number);
        name = species.getName();
        stats = species.getBaseStats();
        currentHealth = stats.getHP();
        experience = 0;
        this.direction = direction;

        switch (direction) {
            case FRONT:
                position = new Position(245, 15);
                break;
            case BACK:
                position = new Position(67, 61);
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public facingDirection getFacingDirection() {
        return direction;
    }

    public int getPokedexNumber() {
        return species.getPokedexNumber();
    }

    public String getName() {
        return name;
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public float getCurrentHealthPercentage() {
        return currentHealth / stats.getHP();
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
    }
}