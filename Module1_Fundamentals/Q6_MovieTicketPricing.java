import java.util.Scanner; // to read age and day code from the console

// Program to compute a movie ticket price based on age and day type
public class Q6_MovieTicketPricing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter day code (W = weekday, H = holiday): ");
        char dayCode = sc.next().charAt(0);

        double price;
        String category;

        // Nested if-else ladder applying the pricing rules in order
        if (age < 12) {
            price = 100;
            category = "Child";
        } else if (age >= 60) {
            price = 120;
            category = "Senior Citizen";
        } else {
            category = "Regular";
            // switch statement decides the price based on the day code
            switch (dayCode) {
                case 'W':
                    price = 150;
                    break;
                case 'H':
                    price = 200;
                    break;
                default:
                    price = 150; // fallback, treated as weekday
            }
        }

        System.out.println("Category: " + category);
        System.out.printf("Ticket Price: Rs.%.2f%n", price);

        sc.close();

        /*
         * Test combinations to run (boundary values included):
         *   age=10,  day=W  -> Child, Rs.100
         *   age=12,  day=H  -> Regular, Rs.200   (boundary: exactly 12 is NOT a child)
         *   age=60,  day=W  -> Senior Citizen, Rs.120  (boundary: exactly 60 IS senior)
         *   age=35,  day=H  -> Regular, Rs.200
         */
    }
}
