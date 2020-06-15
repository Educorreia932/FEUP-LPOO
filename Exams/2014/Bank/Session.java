import java.util.Objects;

public class Session extends Countable {
    private ATM atm;

    public Session(ATM atm) {
        this.atm = atm;
    }

    public ATM getATM() {
        return atm;
    }

    public void addTransaction(Transaction d) {
        increment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Session session = (Session) o;

        return atm.equals(session.getATM());
    }

    @Override
    public int hashCode() {
        return Objects.hash(atm);
    }
}
