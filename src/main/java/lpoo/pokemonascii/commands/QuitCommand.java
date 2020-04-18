package lpoo.pokemonascii.commands;
import lpoo.pokemonascii.game.Game;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class QuitCommand implements Command {
    private Screen screen;

    public QuitCommand(Screen screen) {
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
