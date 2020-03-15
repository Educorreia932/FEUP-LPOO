package com.educorreia.hero.gui;

import com.educorreia.hero.world.Element;
import com.educorreia.hero.world.Item;
import com.educorreia.hero.world.Position;
import com.educorreia.hero.world.World;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import javafx.geometry.Pos;

import java.awt.*;
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

        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(world.getWidth(), world.getHeight()), ' ');

        this.world = world;
    }

    public void draw() throws IOException {
        screen.clear();

        for (Element element : world.getAllElements())
            element.draw(graphics);

        graphics.putString(0, world.getHeight(), "Health: " + world.getPlayer().getHealth());

        Position playerPosition = world.getPlayer().getPosition();

        if (world.getElement(playerPosition) instanceof Item)
            graphics.putString(0, world.getHeight() + 1, ((Item) world.getElement(playerPosition)).getName());

        screen.refresh();
    }

    public TerminalScreen getScreen() {
        return screen;
    }
}
