package inheritance;

import java.util.Objects;

public abstract class Shape {
    private Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        if(Objects.nonNull(point)) {
            this.point = new Point(point.getX() + dx, point.getY() + dy);
        } else {
            this.point = new Point(dx, dy);
        }
    }

    public Point getPoint() {
        return point;
    }

    public abstract Point getCenter();
}
