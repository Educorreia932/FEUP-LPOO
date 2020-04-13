public class Order {
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public Order(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
    }

    public StringDrink getDrink() {
        return drink;
    }

    public StringRecipe getRecipe() {
        return recipe;
    }

    public StringBar getBar() {
        return bar;
    }
}
