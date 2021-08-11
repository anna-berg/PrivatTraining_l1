package Lesson2.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Bike extends Vehicle{
    //шаблон Immutable - мы не можем изменять состояния обьекта после его создания.

    private Date startTrip;
    private Date endTrip;
    private double costPerSec;
    long durationTrip;

    public Bike (Date start, Date end, double costPerSec) {
        this.startTrip = start;
        this.endTrip = end;
        this.costPerSec = costPerSec;
        this.durationTrip = end.getTime() - start.getTime();
    }

    public Date getStartTrip() {
        return startTrip;
    }
    public Date getEndTrip() {
        return endTrip;
    }
    public double getCostPerSec() {
        return costPerSec;
    }
    public long getDurationTrip() {
        return durationTrip;
    }

    BikeCategory bikeCategory = new BikeCategory();
    public BikeCategory addBikes(){
        bikeCategory.add("Mountain Bike");
        bikeCategory.add("Town Bike");
        bikeCategory.add("Extrime bike");

        return bikeCategory;
    }
}

// шаблон Делегирование - список великов может использовать только указанные методы ArrayList, но не все.
class BikeCategory {
    private ArrayList <String > listOfBikes;

    BikeCategory() {
        listOfBikes = new ArrayList <String>();
    }

    public int size() {
        return listOfBikes.size();
    }

    public boolean isEmpty() {
        return listOfBikes.isEmpty();
    }

    public boolean contains(Object o) {
        return listOfBikes.contains(o);
    }

    public String get(int index) {
        return listOfBikes.get(index);
    }

    public String set(int index, String element) {
        return listOfBikes.set(index, element);
    }

    public boolean add(String s) {
        return listOfBikes.add(s);
    }

    public String remove(int index) {
        return listOfBikes.remove(index);
    }

    public void sort(Comparator<? super String> c) {
        listOfBikes.sort(c);
    }

    @Override
    public boolean equals(Object o) {
        return listOfBikes.equals(o);
    }

    @Override
    public String toString() {
        return listOfBikes.toString();
    }
}
