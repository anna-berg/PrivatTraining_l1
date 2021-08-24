package Lesson3.Bridge;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Sedan(new Toyota());
        car.showType();
    }
}

abstract class Car{
    Brand brand;

    public Car(Brand brand) {
        this.brand = brand;
    }
    void showType(){
        brand.setBrand();
        showDetails();
    }
    abstract void showDetails();

}

class Sedan extends Car{
    public Sedan(Brand brand) {
        super(brand);
    }

    @Override
    void showDetails() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car{
    public Hatchback(Brand brand) {
        super(brand);
    }

    @Override
    void showDetails() {
        System.out.println("Hatchback");
    }
}
interface Brand{
    void setBrand();
}
class Toyota implements  Brand{
    @Override
    public void setBrand() {
        System.out.println("Toyota");
    }
}

class Opel implements Brand{
    @Override
    public void setBrand() {
        System.out.println("Opel");
    }
}