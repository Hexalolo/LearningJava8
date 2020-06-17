package inheritance;

public class Line extends Shape {
    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter(){
        return new Point (super.getPoint().getX() + to.getX()/2, super.getPoint().getY() + to.getY()/2);
    }
}
