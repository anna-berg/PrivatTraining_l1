package Lesson1.Fish;

import Lesson1.Animal.Animal;

public class Fishes extends Animal {
    public static int fishCount = 0;

    public Fishes(String name) {
        super(name);
        fishCount++;
    }
}
