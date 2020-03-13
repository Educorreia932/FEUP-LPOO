package com.educorreia.hero;

import com.educorreia.hero.gui.Gui;
import com.educorreia.hero.world.World;


import java.io.IOException;

public class Game {
    private Gui gui;

    public static void main(String[] args) throws IOException {
        Game game = new Game();

        game.run();
    }

    public Game() throws IOException {
        World world = new World(30, 20);

        gui = new Gui(world);

        run();
    }

    public void run() throws IOException {
        while (true) {
            gui.draw();

        }
    }
}
