package Lesson1.Bird;

import Lesson1.Animal.Animal;

public class Birds extends Animal {
    public static int birdCount = 0;

    public Birds(String name) {
        super(name);
        birdCount++;
    }
}
