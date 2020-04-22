package lpoo.pokemonascii.data.pokemon;

import java.util.List;

public class PokemonStats {
    private float hp, attack, defense, spAtk, spDef, speed;

    public PokemonStats(List<Integer> stats) {
        this.hp = stats.get(0);
        this.attack = stats.get(1);
        this.defense = stats.get(2);
        this.spAtk = stats.get(3);
        this.spDef = stats.get(4);
        this.speed = stats.get(5);
    }

    public PokemonStats(PokemonStats stats) {
        this.hp = stats.getHP();
        this.attack = stats.getAttack();
        this.defense = stats.getDefense();
        this.spAtk = stats.getSpAtk();
        this.spDef = stats.getSpDef();
        this.speed = stats.getSpeed();
    }

    public float getHP() {
        return hp;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getSpAtk() {
        return spAtk;
    }

    public float getSpDef() {
        return spDef;
    }

    public float getSpeed() {
        return speed;
    }
}
