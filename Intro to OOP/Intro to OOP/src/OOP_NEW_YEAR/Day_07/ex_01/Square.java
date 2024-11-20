package OOP_NEW_YEAR.Day_07;

public class Square extends Figure{
    public Square(double a){
        super(a, a);
    }

    @Override
    public double getArea(){
        return this.a*this.a;
    }

    @Override
    public double getPerimeter(){
        return 4*this.a;
    }

}
