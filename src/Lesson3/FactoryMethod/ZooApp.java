package Lesson3.FactoryMethod;

public class ZooApp {
    public static void main(String[] args) {
        AnimalsFactory zoo = getAnimalByName("cat");
        Animals puma = zoo.createAnimal();
        puma.showInfo();
    }

    public static AnimalsFactory getAnimalByName (String name){
        if (name.equalsIgnoreCase("cat")){
            return  new CatsHouse();
        } else if (name.equalsIgnoreCase("bird")){
            return new BirdsHouse();
        } else {
            throw new RuntimeException("No such animal in our zoo");
        }
    }
}

interface Animals{
        void showInfo();
}

abstract class AbstractAnimal implements Animals{
    String name;
    int age;
    @Override
    public void showInfo() {
        System.out.println("Cat " + name + " " + age + " years old");
    }
}

class Cats extends AbstractAnimal implements Animals{
}

class Birds extends AbstractAnimal implements Animals{
}

interface AnimalsFactory{
    Animals createAnimal();
}

class CatsHouse implements AnimalsFactory{

    @Override
    public Animals createAnimal() {
        System.out.println("New Cat created in Cat's House");
        return new Cats();
    }
}

class BirdsHouse implements AnimalsFactory{

    @Override
    public Animals createAnimal() {
        System.out.println("New bird created in bird's house");
        return new Birds();
    }
}