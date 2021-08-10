package Lesson2.Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MeteoApp {
    public static void main(String[] args) {
        MeteoStation meteostation = new MeteoStation();
        meteostation.addObserver(new ConsoleObserver());
        meteostation.addObserver(new FileObserver());

        meteostation.setManagements(5,20);
        meteostation.setManagements(-8,520);
    }
}

interface Observed{             //наблюдаемый обьект
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer{             //наблюдатель
    void handleEvent(int temp, int pressure);
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<Observer>();

    public void setManagements(int temp, int pres){
        this.temperature = temp;
        this.pressure = pres;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int pressure) {
        System.out.println("Temperature changed. Temp: " + temp + ", Pressure: " + pressure + ".");
    }
}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int pressure) {
        try {
            PrintWriter pw = new PrintWriter(new File("log.txt"));
            pw.println("Temperature changed. Temp: " + temp + ", Pressure: " + pressure + ".");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}