package Lesson1.Cat;

import Lesson1.Animal.Animal;

public class Cats extends Animal {
    public static int catsCount = 0;

    public Cats(String name) {
        super(name);
        catsCount++;
    }
}
