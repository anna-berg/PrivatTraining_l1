package Lesson1.Cat;

import Lesson1.Interfaces.MakeSound;

public class Kitten extends Cats implements MakeSound {
    public Kitten(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "meow";
    }
}
