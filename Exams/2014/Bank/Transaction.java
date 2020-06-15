public abstract class Transaction {
    private double amount;
    private ATM atm;
    private Session session;
    private Card card;

    public Transaction(ATM atm, Session s, Card c, int i) {
        this.atm = atm;
        session = s;
        card = c;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return getClass().getName() + " at ATM " + atm.getID() + " (" + atm.getLocation() + ", " + atm.getName() + ") of " + String.format("%.2f", amount).replace(",", ".");
    }
}
