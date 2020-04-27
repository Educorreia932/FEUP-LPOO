package lpoo.pokemonascii.data;

public class Option {
    enum BattleOptions {
        FIGHT,
        BAG,
        POKEMON,
        RUN
    }

    private String name;

    Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
