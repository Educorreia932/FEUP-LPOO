package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.observer.Observer;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameState {
    private State state;
    List<Observer> observers;
    private GameView gui;
    private World world;

    public enum Gamemode {
        WORLD,
        BATTLE,
        EXIT
    }

    public GameState() throws IOException, UnsupportedAudioFileException, LineUnavailableException, SAXException, ParserConfigurationException {
        gui = new GameView(400, 160);
        observers = new ArrayList<>();
        world = new World(gui);
        setState(world);
    }

    public void setState(State state) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        this.state = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        for(Observer ob : observers)
            ob.update();
    }

    public State getState() { return state; }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public List<Observer> getObservers(){
        return observers;
    }

    public GameView getGui() {
        return gui;
    }

    public World getWorld() {
        return world;
    }
}
