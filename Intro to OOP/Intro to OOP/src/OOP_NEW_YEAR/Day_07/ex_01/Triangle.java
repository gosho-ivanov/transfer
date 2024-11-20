package OOP_NEW_YEAR.Day_07.ex_01;

public class Triangle extends Figure {
    private double c;
    private double h;

    public Triangle(double a, double b, double c, double h){
        super(a, b);
        this.c = c;
        this.h = h;
    }

    @Override
    public double getArea(){
        return (this.c*this.h)/2;
    }

    @Override
    public double getPerimeter(){
        return this.a + this.b + this.c;
    }
}
