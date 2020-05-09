package lpoo.pokemonascii.rules.commands.optionsmenu;

import lpoo.pokemonascii.rules.BattleController;
import lpoo.pokemonascii.rules.commands.Command;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ChoseOptionCommand implements Command {
    private BattleController battle;

    public ChoseOptionCommand(BattleController battle) {
        this.battle = battle;
    }

    @Override
    public void execute()  {
        try {
            battle.executeOption(battle.getOptions().getSelectedOption());
        }

        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
