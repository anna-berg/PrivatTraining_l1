package Lesson2.Visitor;

public class VehicleApp {
    public static void main(String[] args) {
        Passenger AnnaPi = new People();
        Vehicle trian = new Train(5, 2);
        trian.acceptShipping(AnnaPi);

        Vehicle car = new Car(8, 1);
        car.acceptShipping(AnnaPi);

        Vehicle bike = new Bike(5, 3);
        bike.acceptShipping(AnnaPi);

        Passenger bagsNoOne = new Baggage();
        trian.acceptShipping(bagsNoOne);
    }
}

interface Passenger {
    void take (Train train);
    void take (Car car);
    void take (Bike bike);

}
interface Vehicle{
    void acceptShipping(Passenger passager);
}

abstract class Company{
    private int time;
    private int price;

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    public Company(int time, int price) {
        this.time = time;
        this.price = price;
    }
}

class Train extends Company implements Vehicle{

    public Train(int time, int price) {
        super(time, price);
    }

    @Override
    public void acceptShipping(Passenger passager) {
        passager.take(this);
    }
}
class Car extends Company implements Vehicle{

    public Car(int time, int price) {
        super(time, price);
    }

    @Override
    public void acceptShipping(Passenger passager) {
        passager.take(this);
    }
}
class Bike extends Company implements Vehicle{
    public Bike(int time, int price) {
        super(time, price);
    }

    @Override
    public void acceptShipping(Passenger passager) {
        passager.take(this);
    }
}

class People implements Passenger {
    int cost;
    @Override
    public void take(Train train) {
        this.cost = train.getTime() * train.getPrice();
        System.out.println("The passenger must pay " + cost
                + " for a " + train.getClass().getSimpleName() +
                " journey within " + train.getTime() + " minutes");
    }

    @Override
    public void take(Car car) {
        this.cost = car.getTime() * car.getPrice();
        System.out.println("The passenger must pay " + cost
                + " for a " + car.getClass().getSimpleName() +
                " journey within " + car.getTime() + " minutes");    }

    @Override
    public void take(Bike bike) {
        this.cost = bike.getTime() * bike.getPrice();
        System.out.println("The passenger must pay " + cost
                + " for a " + bike.getClass().getSimpleName() +
                " journey within " + bike.getTime() + " minutes");    }
}
class Baggage implements Passenger {
    int cost;

    @Override
    public void take(Train train) {
        this.cost = train.getTime() * train.getPrice();
        System.out.println("Amount for baggage " + this.getClass().getSimpleName() +
                " transportation is " + cost + " shipping by " +
                train.getClass().getSimpleName() + ", delivering time is " +
                train.getTime() + " minutes");
    }

    @Override
    public void take(Car car) {
        this.cost = car.getTime() * car.getPrice();
        System.out.println("Amount for baggage " + this.getClass().getSimpleName() +
                " transportation is " + cost + " shipping by " +
                car.getClass().getSimpleName() + ", delivering time is " +
                car.getTime() + " minutes");
    }

    @Override
    public void take(Bike bike) {
        this.cost = bike.getTime() * bike.getPrice();
        System.out.println("Amount for baggage " + this.getClass().getSimpleName() +
                " transportation is " + cost + " shipping by " +
                bike.getClass().getSimpleName() + ", delivering time is " +
                bike.getTime() + " minutes");
    }
}