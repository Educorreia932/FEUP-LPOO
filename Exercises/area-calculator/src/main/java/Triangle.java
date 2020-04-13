public class Triangle implements AreaShape {
    double width, height;

    Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (width * height) / 2;
    }
}
