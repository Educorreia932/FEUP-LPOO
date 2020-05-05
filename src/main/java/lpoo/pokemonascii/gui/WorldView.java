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

import java.io.IOException;

public class WorldView implements Runnable{
    private Screen screen;
    private TextGraphics graphics;
    private BackgroundRenderer backgroundRenderer;
    private PlayerRenderer playerRenderer;
    private TileRenderer tileRenderer;

    public WorldView(Screen screen, TextGraphics graphics, WorldModel world) {
        this.screen = screen;
        this.graphics = graphics;

        backgroundRenderer = new BackgroundRenderer("room");
        playerRenderer = new PlayerRenderer(world.getPlayer());
        tileRenderer = new TileRenderer(world.getTiles());
    }

    public void draw() throws IOException, InterruptedException {
        long start = System.currentTimeMillis();

        screen.clear();

        backgroundRenderer.draw(graphics);
        tileRenderer.draw(graphics);
        playerRenderer.draw(graphics);

        screen.refresh();

        long elapsedTime = System.currentTimeMillis() - start;

        long timeToSleep = 150 - elapsedTime > 0 ? 150 - elapsedTime : 0;

        Thread.sleep(timeToSleep);
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public Command getNextCommand(WorldController world) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

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
                return new QuitCommand(screen);
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
                        return new QuitCommand(screen);
                }
        }

        return new DoNothingCommand();
    }

    @Override
    public void run() {
        try {
            while(true)
                draw();
        }

        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
