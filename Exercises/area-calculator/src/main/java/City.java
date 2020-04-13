import java.util.List;

public class City {
    List<House> houses;

    City(List<House> houses) {
        this.houses = houses;
    }

    public double sum() {
        double sum = 0;

        for (House house : houses)
            sum += house.getArea();

        return sum;
    }

    public void add(House house) {
        houses.add(house);
    }
}
