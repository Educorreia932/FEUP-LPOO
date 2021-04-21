package lpoo.pokemonascii.rules.state;

import lpoo.pokemonascii.data.MainMenuModel;
import lpoo.pokemonascii.gui.GameView;
import lpoo.pokemonascii.gui.MainMenuView;
import lpoo.pokemonascii.rules.MainMenuController;

public class MainMenu implements State {
    private MainMenuView view;
    private MainMenuModel model;
    private MainMenuController controller;

    public MainMenu(GameView gui) {
        view = new MainMenuView(gui.getScreen(), gui.getGraphics());
        controller = new MainMenuController(view);
    }

    @Override
    public void start(GameState game, GameView gui) {
        game.setState(this);

        switch (controller.start(game)) {
            case WORLD:
                game.setState(game.getWorld());
                break;
            case EXIT:
                game.setState(null);
                break;
        }
    }
}
