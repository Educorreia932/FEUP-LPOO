package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.rules.commands.*;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.gui.renderers.PlayerRenderer;
import lpoo.pokemonascii.gui.renderers.TileRenderer;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveDownCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveLeftCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveRightCommand;
import lpoo.pokemonascii.rules.commands.player.PlayerMoveUpCommand;
import lpoo.pokemonascii.rules.state.GameState;

import java.io.IOException;

public class WorldView implements Runnable {
    private Screen screen;
    private TextGraphics graphics;
    private BackgroundRenderer backgroundRenderer;
    private PlayerRenderer playerRenderer;
    private TileRenderer tileRenderer;
    public boolean running = true;

    public WorldView(Screen screen, TextGraphics graphics, WorldModel world) {
        this.screen = screen;
        this.graphics = graphics;

        backgroundRenderer = new BackgroundRenderer("4", world.getPlayer());
        playerRenderer = new PlayerRenderer(world.getPlayer());
        tileRenderer = new TileRenderer(world.getTiles());
    }

    public void draw() throws IOException {
        backgroundRenderer.draw(graphics);
        tileRenderer.draw(graphics);
        playerRenderer.draw(graphics);

        screen.refresh();
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.pollInput();

        return key;
    }

    public Command getNextCommand(WorldController world) {
        KeyStroke pressedKey = null;

        try {
            pressedKey = getPressedKey(screen);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        if (pressedKey == null)
            return new DoNothingCommand();

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                return new PlayerMoveUpCommand(world);
            case ArrowDown:
                return new PlayerMoveDownCommand(world);
            case ArrowRight:
                return new PlayerMoveRightCommand(world);
            case ArrowLeft:
                return new PlayerMoveLeftCommand(world);
            case EOF:
                return new ChangedStateCommand(world, GameState.Gamemode.EXIT);
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
//                        return new QuitCommand(screen);
                        return new ChangedStateCommand(world, GameState.Gamemode.EXIT);
                    case 's':
                        return new ChangedStateCommand(world, GameState.Gamemode.SUMMARY);
                }
        }

        return new DoNothingCommand();
    }

    @Override
    public void run() {
        try {
            screen.clear();

            while (running) {
                backgroundRenderer.firstTime = true;
                draw();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
