package OOP_NEW_YEAR.Day_07;

public abstract class Figure {
    protected double a;
    protected double b;

    public Figure(double a, double b){
        this.a = a;
        this.b = b;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
