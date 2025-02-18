package OOP_NEW_YEAR.First_Term.Day_11;

public class Departments {
    private Worker[] workers;
    private Manager manger;
    private String typeOfProductsSold;


    public Departments(Manager manger, String typeOfProductsSold, Worker[] workers) {
        this.manger = manger;
        this.typeOfProductsSold = typeOfProductsSold;
        this.workers = workers;
    }

    public Manager getManger() {
        return manger;
    }

    public void setManger(Manager manger) {
        this.manger = manger;
    }


    public String getTypeOfProductsSold() {
        return typeOfProductsSold;
    }

    public void setTypeOfProductsSold(String typeOfProductsSold) {
        this.typeOfProductsSold = typeOfProductsSold;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }


}
