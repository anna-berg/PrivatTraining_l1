package Lesson3.AbstractFactory;

public class DeviceApp {
    public static void main(String[] args) {

    }
}

interface Mouse {
    void click();
    void doubleClick();
    void scroll (int dirrection);
}

interface Keyboard {
    void print();
    void println();
}

interface Touchpad{
    void track (int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class EnMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Mouse Click");
    }

    @Override
    public void doubleClick() {
        System.out.println("Mouse double Click");
    }

    @Override
    public void scroll(int dirrection) {
        if(dirrection > 0){
            System.out.println("Mouse scroll up");
        } else if (dirrection < 0){
            System.out.println("Mouse scroll down");
        } else {
            System.out.println("No scrolling");
        }
    }
}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print Line");
    }
}

class EnTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
        System.out.println("Moved " + s + " pixels.");
    }
}