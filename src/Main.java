import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle firstCircle = new Circle(2);
        Circle secondCircle = new Circle(7);
        Circle thirdCircle = new Circle(4);
        List<Circle> circles = List.of(firstCircle, secondCircle, thirdCircle);
        Area<Circle> circleArea = new Area<Circle>() {
            @Override
            public double compute(Circle circle) {
                return circle.getRadius() * circle.getRadius() * Math.PI;
            }
        };

        printArea(circles, circleArea);

        Square firstSquare = new Square(2);
        Square secondSquare = new Square(7);
        Square thirdSquare = new Square(4);
        List<Square> squares = List.of(firstSquare, secondSquare, thirdSquare);
        Area<Square> squareArea = square -> square.getSide() * square.getSide();

        printArea(squares, squareArea);
    }

    public static <Shape> void printArea(List<Shape> shapes, Area<Shape> area) {
        shapes.forEach(s -> System.out.println(area.compute(s)));
    }
}