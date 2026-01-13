package Shami.PresentWeb.trolli;

public class Producti {

    private int id;
    private double price;
    private String type;
    private String size;

    public Producti(int id, double price, String size, String type) {
        this.id = id;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Producti[] main(Producti[] pr){
        boolean bl = false;

        for(int i = 0; i<pr.length ; i++){
            do{
                if (pr[i].getId() > pr[i=1].getId()) {
                }
            }


        }



    }





}
