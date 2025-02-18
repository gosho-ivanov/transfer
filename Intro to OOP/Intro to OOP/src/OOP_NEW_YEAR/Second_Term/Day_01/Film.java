package OOP_NEW_YEAR.Second_Term.Day_01;

public class Film {
    private String name;
    private String producer;
    private int budget;
    private int yearOfRelease;
    private int id;

    public Film(int budget, int id, String name, String producer, int yearOfRelease) {
        this.budget = budget;
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.yearOfRelease = yearOfRelease;
    }

    public Film() {
        this.budget = 0;
        this.yearOfRelease = 0;
        this.name = "";
        this.producer = "";
        this.id = 0;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name=" + name +
                ", producer='" + producer + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", budget='" + budget + '\'' +
                ", id=" + id +
                '}';
    }
}