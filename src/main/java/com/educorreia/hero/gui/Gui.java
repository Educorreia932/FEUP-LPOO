package com.educorreia.hero.gui;

import com.educorreia.hero.world.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Gui {
    private World world;
    private TerminalScreen screen;
    private TextGraphics graphics;

    public Gui(World world) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        graphics = screen.newTextGraphics();

        this.world = world;
    }

    private void displayInventory(Player player) {

    }

    private void drawItem(Item item) {
        int i = 2;

        graphics.putString(world.getWidth() + 7, 0, item.getName());

        for (String line : item.getAppearance())
            graphics.putString(world.getWidth() + 7, i++, line);
    }

    public void draw() throws IOException {
        screen.clear();

        graphics.fillRectangle(new TerminalPosition(world.getWidth() + 5, 0), new TerminalSize(1, world.getHeight()), '#');

        for (Element element : world.getAllElements())
            element.draw(graphics);

        graphics.putString(0, world.getHeight() + 1, "Health: " + world.getPlayer().getHealth());

        Position playerPosition = world.getPlayer().getPosition();

        if (world.getElement(playerPosition) instanceof Item)
            drawItem((Item) world.getElement(playerPosition));

        screen.refresh();
    }

    public TerminalScreen getScreen() {
        return screen;
    }
}
