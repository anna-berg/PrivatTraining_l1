package JUnitTests;

public class Vector2D {

    public static void main(String[] args) {
        Vector2D v2 = new Vector2D();
        double l = v2.lenght();
    }
    
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double lenght (){
        return Math.sqrt(x*x + y*y);
    }
}
