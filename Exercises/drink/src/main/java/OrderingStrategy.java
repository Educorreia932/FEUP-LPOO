public interface OrderingStrategy {
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);

    void happyHourStarted(Bar bar);

    void happyHourEnded(Bar bar);
}
