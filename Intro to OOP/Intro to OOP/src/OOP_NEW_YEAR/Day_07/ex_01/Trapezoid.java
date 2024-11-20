package OOP_NEW_YEAR.Day_07;

public class Trapezoid extends Figure{
    private double c;
    private double h;

    public Trapezoid(double a, double b, double c, double h) {
        super(a, b);
        this.c = c;
        this.h = h;
    }

    @Override
    public double getArea() {
        return ((this.a + this.b) * this.h) / 2;
    }

    @Override
    public double getPerimeter() {
        return 2*this.c + this.a + this.b;
    }
}
