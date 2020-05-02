package lpoo.pokemonascii.data.options;

public class Option {
    enum BattleOptions {
        FIGHT,
        BAG,
        POKEMON,
        RUN
    }

    private String name;

    public Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
