package inheritance;

import java.util.Objects;

public class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Labeled Point: "+getLabel()+" X: "+super.getX()+" Y: "+super.getY();
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        LabeledPoint otherPoint = (LabeledPoint) otherObject;
        return Objects.equals(getLabel(), otherPoint.getLabel())
                && super.getX() == otherPoint.getX()
                && super.getY() == otherPoint.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }
}
