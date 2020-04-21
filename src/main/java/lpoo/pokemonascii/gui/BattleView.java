package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.commands.*;
import lpoo.pokemonascii.gui.renderers.*;
import lpoo.pokemonascii.rules.BattleController;

import java.io.IOException;

public class BattleView {
    private Screen screen;
    private TextGraphics graphics;
    private BattleModel battle;
    private BackgroundRenderer background;
    private PokemonRenderer trainerPokemon;
    private PokemonRenderer adversaryPokemon;
    private BattleMenuRenderer battleMenu;
    private PokemonInfoRenderer trainerPokemonInfo;
    private PokemonInfoRenderer adversaryPokemonInfo;

    public BattleView(Screen screen, TextGraphics graphics, BattleModel battle) {
        this.screen = screen;
        this.graphics = graphics;

        this.battle = battle;

        background = new BackgroundRenderer("battle_background");
        battleMenu = new BattleMenuRenderer();

        trainerPokemon = new PokemonRenderer(battle.getTrainerPokemon());
        adversaryPokemon = new PokemonRenderer(battle.getAdversaryPokemon());

        trainerPokemonInfo = new PokemonInfoRenderer(battle.getTrainerPokemon());
        adversaryPokemonInfo = new PokemonInfoRenderer(battle.getAdversaryPokemon());
    }

    public void drawBattle() throws IOException {
        screen.clear();

        background.draw(graphics);
        battleMenu.draw(graphics);

        trainerPokemon.draw(graphics);
        adversaryPokemon.draw(graphics);

        trainerPokemonInfo.draw(graphics);
        adversaryPokemonInfo.draw(graphics);

        screen.refresh();
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public Command getNextCommand(BattleController battle) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

        switch (pressedKey.getKeyType()) {
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
}
