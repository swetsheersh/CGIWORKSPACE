public class PropertyRegistration {
    // Properties
    private String typeOfProperty;
    private int area;
    private String location;
    private double expectedPrice;
    private String sellerName;

    // Constructor
    public PropertyRegistration(String typeOfProperty, int area, String location, double expectedPrice, String sellerName) {
        this.typeOfProperty = typeOfProperty;
        this.area = area;
        this.location = location;
        this.expectedPrice = expectedPrice;
        this.sellerName = sellerName;
    }

    // Method to validate data and register the property
    public boolean registerProperty() {
        if (!isValidTypeOfProperty() || !isValidArea() || !isValidLocation() || !isValidExpectedPrice() || !isValidSellerName()) {
            System.out.println("Error: Invalid data for property registration.");
            return false;
        }

        // Code for property registration in the database or any other relevant action

        System.out.println("Property registered successfully!");
        return true;
    }

    // Helper methods for data validation
    private boolean isValidTypeOfProperty() {
        return typeOfProperty != null && (typeOfProperty.equals("estate") || typeOfProperty.equals("house") || typeOfProperty.equals("flat") || typeOfProperty.equals("office"));
    }

    private boolean isValidArea() {
        return area >= 0 && area < 1000000; // Up to 6-digit non-negative value
    }

    private boolean isValidLocation() {
        return location != null && !location.isEmpty();
    }

    private boolean isValidExpectedPrice() {
        return expectedPrice >= 0;
    }

    private boolean isValidSellerName() {
        return sellerName != null && !sellerName.isEmpty();
    }

    // Test case
    public static void main(String[] args) {
        // Valid property data
        PropertyRegistration validProperty = new PropertyRegistration("house", 1500, "Example Street, City", 250000.0, "John Doe");
        boolean isValidRegistration = validProperty.registerProperty();
        System.out.println("Is valid property registration? " + isValidRegistration);

        // Invalid property data (area is negative)
        PropertyRegistration invalidProperty = new PropertyRegistration("estate", -500, "Invalid Location", 1000000.0, "Invalid Seller");
        isValidRegistration = invalidProperty.registerProperty();
        System.out.println("Is valid property registration? " + isValidRegistration);
    }
}
