// Program demonstrating the 'final' keyword on methods and classes
public class Q3_TamperProofDiscount {
    public static void main(String[] args) {
        SeasonalPricing sp = new SeasonalPricing();

        System.out.printf("Base discount: %.1f%%%n", sp.calculateBaseDiscount());
        System.out.printf("Promo discount: %.1f%%%n", sp.calculatePromoDiscount());
    }
}

class PricingRule {

    // final method — cannot be overridden by any subclass, guaranteeing this
    // core business rule never changes no matter who extends the class
    final double calculateBaseDiscount() {
        return 5.0; // fixed 5% discount
    }

    // normal method — free to be overridden by subclasses
    double calculatePromoDiscount() {
        return 0.0; // no promo by default
    }
}

// Declaring this class final prevents anyone from extending it further —
// useful when a class represents a finished, specific promotional rule that
// should not be specialised any more. Attempting:
//   class SuperSeasonalPricing extends SeasonalPricing { }
// would fail with: error: cannot inherit from final SeasonalPricing
final class SeasonalPricing extends PricingRule {

    @Override
    double calculatePromoDiscount() {
        return 10.0; // seasonal promo adds 10%
    }

    // Attempting to override the final method below would NOT compile:
    // @Override
    // double calculateBaseDiscount() { return 8.0; }
    // error: calculateBaseDiscount() in SeasonalPricing cannot override
    //        calculateBaseDiscount() in PricingRule — overridden method is final
}
