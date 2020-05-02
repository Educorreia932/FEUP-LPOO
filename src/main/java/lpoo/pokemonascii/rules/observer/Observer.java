package lpoo.pokemonascii.rules.observer;

import lpoo.pokemonascii.rules.state.GameState;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public abstract class Observer {
    protected GameState gamemode;

    public abstract void update() throws IOException, LineUnavailableException;

}
