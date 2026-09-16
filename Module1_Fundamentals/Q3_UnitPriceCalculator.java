// Program to calculate the total cost of a grocery item and its price category
public class Q3_UnitPriceCalculator {
    public static void main(String[] args) {

        int grams = 750;              // weight of the item in grams, read as a whole number
        double pricePerKg = 640.0;    // price per kilogram, needs decimal precision

        // Explicit casting: grams (int) is converted to double before dividing by 1000,
        // otherwise integer division would truncate the fractional kilograms.
        double kilograms = (double) grams / 1000;

        double totalCost = kilograms * pricePerKg;

        // char variable holding a single-letter category code
        char category = (totalCost > 500) ? 'A' : 'B';

        System.out.printf("Weight: %d g (%.3f kg)%n", grams, kilograms);
        System.out.printf("Total Cost: Rs.%.2f%n", totalCost);
        System.out.println("Category: " + category);
    }
}
