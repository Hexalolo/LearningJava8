package inheritance;

public class Circle extends Shape {
    private double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return new Point(super.getPoint().getX() + radius/2, super.getPoint().getY() + radius/2);
    }
}
