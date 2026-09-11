// Program to print a formatted visitor pass for a corporate office
public class Q1_VisitorPassGenerator {
    public static void main(String[] args) {

        // Name of the visitor entering the building
        String visitorName = "Ananya Rao";

        // Date on which the visit is happening
        String visitDate = "21-09-2026";

        // Name of the employee the visitor has come to meet
        String hostEmployee = "Karthik Subramaniam";

        // Unique numeric identifier printed on the pass
        int passNumber = 1024;

        // \n adds a blank line, \t aligns the label and value in columns
        System.out.println("=========== VISITOR PASS ===========\n");
        System.out.printf("Pass No.\t: %d%n", passNumber);
        System.out.printf("Visitor\t\t: %s%n", visitorName);
        System.out.printf("Date\t\t: %s%n", visitDate);
        System.out.printf("Host\t\t: %s%n", hostEmployee);
        System.out.println("\n=====================================");

        /*
         * Deliberate error (for the exercise) — uncomment the line below
         * and remove the semicolon to see the compiler error:
         *
         *   int passNumber = 1024   // missing semicolon
         *
         * javac reports:
         *   error: ';' expected
         *   int passNumber = 1024
         *                        ^
         * Fix: simply add the missing ";" at the end of the statement.
         * This is a COMPILE-TIME error because the compiler cannot even
         * translate the code into bytecode until the syntax is correct.
         */
    }
}
