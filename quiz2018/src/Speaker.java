public class Speaker extends Person {
    private int fee;

    Speaker(String name) {
        super(name);
    }

    Speaker(String name, int age) {
        super(name, age);
        fee = 0;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + getFee() + ".";
    }
}
