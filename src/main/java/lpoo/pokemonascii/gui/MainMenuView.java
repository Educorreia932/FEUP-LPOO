package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.rules.MainMenuController;
import lpoo.pokemonascii.rules.commands.ChangedStateCommand;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
import lpoo.pokemonascii.rules.state.GameState;

import java.io.IOException;

import static lpoo.pokemonascii.gui.BattleView.getPressedKey;

public class MainMenuView {
    private final Screen screen;
    private final TextGraphics graphics;
    private final BackgroundRenderer backgroundRenderer;

    public MainMenuView(Screen screen, TextGraphics graphics) {
        this.screen = screen;
        this.graphics = graphics;

        backgroundRenderer = new BackgroundRenderer("main_menu");
    }

    public void draw() {
        backgroundRenderer.draw(graphics);

        try {
            screen.refresh();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command getNextCommand(MainMenuController mainMenu)  {

        KeyStroke pressedKey = null;
        try {
            pressedKey = getPressedKey(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (pressedKey.getKeyType()) {
            case EOF:
                return new ChangedStateCommand(mainMenu, GameState.Gamemode.EXIT);
            case Enter:
                return new ChangedStateCommand(mainMenu, GameState.Gamemode.WORLD);
            case Character:
                if (pressedKey.getCharacter() == 'q')
                    return new ChangedStateCommand(mainMenu, GameState.Gamemode.EXIT);
        }

        return new DoNothingCommand();
    }
}
