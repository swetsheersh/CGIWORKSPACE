package lab3_4;
import java.util.Arrays;

public class ProductNamesSorter {
    public static void main(String[] args) {
        // Sample product names
        String[] productNames = {
            "Keyboard",
            "Monitor",
            "Mouse",
            "Laptop",
            "Headphones"
        };

        System.out.println("Original product names:");
        printProductNames(productNames);

        // Sorting the product names
        Arrays.sort(productNames);

        System.out.println("\nSorted product names:");
        printProductNames(productNames);
    }

    public static void printProductNames(String[] productNames) {
        for (String name : productNames) {
            System.out.println(name);
        }
    }
}
