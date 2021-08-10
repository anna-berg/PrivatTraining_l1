package Lesson2.Observer;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    public static void main(String[] args) {
        Market metro = new Market();
        metro.addProduct("Milk");
        metro.addProduct("Bread");

        ObserverProd subscriberOne = new Subsribers("Anna");
        ObserverProd subscriberTwo = new Subsribers("Sanya");

        metro.addObserverProduct(subscriberOne);
        metro.addObserverProduct(subscriberTwo);
        metro.addProduct("Honey");
        metro.removeProduct("Bread");

    }
}

interface ObserverProd {
    public void handleEvent (List<String> products);
}

interface ObservedProcuct{
    void addObserverProduct(ObserverProd o);
    void removeObserverProduct(ObserverProd o);
    void notifyObserversProduct();
}


class Subsribers implements ObserverProd{
    String name;

    public Subsribers(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> products) {
        System.out.println("Dear, " + name + "! We've got these products: " + products);
    }
}

class Market implements ObservedProcuct{
    List <String> products = new ArrayList<>();
    List <ObserverProd> subscribers = new ArrayList<>();

    public void addProduct (String prod){
        this.products.add(prod);
        notifyObserversProduct();
    }
    public void removeProduct (String prod){
        this.products.remove(prod);
        notifyObserversProduct();
    }



    @Override
    public void addObserverProduct(ObserverProd o) {
        this.subscribers.add(o);
    }

    @Override
    public void removeObserverProduct(ObserverProd o) {
        this.subscribers.remove(o);
    }

    @Override
    public void notifyObserversProduct() {
        for (ObserverProd observer: subscribers) {
            observer.handleEvent(this.products);
        }
    }
}