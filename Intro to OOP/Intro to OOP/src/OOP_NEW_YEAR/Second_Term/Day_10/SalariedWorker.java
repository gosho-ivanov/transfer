package OOP_NEW_YEAR.Second_Term.Day_10;

public class SalariedWorker extends Worker{
    private String work;
    private float hours;

    public SalariedWorker(float hourlyWage, String name, float hours, String work) {
        super(hourlyWage, name);
        if (hours > 0) {
            this.hours = hours;
            this.work = work;
        } else throw new HoursException();
    }

    @Override
    public float getHours() {
        return hours;
    }

    public void setHours(float hours) throws HoursException{
        if (hours > 0) this.hours = hours;
        else throw new HoursException();
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public float getWeeklySalary() {
        return hours * getHourlyWage();
    }
}
