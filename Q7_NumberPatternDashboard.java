import java.util.Scanner; // to read numbers entered by the user

// Program that prints a number pyramid and reports statistics of user-entered numbers
public class Q7_NumberPatternDashboard {
    public static void main(String[] args) {

        // Part 1: Right-angled number pyramid of height 5, using nested for loops
        System.out.println("Number Pyramid:");
        for (int i = 1; i <= 5; i++) {          // outer loop controls the row
            for (int j = 1; j <= i; j++) {      // inner loop prints 1..i on that row
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Part 2: Sentinel-controlled input using a while loop
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.println("\nEnter numbers (-1 to stop):");
        while (true) {
            int num = sc.nextInt();

            if (num == -1) {
                break; // sentinel value seen — exit the loop immediately
            }

            if (num < 0) {
                continue; // skip negative numbers (other than the sentinel), don't count them
            }

            sum += num;
            count++;
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Sum: " + sum);
            System.out.println("Count of valid numbers: " + count);
            System.out.printf("Average: %.2f%n", average);
        } else {
            System.out.println("No valid numbers were entered.");
        }

        sc.close();
    }
}
