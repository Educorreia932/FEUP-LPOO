package lpoo.pokemonascii.game;

import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.pokemon.Pokemon;

import java.io.FileNotFoundException;

public class Battle {
    private Pokemon trainer_pokemon;
    private Pokemon adversary_pokemon;
    private Image background;

    Battle(int trainer_pokemon_number) throws FileNotFoundException {
        background = new Image("background\\battle");
        trainer_pokemon = new Pokemon(trainer_pokemon_number);
    }

    Image getBackground() {
        return background;
    }

    public Pokemon getTrainerPokemon() {
        return trainer_pokemon;
    }
}
