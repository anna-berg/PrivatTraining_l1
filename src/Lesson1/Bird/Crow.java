package Lesson1.Bird;

import Lesson1.Interfaces.Flying;
import Lesson1.Interfaces.MakeSound;

public class Crow extends Birds implements Flying, MakeSound {
    public Crow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }

    @Override
    public String sound() {
        return "croak";
    }
}
