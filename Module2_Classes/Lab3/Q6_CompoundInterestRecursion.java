import java.util.Scanner; // to read principal, rate and years from the user

// Program demonstrating recursion: compound interest and factorial
public class Q6_CompoundInterestRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal: ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double finalAmount = calculateAmount(principal, rate, years);
        System.out.printf("Final amount after %d year(s): Rs.%.2f%n", years, finalAmount);

        System.out.println("Factorial of 6 = " + factorial(6));

        sc.close();
    }

    // Recursive method: applies one year of interest per call
    static double calculateAmount(double principal, double rate, int years) {
        if (years == 0) {         // base case — no more years to grow
            return principal;
        }
        // recursive case: grow the principal by one year, then recurse for the rest
        return calculateAmount(principal * (1 + rate / 100), rate, years - 1);
    }

    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive case
    }

    /*
     * Trace of calculateAmount(P, r, 3):
     *
     *   calculateAmount(P, r, 3)
     *     -> calculateAmount(P*(1+r/100), r, 2)
     *          -> calculateAmount(P*(1+r/100)^2, r, 1)
     *               -> calculateAmount(P*(1+r/100)^3, r, 0)
     *                    -> returns P*(1+r/100)^3   [base case reached]
     *               <- returns P*(1+r/100)^3
     *          <- returns P*(1+r/100)^3
     *     <- returns P*(1+r/100)^3
     *
     * Each call is pushed onto the call stack until years == 0, then the
     * stack unwinds, passing the final computed value back up to main().
     */
}
