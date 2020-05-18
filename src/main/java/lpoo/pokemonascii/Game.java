package lpoo.pokemonascii;

import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.rules.observer.Music;
import lpoo.pokemonascii.rules.state.Battle;
import lpoo.pokemonascii.rules.state.GameState;
import lpoo.pokemonascii.rules.state.PokemonSummary;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, LineUnavailableException, UnsupportedAudioFileException {
        GameView gui = new GameView(400, 160);
        GameState game = new GameState(gui);
        Music music = new Music(game);

 //       game.setState(new Battle(gui, game.getWorld().getModel().getPlayer()));
//        game.setState(new PokemonSummary(gui, game.getWorld().getModel().getPlayer().getPokemons().get(0)));

        while (game.getState() != null)
            game.getState().start(game, gui);

        gui.getScreen().close();
    }
}
