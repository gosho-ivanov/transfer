package OOP_NEW_YEAR.Day_07.ex_01;

public class Parallelogram extends Figure {
    private double h;

    public Parallelogram(double a, double b, double h){
        super(a, b);
        this.h = h;
    }

    @Override
    public double getArea(){
        return this.b * this.h;
    }

    @Override
    public double getPerimeter(){
        return (this.a + this.b) * 2;
    }
}
