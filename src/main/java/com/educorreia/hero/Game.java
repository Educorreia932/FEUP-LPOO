package com.educorreia.hero;

import com.educorreia.hero.gui.Gui;
import com.educorreia.hero.world.World;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Game {
    private Gui gui;
    private World world;

    public static void main(String[] args) throws IOException {
        Game game = new Game();

        game.run();
    }

    public Game() throws IOException {
        world = new World(30, 20);

        gui = new Gui(world);

        run();
    }

    public void run() throws IOException {
        while (true) {
            gui.draw();

            KeyStroke pressedKey = Input.getPressedKey(gui.getScreen());

            if (pressedKey.getKeyType() == KeyType.Character && pressedKey.getCharacter() == 'q')
                gui.getScreen().close();

            if (pressedKey.getKeyType() == KeyType.EOF)
                return;

            world.step(pressedKey);
        }
    }
}
