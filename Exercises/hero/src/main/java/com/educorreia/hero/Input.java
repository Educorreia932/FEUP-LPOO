package com.educorreia.hero;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public abstract class Input {
    public static KeyStroke getPressedKey(TerminalScreen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }
}
