package Lesson1.Animal;

public abstract class Animal {
    private int id = 0;
    private String name;
    static int animalCount = 0;

    public Animal(String name) {
        animalCount++;
        this.id = animalCount;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void eat(){
        System.out.println("animal is eating...");
    }

    public void move(){
        System.out.println("animal is moving...");
    }

    public void getInfo() {
        System.out.println("This animal is " + getClass().getSimpleName() + " it's number is " + this.id + " named " + this.name);
    }
}
