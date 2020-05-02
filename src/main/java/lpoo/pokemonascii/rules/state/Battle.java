package lpoo.pokemonascii.rules.commands.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.BattleController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Battle implements State {
    private BattleController controller;
    private BattleModel model;
    private BattleView view;

    public Battle(Screen screen, TextGraphics graphics) throws ParserConfigurationException, SAXException, IOException {
        model = new BattleModel(6);
        view = new BattleView(screen, graphics, model);

        controller = new BattleController(view, model);
    }

    @Override
    public void start() throws IOException {
        controller.start();
    }
}
