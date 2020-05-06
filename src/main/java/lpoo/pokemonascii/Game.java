package lpoo.pokemonascii;

import lpoo.pokemonascii.rules.observer.Music;
import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, LineUnavailableException, UnsupportedAudioFileException {
        GameState game = new GameState();
        Music music = new Music(game);

//        game.setState(new Battle(game.getGui(), game.getWorld().getModel().getPlayer()));

        while (game.getState() != null)
            game.getState().start(game);
    }
}
