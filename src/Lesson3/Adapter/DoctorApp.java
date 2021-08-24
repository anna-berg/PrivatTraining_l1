package Lesson3.Adapter;

public class DoctorApp {
    public static void main(String[] args) {
        AnimalDoctor animalDoctor = new AdaptingHumanDoctorToAnimal();
        animalDoctor.inspectionAnimal();
        animalDoctor.testsAnimal();
        animalDoctor.peelsAnimal();
    }
}

interface AnimalDoctor{
    void inspectionAnimal();
    void testsAnimal();
    void peelsAnimal();
}

class HumanDoctor{
    void inspectionHuman(){
        System.out.println("Listen the pation");
    }
    void testsHuman() {
        System.out.println("Making a tests");
    }
    void peelsHuman(){
        System.out.println("Prescribe treatment");
    }
}

class AdaptingHumanDoctorToAnimal extends HumanDoctor implements AnimalDoctor{
    @Override
    public void inspectionAnimal() {
        inspectionHuman();
    }

    @Override
    public void testsAnimal() {
        testsHuman();
    }

    @Override
    public void peelsAnimal() {
        peelsHuman();
    }
}