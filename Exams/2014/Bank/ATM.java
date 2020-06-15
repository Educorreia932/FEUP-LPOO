import java.util.Objects;

public class ATM {
    private int id;
    private String location;
    private String name;

    public ATM(int id, String location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ATM atm = (ATM) o;

        return id == atm.id && location.equals(atm.location) && name.equals(atm.name);
    }

}
