package inheritance;

public class MainInheritance {
    public static void main(String[] args) {
        System.out.println("Hello");
        LabeledPoint myLabel = new LabeledPoint(17.4, 75.3, "label23");
        System.out.println(myLabel.toString());
        Circle myCircle = new Circle(new Point(43.3, 56.4), 32.5);
        System.out.println(myCircle.getCenter().toString());
        System.out.println(myCircle.getCenter().getX() + "   " + myCircle.getCenter().getY());
        System.out.println(MyColor.BLACK);
        System.out.println(MyColor.values());
        System.out.println(MyColor.BLUE.ordinal());
        MyColor myColor = MyColor.BLACK;
        System.out.println(myColor.getBlue());
        System.out.println(myColor);

        
    }
}
