package lpoo.pokemonascii.data.pokemon;

public class PokemonMove {
    private String name;
    private int power;
    private int accuracy;
    private PokemonType type;

    PokemonMove(String name) {
        this.name = name;
    }

    public PokemonMove() {
        this.name = "Test";
        this.power = 50;
        this.accuracy = 1;
        this.type = new PokemonType("WATER");
    }

    public void execute(Pokemon pokemon) {
        pokemon.takeDamage((int) (type.getDamageMultiplier(pokemon.getSpecies().getPrimaryType())* power));
    }
}
