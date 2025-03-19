package OOP_NEW_YEAR.Second_Term.Day_06;

import java.util.ArrayList;

public class Client {
    private String name;
    private String email;
    private String address;
    private String password;
    private ArrayList<Stocks> basket;

    public Client(String address,String password, String email, String name) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.password = password;
        this.basket = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Stocks> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Stocks> basket) {
        this.basket = basket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToBasket(Stocks stock){
        this.basket.add(stock);
    }

    public void removeFromBasket(Stocks stock){
        for (Stocks s: basket){
            if (s.getSerialNumber() == stock.getSerialNumber()){
                basket.remove(s);
            }
        }
    }

    public void placeOrder(){
        System.out.println("The client " + this.getName() +
                           " has placed an order for " + basket.size() +
                           " for the following address:\n" + this.getAddress());
    }
}
