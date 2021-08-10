package Lesson2.State;

public class HumanApp {
    public static void main(String[] args) {
        HumanActivity activity = new Sleeping();
        Developer developer = new Developer();
        developer.setActivity(activity);
        for (int i = 0; i < 10; i++) {
            developer.doSomething();
            developer.cangeActivity();
        }
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
// State are managed from context, - in Strategy state managing from client (main)
class Developer {
    HumanActivity activity;

    public void setActivity(HumanActivity activity) {
        this.activity = activity;
    }

    public void cangeActivity (){
        if (activity instanceof Sleeping){
            setActivity(new Training());
        } else if (activity instanceof Training){
            setActivity(new Coding());
        } else if (activity instanceof Coding){
            setActivity(new Reading());
        } else if (activity instanceof Reading){
            setActivity(new Sleeping());
        }
    }

    public void doSomething(){
        activity.doSomething();
    }
}
