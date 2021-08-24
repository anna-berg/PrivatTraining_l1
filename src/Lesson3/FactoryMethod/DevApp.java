package Lesson3.FactoryMethod;

public class DevApp {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpeciality("java");
        Developer developer = developerFactory.cerateDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String speciality){
        if (speciality.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        } else if (speciality.equalsIgnoreCase("c++")){
            return new CppDeveloperFactory();
        }else {
            throw new RuntimeException(speciality + "is unknown speciality.");
        }
    }
}
interface Developer {
    void writeCode();
}

interface DeveloperFactory {
    Developer cerateDeveloper();
}

class JavaDeveloperFactory implements DeveloperFactory{

    @Override
    public Developer cerateDeveloper() {
        return new JavaDeveloper();
    }
}
class CppDeveloperFactory implements DeveloperFactory{

    @Override
    public Developer cerateDeveloper() {
        return new CppDeveloper();
    }
}
class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("JavaDeveloper writs java code...");
    }
}
class CppDeveloper implements Developer{

    @Override
    public void writeCode() {
        System.out.println("C++ developer writs c++ code...");
    }
}
