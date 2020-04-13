import java.util.List;

public class StringBar extends Bar {
    public StringBar() {
        super();
    }

    public StringBar(List<BarObserver> observers) {
        super(observers);
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
