package lpoo.pokemonascii.rules.state;


import java.io.IOException;

public interface State {
    void start(GameState game) throws IOException;
}
