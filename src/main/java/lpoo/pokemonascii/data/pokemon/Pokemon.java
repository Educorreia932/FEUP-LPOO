package lpoo.pokemonascii.data.pokemon;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    public enum FacingDirection {
        FRONT,
        BACK
    }

    private PokemonSpecies species;
    private String name;
    private PokemonStats baseStats;
    private PokemonStats currentStats;
    private PokemonIV IVs;
    private int currentHealth;
    private int level;
    private int experience;
    private List<PokemonMove> moves;
    private FacingDirection direction;

    public Pokemon(Integer pokedex_number, int level, FacingDirection direction) throws IOException, SAXException, ParserConfigurationException {
        species = new PokemonSpecies(pokedex_number);
        name = species.getName();
        IVs = new PokemonIV();
        baseStats = species.getBaseStats();
        this.level = level;
        experience = PokemonExperience.getLevelExperience(species.getTotalExperience(), level);
        currentStats = PokemonStats.calculateStats(baseStats, IVs, level);
        currentHealth = currentStats.getStat(PokemonStats.Stat.HP);
        this.direction = direction;
        moves = new ArrayList<>();

        moves.addAll(species.getLevelMoves());
    }

    public FacingDirection getFacingDirection() {
        return direction;
    }

    public int getPokedexNumber() {
        return species.getPokedexNumber();
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public float getCurrentHealthPercentage() {
        return currentHealth / (float) currentStats.getStat(PokemonStats.Stat.HP);
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

    public int getStat(PokemonStats.Stat stat) {
        return currentStats.getStat(stat);
    }

    public void setDirection(FacingDirection direction) {
        this.direction = direction;
    }

    public void setHP(int n) {
        currentHealth = n;
    }
}