package Lesson1.Fish;

import Lesson1.Interfaces.Swimming;

public class GoldenFish extends Fishes implements Swimming {
    public static int fishCount = 0;
    public GoldenFish(String name) {
        super(name);
    }

/*    @Override
    public void swimm() {
        System.out.println("GoldenFish is swimming");
    }*/
}
