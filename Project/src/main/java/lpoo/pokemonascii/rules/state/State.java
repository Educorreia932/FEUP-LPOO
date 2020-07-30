package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.gui.GameView;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface State {
    void start(GameState game, GameView gui) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException;
}
