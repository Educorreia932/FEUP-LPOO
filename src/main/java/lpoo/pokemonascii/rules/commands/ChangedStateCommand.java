package lpoo.pokemonascii.rules.commands;

import lpoo.pokemonascii.rules.Controller;
import lpoo.pokemonascii.rules.state.GameState;

public class ChangedStateCommand implements Command {
    Controller controller;
    GameState.Gamemode gamemode;

    public ChangedStateCommand(Controller controller, GameState.Gamemode gamemode) {
        this.controller = controller;
        this.gamemode = gamemode;
    }

    @Override
    public void execute() {
        controller.setGamemode(gamemode);
    }
}
