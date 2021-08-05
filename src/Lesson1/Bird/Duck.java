package Lesson1.Bird;

import Lesson1.Interfaces.Flying;
import Lesson1.Interfaces.MakeSound;
import Lesson1.Interfaces.Swimming;

public class Duck extends Birds implements Flying, MakeSound, Swimming {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public String sound() {
            return "quack";
    }

    @Override
    public void swimm() {
        System.out.println("Duck is swimming");
    }
}
