package Lesson1.Cat;

import Lesson1.Interfaces.MakeSound;

public class Lion extends Cats implements MakeSound {
    public Lion(String name) {
        super(name);
    }

   /* @Override
    public String sound() {
        return "Ror";
    }
*/
}
