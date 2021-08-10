package Lesson2.Strategy;

public class HumanApp {
    public static void main(String[] args) {
        Developer developer = new Developer();

        developer.setActivity(new Sleeping());
        developer.doSomething();

        developer.setActivity(new Training());
        developer.doSomething();

        developer.setActivity(new Coding());
        developer.doSomething();

        developer.setActivity(new Reading());
        developer.doSomething();

        }
}

interface HumanActivity{
    public void doSomething();
}

class Coding implements HumanActivity{

    @Override
    public void doSomething() {
        System.out.println("Writing a code....");
    }
}

class Reading implements HumanActivity{
    @Override
    public void doSomething() {
        System.out.println("Reading a book...");
    }
}

class Sleeping implements HumanActivity{

    @Override
    public void doSomething() {
        System.out.println("Sleeping....");
    }
}

class Training implements HumanActivity{
    @Override
    public void doSomething() {
        System.out.println("Training...");
    }
}

// Context
// state managing from client (main)
class Developer {
    HumanActivity activity;

    public void setActivity(HumanActivity activity) {
        this.activity = activity;
    }

    public void doSomething(){
        activity.doSomething();
    }
}
