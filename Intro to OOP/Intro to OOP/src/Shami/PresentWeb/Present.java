package Shami.PresentWeb;

public class Present {
    private int id;
    private double price;
    private String type;
    private String size;

    public Present(int id, double price, String size, String type) {
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

    @Override
    public String toString() {
        return "Present{" +
                "id=" + id +
                ", price=" + price +
                ", type='" + type + "'" +
                ", size='" + size + "'" +
                '}';
    }

    public static Present getPresentByID(Present[] presents, int presentId){
        for (Present present : presents){
            if (present.getId() == presentId){
                return present;
            }
        }
        return null;
    }

    public static Present getPresentByType(Present[] presents, String presentType){
        for (Present present : presents){
            if (present.getType().equals(presentType)){
                return present;
            }
        }
        return null;
    }
}
