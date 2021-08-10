package Lesson2.Command;

public class CarApp {
    public static void main(String[] args) {
        Car mustang = new Car();
        Driver driver = new Driver(new Gaz(mustang), new Break(mustang),
                new Transmission(mustang), new Parking(mustang));
        driver.start();
        driver.transmission();
        driver.stop();
        driver.parking();
    }
}

interface Driving {
    void drive();
}

class Car {
    void gaz(){
        System.out.println("Car is driving");
    }
    void stop(){
        System.out.println("Car has stopped");
    }
    void transmission(){
        System.out.println("Changing transmission");
    }
    void parking(){
        System.out.println("Car parking");
    }

}
class Gaz implements Driving {
    Car car;

    public Gaz(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.gaz();
    }
}
class Break implements Driving {
    Car car;

    public Break(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.stop();
    }
}
class Transmission implements Driving {
    Car car;

    public Transmission(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.transmission();
    }
}
class Parking implements Driving {
    Car car;

    public Parking(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.parking();
    }
}

class Driver {
    Driving gaz;
    Driving stop;
    Driving transmission;
    Driving parking;

    public Driver(Driving gaz, Driving stop, Driving transmission, Driving parking) {
        this.gaz = gaz;
        this.stop = stop;
        this.transmission = transmission;
        this.parking = parking;
    }

    void start (){
        gaz.drive();
    }
    void stop(){
        stop.drive();
    }
    void transmission(){
        transmission.drive();
    }
    void parking(){
        parking.drive();
    }
}