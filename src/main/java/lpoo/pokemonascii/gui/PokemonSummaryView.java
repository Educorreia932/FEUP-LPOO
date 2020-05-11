package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.PokemonSummaryModel;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonRenderer;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonTypeRenderer;
import lpoo.pokemonascii.gui.renderers.text.TextRenderer;
import lpoo.pokemonascii.rules.PokemonSummaryController;
import lpoo.pokemonascii.rules.commands.ChangedStateCommand;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
import lpoo.pokemonascii.rules.commands.summary.SummaryGoDownCommand;
import lpoo.pokemonascii.rules.commands.summary.SummaryGoUpCommand;
import lpoo.pokemonascii.rules.state.GameState;

import java.io.IOException;

import static lpoo.pokemonascii.gui.WorldView.getPressedKey;

public class PokemonSummaryView {
    private PokemonSummaryModel model;
    private Screen screen;
    private Sprite background;
    private Sprite info;
    private Sprite selectedBar;
    private TextGraphics graphics;
    private TextRenderer pokemonLevel;
    private TextRenderer pokemonName;
    private TextRenderer pokedexNumber;
    private TextRenderer pokemonSpecies;
    private PokemonRenderer pokemon;
    private PokemonTypeRenderer primaryType;
    private PokemonTypeRenderer secondaryType;

    public PokemonSummaryView(Screen screen, TextGraphics graphics, PokemonSummaryModel model) {
        this.screen = screen;
        this.graphics = graphics;

        background = new Sprite("summary\\pokemon_background");
        info = new Sprite("summary\\pokemon_info");
        selectedBar = new Sprite("summary\\selected_bar");

        pokemonLevel = new TextRenderer(10, 21, "Lv" + model.getPokemon().getLevel(), "battle");
        pokemonName = new TextRenderer(280, 38, model.getPokemon().getName(), "battle");
        pokedexNumber = new TextRenderer(280, 23, String.format("%03d", model.getPokemon().getPokedexNumber()), "battle");
        pokemonSpecies = new TextRenderer(80, 21, model.getPokemon().getName(), "battle");
        pokemon = new PokemonRenderer(50, 35, model.getPokemon());
        primaryType = new PokemonTypeRenderer(280, 51, model.getPokemon().getSpecies().getPrimaryType());

        if (model.getPokemon().getSpecies().getSecondaryType() != null)
            secondaryType = new PokemonTypeRenderer(337, 51, model.getPokemon().getSpecies().getSecondaryType());

        this.model = model;
    }

    public Command getNextCommand(PokemonSummaryController summary) {
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
                return new SummaryGoUpCommand(summary);
            case ArrowDown:
                return new SummaryGoDownCommand(summary);
            case Escape:
                return new ChangedStateCommand(summary, GameState.Gamemode.WORLD);
            case EOF:
                return new ChangedStateCommand(summary, GameState.Gamemode.EXIT);
        }

        return new DoNothingCommand();
    }

    public void draw() {
        Sprite.drawSprite(info, 0, 16, graphics);
        Sprite.drawSprite(background, 0, 16, graphics);
        Sprite.drawSprite(selectedBar, graphics);

        pokemonLevel.setText(model.getPokemon().getLevel());
        pokemonName.setText(model.getPokemon().getName());
        pokedexNumber.setText(model.getPokemon().getPokedexNumber());
        pokemonSpecies.setText(model.getPokemon().getSpecies().getName());
        pokemon.setPokemon(model.getPokemon());
        primaryType.setType(model.getPokemon().getSpecies().getPrimaryType());

        if (model.getPokemon().getSpecies().getSecondaryType() != null)
            secondaryType.setType(model.getPokemon().getSpecies().getSecondaryType());

        pokedexNumber.draw(graphics);
        pokemonLevel.draw(graphics);
        pokemonSpecies.draw(graphics);
        pokemonName.draw(graphics);
        pokemon.draw(graphics);
        primaryType.draw(graphics);

        if (model.getPokemon().getSpecies().getSecondaryType() != null)
            secondaryType.draw(graphics);

        try {
            screen.refresh();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
