import java.util.Scanner; // used to read the customer's input values

// Program to calculate an electricity bill and flag risky customers using operators
public class Q5_ElectricityBillOperators {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int unitsConsumed = sc.nextInt();

        System.out.print("Enter previous due amount: ");
        double previousDueAmount = sc.nextDouble();

        double bill;
        // Arithmetic operators: first 100 units at Rs.3, remaining at Rs.5
        if (unitsConsumed <= 100) {
            bill = unitsConsumed * 3;
        } else {
            bill = (100 * 3) + ((unitsConsumed - 100) * 5);
        }

        // Relational + logical operators (&&) to flag risky customers
        boolean flagged = (unitsConsumed > 300) && (previousDueAmount > 0);

        System.out.printf("Bill Amount: Rs.%.2f%n", bill);
        System.out.println("Flagged as risky customer: " + flagged);

        // Demonstrating pre-increment vs post-increment
        int count = 5;
        System.out.println("count++ (post-increment) prints old value first: " + count++);
        // count is now 6 because it was incremented right after being used above
        System.out.println("++count (pre-increment) prints new value first: " + ++count);
        // count is now 7 — it was incremented BEFORE being printed this time

        sc.close();
    }
}
