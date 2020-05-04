package lpoo.pokemonascii.data.options.battle;

import lpoo.pokemonascii.data.options.Option;

public class BattleOption implements Option {
    private String name;

    BattleOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
