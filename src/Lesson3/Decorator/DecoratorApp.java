package Lesson3.Decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new Printer("Hello World!");
        printer.print();
        PrinterInterface printerWithDecor = new Decorator(new Printer("My name is Ann"));
        printerWithDecor.print();
    }
}
interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
        System.out.println();

    }
}

class Decorator implements PrinterInterface{
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\" ");
        System.out.println();
    }
}