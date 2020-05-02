package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.rules.observer.Observer;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameState {
    private State gamemode;
    List<Observer> observers;

    public GameState(){
        observers = new ArrayList<>();
    }

    public void setState(State state) throws IOException, LineUnavailableException {
        gamemode = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() throws IOException, LineUnavailableException {
        for(Observer ob : observers)
            ob.update();
    }

    public State getGamemode() { return gamemode; }

    public void addObserver(Observer observer){
        observers.add(observer);
    }
}
