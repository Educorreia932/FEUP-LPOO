package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.SoundEffects.SelectSound;
import lpoo.pokemonascii.data.SoundEffects.SoundEffect;
import lpoo.pokemonascii.gui.MainMenuView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.state.GameState;


public class MainMenuController implements Controller {
    private MainMenuView gui;
    private GameState.Gamemode gamemode;
    private SoundEffect selectSound;

    public MainMenuController(MainMenuView gui) {
        this.gui = gui;
        gamemode = GameState.Gamemode.MAIN_MENU;
        selectSound = new SelectSound();
    }

    @Override
    public GameState.Gamemode start(GameState game) {
        while (gamemode == GameState.Gamemode.MAIN_MENU) {
            gui.draw();

            Command command;

            command = gui.getNextCommand(this);

            selectSound.play();
            command.execute();

        }

        return gamemode;
    }

    @Override
    public void setGamemode(GameState.Gamemode gamemode) {
        this.gamemode = gamemode;
    }
}
