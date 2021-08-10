package Lesson2.Memento;

public class GameSaveApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LEVEL 1", 300000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("LEVEL 2", 57865000);
        System.out.println(game);

        System.out.println("Loading from faile....");
        game.load(file.getSave());
        System.out.println(game);
    }
}

//Originator
class Game {
    private String level;
    private long ms;

    public void set(String level, long ms){
        this.level = level;
        this.ms = ms;
    }
    public void load (Save save){
        level = save.getLevel();
        ms = save.getMs();
    }
    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
    public Save save(){
        return new Save(level, ms);
    }
}

//Memento
class Save{
    private final String level;
    private final long ms;

    public Save(String level, long ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public long getMs() {
        return ms;
    }
}

//CareTaker
class File{
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
