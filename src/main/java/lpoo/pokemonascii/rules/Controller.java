package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.rules.state.GameState;

public interface Controller {
    GameState.Gamemode start(GameState game);

    void setGamemode(GameState.Gamemode gamemode);
}
