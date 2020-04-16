package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.DrawableCollider;
import lpoo.pokemonascii.pokemon.Pokemon;

import java.util.List;

public class Player extends DrawableCollider {
    private String name;
    private List<Pokemon> pokemons;

    Player() {
        super("player\\red_front", 100, 50);
    }
}
