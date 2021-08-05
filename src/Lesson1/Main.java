package Lesson1;

import Lesson1.Animal.Animal;
import Lesson1.Bird.Birds;
import Lesson1.Bird.Crow;
import Lesson1.Bird.Duck;
import Lesson1.Cat.Cats;
import Lesson1.Cat.Kitten;
import Lesson1.Cat.Lion;
import Lesson1.Fish.Fishes;
import Lesson1.Fish.GoldenFish;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Animal> animals = new LinkedList<Animal>();
        animals.add(new Kitten("Murka"));
        animals.add(new Lion("Shram"));
        animals.add(new Crow("Karkusha"));
        animals.add(new Duck( "Scrooge"));
        animals.add(new GoldenFish( "Ariel"));

        Animal lion = new Lion("Simba");
        lion.getInfo();
        Animal kitten = new Kitten("Murzik");
        kitten.getInfo();
        Animal crow = new Crow("Karych");
        System.out.println("Cats total:" + Cats.catsCount);
        System.out.println("Birds total:" + Birds.birdCount);
        System.out.println("Fishes total:" + Fishes.fishCount);
        animals.get(4).getInfo();
    }

}
