package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.commands.Command;
import lpoo.pokemonascii.gui.commands.QuitCommand;

import java.io.IOException;

public class BattleController {
    private BattleView gui;
    private BattleModel battle;

    public BattleController(BattleView gui, BattleModel battle) {
        this.gui = gui;
        this.battle = battle;
    }

    public void start() throws IOException {
        while (true) {
            gui.drawBattle();
        }
    }
}
