package lecture;

import java.util.Scanner;

public class Store {
    private static Product[] offeredProducts = new Product[255];
    private static Scanner s = new Scanner(System.in);

    private static void addProducts(){
        for (int i = 0; i < 255; i++){
            String brand = s.nextLine();
            String type = s.nextLine();
            double minPrice = s.nextDouble();
            int stock = s.nextInt();
            offeredProducts[i] = new Product(brand, type, minPrice, stock);
        }
    }

    private static void deliveryProduct(Product product, int quantity){
        product.setStock(product.getStock() + quantity);
    }

    private static void sellProduct(Product product, int quantity){
        if (checkAvailability(product, quantity)){
            product.setStock(product.getStock() - quantity);
        } else {
            deliveryProduct(product, 2*quantity);
            product.setStock(product.getStock() - quantity);
        }
    }

    private static boolean checkAvailability(Product product, int quantity){
        if (product.getStock() - quantity < 2){
            return false;
        } else {
            return true;
        }
    }

    private static Product findMinPriceByType(String type){
        double currMinPrice = 10_000_000;
        Product cheapestProduct = null;
        for (Product pr: offeredProducts){
            if (pr.getType().equals(type)){
                if (pr.getMinPrice() < currMinPrice){
                    cheapestProduct = pr;
                }
            }
        }
        return cheapestProduct;
    }

    private static Product[] sortProductsByType(String type){
        Product[] result = new Product[offeredProducts.length];
        int counter = 0;
        for (Product pr: offeredProducts){
            if (pr.getType().equals(type)){
                result[counter++] = pr;
            }
        }
        return result;
    }

    private static Product[] sortProductsByBrand(String brand){
        Product[] result = new Product[offeredProducts.length];
        int counter = 0;
        for (Product pr: offeredProducts){
            if (pr.getType().equals(brand)){
                result[counter++] = pr;
            }
        }
        return result;
    }

    private static Product[] sortProductsByMinPrice(double minPrice){
        Product[] result = new Product[offeredProducts.length];
        int counter = 0;
        for (Product pr: offeredProducts){
            if (pr.getMinPrice() == minPrice){
                result[counter++] = pr;
            }
        }
        return result;
    }
}
