package Lesson3.Facade;

public class JobApp {
    public static void main(String[] args) {
        WorkFlow workFlow = new WorkFlow();
        workFlow.solveProblem();
    }
}
class WorkFlow{
    Job job = new Job();
    Developer developer = new Developer();
    BugTracker bugTracker = new BugTracker();

    public void solveProblem(){
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDedline(bugTracker);
    }
}
class Job{
    public void doJob(){
        System.out.println("Do job....");
    }
}
class BugTracker {
    private boolean activeSprint;
    public boolean isActiveSprint(){
        return activeSprint;
    }

    public void startSprint () {
        System.out.println("Sprint is active...");
        activeSprint = true;
    }
    public void finishSprint (){
        System.out.println("Sprint not active...");
        activeSprint = false;
    }
}

class Developer{
    public void doJobBeforeDedline(BugTracker bugTracker){
        if (bugTracker.isActiveSprint()){
            System.out.println("Developer is solving problems...");
        } else {
            System.out.println("Developer is reading HabrHabr");
        }
    }
}

