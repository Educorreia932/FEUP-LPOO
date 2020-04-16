package lpoo.pokemonascii.game;

import lpoo.pokemonascii.gui.Image;

public class Pokemon {
    private Image image;
    private int hp,
                attack,
                defense,
                sp_atk,
                sp_def,
                speed;
//    String gender;

    Pokemon(Integer pokedex_number) {
        image = new Image("pokemon_back\\" + pokedex_number.toString());
    }
}
