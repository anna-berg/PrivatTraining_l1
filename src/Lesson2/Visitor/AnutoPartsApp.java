package Lesson2.Visitor;

public class AnutoPartsApp {
    public static void main(String[] args) {
        Element engune = new EngineElement();
        Element body = new BodyElement();
        Element car = new CarElement();
        Visitor hooligan = new HooliganVisitor()    ;

        body.accept(hooligan);
        engune.accept(hooligan);
        car.accept(hooligan);

        Visitor mechanic = new MechanicVisitor();
        body.accept(mechanic);
        engune.accept(mechanic);
        car.accept(mechanic);
    }
}
//Visitor
interface Visitor{
    void visit (BodyElement body);
    void visit (EngineElement engine);
    void visit (CarElement car);
    void visit (WheelElement wheel);
}
interface Element{
    void accept (Visitor visitor);
}
//concrete element
class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
    visitor.visit(this);
    }
}
class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
    visitor.visit(this);
    }
}

class CarElement implements Element{
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new BodyElement(), new EngineElement(),
                new WheelElement("Front left"), new  WheelElement("Front right"),
                new WheelElement("Back left"), new  WheelElement("Back right")};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element e:
             elements) {
            e.accept(visitor);
            visitor.visit(this);
        }
    }
}

class WheelElement implements Element{
    String name;
    public WheelElement(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class HooliganVisitor implements Visitor {
    @Override
    public void visit(BodyElement body) {
        System.out.println("Broke the motor");
    }
    @Override
    public void visit(EngineElement engine) {
        System.out.println("scratched the car");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Somoke in a car!!");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Kicked " + wheel.getName() + " wheel!");
    }
}

class MechanicVisitor implements Visitor{

    @Override
    public void visit(BodyElement body) {
        System.out.println("Repear the motor");
    }

    @Override
    public void visit(EngineElement engine) {
        System.out.println("paint the car");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Clean the car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pumped up " + wheel.getName() + " wheel!");

    }
}