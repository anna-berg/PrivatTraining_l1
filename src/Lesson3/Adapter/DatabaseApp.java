package Lesson3.Adapter;

public class DatabaseApp {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.insert();
        database.remove();
        database.select();
        database.update();
    }
}
interface Database{
    void insert();
    void update();
    void select();
    void remove();
}
class JavaApplecation{
    void saveObject(){
        System.out.println("Saving object....");
    }
    void updateObject(){
        System.out.println("Updating object...");

    }
    void loadObject(){
        System.out.println("Loading object...");
    }
    void deleteObject(){
        System.out.println("Deleting object....");

    }
}

class AdapterJavaToDatabase extends JavaApplecation implements Database{
    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void remove() {
        deleteObject();
    }
}