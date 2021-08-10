package Lesson2.Command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface Command{
    void execute();
}

//Reciver
class Comp {
    void Start(){
        System.out.println("Start");
    }
    void Stop(){
        System.out.println("Stop");
    }
    void Reset(){
        System.out.println("Reset");
    }
}
//ConcreteCommand
class StartCommand implements Command{
    Comp comp;

    public StartCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.Start();
    }
}
class StopCommand implements Command{
    Comp comp;

    public StopCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.Stop();
    }
}
class ResetCommand implements Command{
    Comp comp;

    public ResetCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.Reset();
    }
}
//Invoker
class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}