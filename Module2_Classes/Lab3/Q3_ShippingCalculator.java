// Program demonstrating method overloading (compile-time polymorphism)
public class Q3_ShippingCalculator {
    public static void main(String[] args) {
        ShippingCalculator calc = new ShippingCalculator();

        System.out.printf("Cost (weight only): Rs.%.2f%n", calc.calculateCost(5));
        System.out.printf("Cost (weight+distance): Rs.%.2f%n", calc.calculateCost(5, 100));
        System.out.printf("Cost (weight+distance+express): Rs.%.2f%n", calc.calculateCost(5, 100, true));
    }
}

class ShippingCalculator {

    // Version 1: only weight known — flat base rate per kg
    double calculateCost(double weight) {
        double baseRatePerKg = 20;
        return weight * baseRatePerKg;
    }

    // Version 2: weight + distance known — adds a distance-based charge
    double calculateCost(double weight, double distance) {
        double baseRatePerKg = 20;
        double ratePerKm = 2;
        return (weight * baseRatePerKg) + (distance * ratePerKm);
    }

    // Version 3: weight + distance + express flag — adds a surcharge if express
    double calculateCost(double weight, double distance, boolean isExpress) {
        double cost = calculateCost(weight, distance);
        if (isExpress) {
            cost *= 1.5; // 50% express surcharge
        }
        return cost;
    }

    // Java decides which overloaded method to call at COMPILE TIME, purely by
    // matching the number and types of arguments in the call against each
    // method's signature. This is called static/compile-time polymorphism —
    // no object state or runtime information is needed to make the choice.
}
