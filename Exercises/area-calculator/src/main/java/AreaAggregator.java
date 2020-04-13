import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private List<AreaShape> shapes = new ArrayList<>();

    public void addShape(AreaShape shape) {
        shapes.add(shape);
    }

    public double sum() {
        double sum = 0;

        for (AreaShape shape : shapes)
            sum += shape.getArea();

        return sum;
    }
}