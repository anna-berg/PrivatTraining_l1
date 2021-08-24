package Lesson3.Composite;

import java.util.ArrayList;
import java.util.List;

public class Figures {
    public static void main(String[] args) {
        Composite composite1 = new Composite();
        composite1.addComponent(new Cicle());
        composite1.addComponent(new Triangle());
        composite1.addComponent(new Cicle());
        composite1.addComponent(new Square());
        composite1.addComponent(new Triangle());

        Composite composite2 = new Composite();
        composite2.addComponent(new Triangle());
        composite2.addComponent(new Cicle());
        composite2.addComponent(new Square());
        composite2.addComponent(new Square());
        composite2.addComponent(new Cicle());

        composite1.draw();
        composite2.draw();

        composite2.addComponent(composite1);
        composite2.draw();
    }
}
interface Shape {
    void draw();
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

class Cicle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a cicle");
    }
}
class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    void addComponent(Shape shape){
        components.add(shape);
    }

    void removecomponent (Shape shape){
        components.remove(shape);
    }
    @Override
    public void draw() {
        for (Shape component:
             components) {
            component.draw();
        }
    }
}