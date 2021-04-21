package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.gui.renderers.PlayerRenderer;
import lpoo.pokemonascii.rules.WorldController;
import lpoo.pokemonascii.rules.commands.ChangedStateCommand;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
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
    public boolean running = true;

    public WorldView(Screen screen, TextGraphics graphics, WorldModel world) {
        this.screen = screen;
        this.graphics = graphics;

        backgroundRenderer = new BackgroundRenderer(world.getImage(), world.getPlayer());
        playerRenderer = new PlayerRenderer(world.getPlayer());
    }

    public void draw() throws IOException {
        backgroundRenderer.draw(graphics);
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
                        return new ChangedStateCommand(world, GameState.Gamemode.EXIT);
                    case 's':
                        return new ChangedStateCommand(world, GameState.Gamemode.SUMMARY);
                }
        }

        return new DoNothingCommand();
    }

    public void setBackground(String file, Player player){
        backgroundRenderer = new BackgroundRenderer(file, player);
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
