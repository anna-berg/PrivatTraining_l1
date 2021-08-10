package Lesson2.State;

public class State {
    public static void main(String[] args) {
 /*       Station hitFM = new HitFM();
        Radio radio = new Radio();
        radio.setStation(hitFM);

        for (int i = 0; i < 10; i++) {
            radio.nextStation();
            radio.play();
        }*/

        Human human = new Human();
        human.setState(new DoWork());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}
//context
class Human {
    private Activity state;
    public void setState (Activity state){
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}

//state
interface Activity{
    void doSomething (Human context);
}

class DoWork implements Activity{

    @Override
    public void doSomething(Human context) {
        System.out.println("Working...");
        context.setState(new Weekend());
    }
}
class Weekend implements Activity {
    int count = 0;
    @Override
    public void doSomething(Human context) {
        if (count <3){
            System.out.println("Resting... zzz...");
            count++;
        } else {
            context.setState(new DoWork());
        }
    }
}

interface Station {
    void play();
}

class HitFM implements Station {

    @Override
    public void play() {
        System.out.println("HitFM play my favorite music");
    }
}
class LuxFM implements Station {

    @Override
    public void play() {
        System.out.println("LuxFM play music");
    }
}
class ProstoRadio implements Station {

    @Override
    public void play() {
        System.out.println("ProstoRadio play music");
    }
}

class Radio { // context
    Station station; //our station
    void setStation(Station st){
        this.station = st;
    }

    void nextStation(){
        if (station instanceof HitFM){
            setStation(new LuxFM());
        } else if (station instanceof LuxFM){
            setStation(new ProstoRadio());
        } else if (station instanceof  ProstoRadio){
            setStation(new HitFM());
        }
    }
    void play(){
        station.play();
    }
}
