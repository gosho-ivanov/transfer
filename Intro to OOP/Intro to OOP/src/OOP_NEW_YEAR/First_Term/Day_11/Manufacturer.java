package OOP_NEW_YEAR.First_Term.Day_11;

public class Manufacturer {
    private String name;
    private String productionCountry;

    public Manufacturer(String name, String productionCountry) {
        this.name = name;
        this.productionCountry = productionCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }
}
