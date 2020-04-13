public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuilder aux = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (Character.isLowerCase(text.charAt(i)))
                aux.append(Character.toUpperCase(text.charAt(i)));

            else
                aux.append(Character.toLowerCase(text.charAt(i)));
        }

        drink.setText(aux.toString());
    }
}
