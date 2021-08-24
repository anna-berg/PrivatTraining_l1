package Lesson3.FlyWeight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FigureApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List <Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getSape("circle"));
        shapes.add(shapeFactory.getSape("square"));
        shapes.add(shapeFactory.getSape("circle"));
        shapes.add(shapeFactory.getSape("point"));
        for (Shape sh: shapes
             ) {
            sh.draw(2,6);
        }

    }
}
//Flyweight
interface Shape{
    void draw (int x, int y);
}

//PointFlyweight
class Point implements Shape{

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw a point ");
    }
}
//CircleFlyweight
class Circle implements Shape{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw a circle with radius " + r);
    }
}
//SquareFlyweight
class Square implements Shape{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw a square with side " + a);
    }
}

class ShapeFactory {
    private static final HashMap <String, Shape> shapes = new HashMap<>();
    public Shape getSape (String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "point":
                    shape = new Point();
                    break;
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
            }
        }
        return shape;
    }
}

