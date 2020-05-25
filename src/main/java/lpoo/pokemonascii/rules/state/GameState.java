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
    private World world;

    public enum Gamemode {
        MAIN_MENU,
        WORLD,
        SUMMARY,
        BATTLE,
        EXIT
    }

    public GameState(GameView gui) throws IOException, SAXException, ParserConfigurationException {
        observers = new ArrayList<>();
        world = new World(gui);
        setState(new MainMenu(gui));
    }

    public void setState(State state)  {
        this.state = state;

        try {
            notifyAllObservers();
        }

        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
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

    public World getWorld() {
        return world;
    }
}
