public class ImpatientStrategy implements OrderingStrategy {
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        bar.order(drink, recipe);
    }

    @Override
    public void happyHourStarted(Bar bar) {

    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
