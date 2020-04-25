package lpoo.pokemonascii.data;

import java.util.List;

public class OptionsMenuModel {
    private List<Option> options;
    int selectedOption = 0;

    public OptionsMenuModel(List<Option> options) {
        this.options = options;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Position.Direction direction) {
        int oldSelectedOption = selectedOption;

        switch (direction) {
            case UP:
                selectedOption -= 2;
                break;
            case DOWN:
                selectedOption += 2;
                break;
            case RIGHT:
                selectedOption += 1;
                break;
            case LEFT:
                selectedOption -= 1;
                break;
        }

        if (selectedOption < 0)
            selectedOption = oldSelectedOption;
    }

    public List<Option> getOptions() {
        return options;
    }
}
