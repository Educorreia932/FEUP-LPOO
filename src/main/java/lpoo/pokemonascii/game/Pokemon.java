package lpoo.pokemonascii.game;

import lpoo.pokemonascii.gui.Image;

public class Pokemon {
    private Image sprite;
    private int hp,
                attack,
                defense,
                sp_atk,
                sp_def,
                speed;
//    String gender;

    Pokemon(Integer pokedex_number) {
        sprite = new Image("pokemon_back\\" + pokedex_number.toString());
    }

    public Image getSprite() {
        return sprite;
    }
}
