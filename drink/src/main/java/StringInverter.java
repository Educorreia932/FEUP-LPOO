public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        drink.setText(new StringBuilder().append(drink.getText()).reverse().toString());
    }
}
