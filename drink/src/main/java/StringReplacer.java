public class StringReplacer implements StringTransformer {
    char c1, c2;

    public StringReplacer(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(c1, c2));
    }
}
