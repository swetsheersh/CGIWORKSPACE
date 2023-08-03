package carwala_cgi;

import java.util.*;

class CarWala {
    private Map<String, Double> carDetails;

    public CarWala() {
        carDetails = new HashMap<>();
        initializeCarDetails();
    }

    private void initializeCarDetails() {
        carDetails.put("Maruti Swift", 600000.0);
        carDetails.put("Honda City", 900000.0);
        carDetails.put("Toyota Corolla", 1200000.0);
        carDetails.put("Hyundai i20", 700000.0);
        carDetails.put("Ford Mustang", 3500000.0);
        carDetails.put("Volkswagen Polo", 800000.0);
        carDetails.put("Nissan Altima", 1100000.0);
        carDetails.put("BMW X5", 5500000.0);
        carDetails.put("Mercedes C-Class", 5000000.0);
        carDetails.put("Audi A4", 5200000.0);
    }

    public void listNames(char startingChar) {
        boolean found = false;
        for (String carName : carDetails.keySet()) {
            if (carName.charAt(0) == startingChar) {
                System.out.println(carName);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cars found starting with '" + startingChar + "'.");
        }
    }

    public void listPrice(double minPrice) {
        boolean found = false;
        for (Map.Entry<String, Double> entry : carDetails.entrySet()) {
            if (entry.getValue() > minPrice) {
                System.out.println(entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cars found above " + minPrice + " price.");
        }
    }

    public void applyDiscount() {
        for (Map.Entry<String, Double> entry : carDetails.entrySet()) {
            String carName = entry.getKey();
            double carPrice = entry.getValue();

            if (carPrice > 500000) {
                double discountedPrice = carPrice * 0.8;
                System.out.println("Car: " + carName + ", Discounted Price: " + discountedPrice);
            } else {
                System.out.println("Car: " + carName + ", Price: " + carPrice);
            }
        }
    }

    public static void main(String[] args) {
        CarWala carWala = new CarWala();

        // Example usage
        carWala.listNames('M');
        carWala.listPrice(1000000);
        carWala.applyDiscount();
    }
}