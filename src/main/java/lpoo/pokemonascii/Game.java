package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;

import lpoo.pokemonascii.rules.observer.Music;
import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.World;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, LineUnavailableException, UnsupportedAudioFileException {
        GameView gui = new GameView(400, 160);
        World world = new World(gui.getScreen(), gui.getGraphics());
        GameState game = new GameState();
        Music music = new Music(game);


        world.start(game);

        while (game.getGamemode() != null){
            Battle battle = new Battle(gui.getScreen(), gui.getGraphics());
            battle.start(game);
            if(game.getGamemode() == null)
                break;
            world.start(game);
        }
    }
}
