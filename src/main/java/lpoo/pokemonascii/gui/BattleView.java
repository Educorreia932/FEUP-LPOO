package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.commands.*;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.gui.renderers.BattleMenuRenderer;
import lpoo.pokemonascii.gui.renderers.PokemonRenderer;
import lpoo.pokemonascii.gui.renderers.TextRenderer;
import lpoo.pokemonascii.rules.BattleController;

import java.io.IOException;

public class BattleView {
    private Screen screen;
    private TextGraphics graphics;
    private BattleModel battle;
    private BackgroundRenderer background;
    private PokemonRenderer trainerPokemon;
    private TextRenderer adversaryPokemonName;
    private BattleMenuRenderer battleMenu;
    private BattleMenuRenderer adversaryPokemonBar;
    private BattleMenuRenderer trainerPokemonBar;

    public BattleView(Screen screen, TextGraphics graphics, BattleModel battle) {
        this.screen = screen;
        this.graphics = graphics;

        this.battle = battle;

        background = new BackgroundRenderer("battle_background");
        trainerPokemon = new PokemonRenderer(battle.getTrainerPokemon());
        adversaryPokemonBar = new BattleMenuRenderer(20, 10, "adversary_pokemon_bar");
        trainerPokemonBar = new BattleMenuRenderer(215, 74, "trainer_pokemon_bar");
        battleMenu = new BattleMenuRenderer(0, 112, "battle_menu");
        adversaryPokemonName = new TextRenderer(26, 14, battle.getTrainerPokemon().getName());
    }

    public void drawBattle() throws IOException {
        screen.clear();

        background.draw(graphics);
        trainerPokemon.draw(graphics);
        trainerPokemonBar.draw(graphics);
        adversaryPokemonBar.draw(graphics);
        battleMenu.draw(graphics);
        adversaryPokemonName.draw(graphics);

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
