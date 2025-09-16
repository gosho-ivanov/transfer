package OOP_NEW_YEAR.Second_Term.Day_10;

public abstract class Worker {
    private String name;
    private float hourlyWage;

    public Worker(float hourlyWage, String name) throws WageException{
        if (hourlyWage <= 0) throw  new WageException();
        else {
            this.hourlyWage = hourlyWage;
            this.name = name;
        }
    }

    public float getHourlyWage(){
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) throws WageException{
        if (hourlyWage <= 0) throw  new WageException();
        else this.hourlyWage = hourlyWage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract float getWeeklySalary();
    public abstract float getHours();
}
