import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    List<Order> orders = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        orders.add(new Order(drink, recipe, bar));

        if (bar.isHappyHour())
            bar.order(drink, recipe);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        List<Order> aux = new ArrayList<>();

        for (Order order : orders) {
            if (order.getBar() != bar)
                aux.add(order);

            else
                order.getBar().order(order.getDrink(), order.getRecipe());
        }

        orders = aux;
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
