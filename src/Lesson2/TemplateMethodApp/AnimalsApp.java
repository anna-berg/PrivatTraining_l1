package Lesson2.TemplateMethodApp;

public class AnimalsApp {
    public static void main(String[] args) {
    Animal barsik = new Cat();
    barsik.templateMethod();

    Animal dorry = new Fish();
    dorry.templateMethod();
    }
}
abstract class Animal{
    void templateMethod(){
        System.out.println("This " + this.getClass().getSimpleName() + " have:");
        System.out.print("A head, tail, eyes and ");
        differ();
    }
    abstract void differ();
}

class Cat extends Animal{
    @Override
    void differ() {
        System.out.println("many fur on it.");
    }
}

class Fish extends Animal{
    @Override
    void differ() {
        System.out.println("slippery scales.");
    }
}