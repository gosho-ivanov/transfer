package OOP_NEW_YEAR.First_Term.Day_11;

public class Hypermarket {
    public static void main(String[] args) {
        Products[] productsSold;
    }

    public static void getProductsByType(String type, Products[] products){
        for (Products product: products){
            if (product.getStock() > 0){
                System.out.print(product.getName() + " "
                        + product.getTypeProduct() + " "
                        + product.getBestByDate() + " ");
                for (Manufacturer man: product.getManufacturers()){
                    System.out.print(man.getName() + " ");
                }
                System.out.println();
            }

        }
    }

    public static void getProductsByManufacturer(Manufacturer man, Products[] products){
        for (Products product: products){
            for (Manufacturer manufacturer: product.getManufacturers()){
                if (manufacturer.getName().equals(man.getName())){
                    System.out.print(product.getName() + " "
                            + product.getTypeProduct() + " "
                            + product.getBestByDate() + " ");
                }
            }
        }
    }
}
