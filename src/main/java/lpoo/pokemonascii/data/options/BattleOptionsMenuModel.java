package lpoo.pokemonascii.data.options;

import java.util.ArrayList;
import java.util.List;

public class BattleOptionsMenuModel extends OptionsMenuModel {
    public BattleOptionsMenuModel() {
        super(createOptionList());
    }

    private static List<Option> createOptionList() {
        List<Option> optionList = new ArrayList<>();
        optionList.add(new Option("FIGHT"));
        optionList.add(new Option("BAG"));
        optionList.add(new Option("POKEMON"));
        optionList.add(new Option("RUN"));

        return optionList;
    }
}
