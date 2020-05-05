package lpoo.pokemonascii.data.options.battle;

import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;

import java.util.ArrayList;
import java.util.List;

public class BattleOptionsMenuModel extends OptionsMenuModel {
    public BattleOptionsMenuModel() {
        super(createOptionList());
    }

    private static List<Option> createOptionList() {
        List<Option> optionList = new ArrayList<>();
        optionList.add(new BattleOption("FIGHT"));
        optionList.add(new BattleOption("BAG"));
        optionList.add(new BattleOption("POKEMON"));
        optionList.add(new BattleOption("RUN"));

        return optionList;
    }
}
