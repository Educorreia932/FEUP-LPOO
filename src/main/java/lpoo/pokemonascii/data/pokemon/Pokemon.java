package lpoo.pokemonascii.data.pokemon;

import lpoo.pokemonascii.data.Position;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    public enum facingDirection {
        FRONT,
        BACK
    }

    private Position position;
    private PokemonSpecies species;
    private String name;
    private PokemonStats baseStats;
    private PokemonStats currentStats;
    private PokemonIV IVs;
    private float currentHealth;
    private int level;
    private int experience;
    private List<PokemonMove> moves;
    private facingDirection direction;

    public Pokemon(Integer pokedex_number, facingDirection direction) throws IOException, SAXException, ParserConfigurationException {
        species = new PokemonSpecies(pokedex_number);
        name = species.getName();
        IVs = new PokemonIV();
        baseStats = species.getBaseStats();
        level = 56;
        experience = PokemonExperience.getLevelExperience(species.getTotalExperience(), level) + 5000;
        currentStats = PokemonStats.calculateStats(baseStats, IVs, level);
        currentHealth = currentStats.getStat(PokemonStats.Stat.HP);
        this.direction = direction;
        moves = new ArrayList<>();
        moves.add(new PokemonMove("Tackle"));

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
        return currentHealth / currentStats.getStat(PokemonStats.Stat.HP);
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;

        if (currentHealth  < 0)
            currentHealth = 0;
    }

    public int getLevel() {
        return level;
    }

    public PokemonSpecies getSpecies() {
        return species;
    }

    public int getExperience() {
        return experience;
    }

    public List<PokemonMove> getMoves() {
        return moves;
    }
}