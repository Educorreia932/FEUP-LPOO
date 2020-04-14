package lpoo.pokemonascii.commands;

import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.game.Map;

import java.io.IOException;

public class QuitCommand implements Command {
    private Map map;
    private Screen screen;

    public QuitCommand(Map map, Screen screen) {
        this.map = map;
        this.screen = screen;
    }

    @Override
    public void execute() {
        try {
            screen.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
