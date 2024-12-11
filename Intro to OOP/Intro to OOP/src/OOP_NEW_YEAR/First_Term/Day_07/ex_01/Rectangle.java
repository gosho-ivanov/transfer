package OOP_NEW_YEAR.First_Term.Day_07.ex_01;

public class Rectangle extends Figure {
    public Rectangle(double a, double b){
        super(a, b);
    }

    @Override
    public double getArea(){
        return this.a * this.b;
    }

    public double getPerimeter(){
        return 2*(this.a + this.b);
    }
}
