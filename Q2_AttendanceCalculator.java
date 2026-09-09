import java.util.Scanner; // Imports Scanner so we can read keyboard input from the user

// Program to calculate attendance percentage of a student
public class Q2_AttendanceCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total classes held: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter classes attended: ");
        int attendedClasses = sc.nextInt();

        // (a) MISTAKE 1: missing semicolon — try this deliberately:
        //     double percentage = (attendedClasses * 100.0) / totalClasses
        // Result: COMPILE-TIME ERROR -> "error: ';' expected"
        // Fix: add the semicolon back.

        // (b) MISTAKE 2: comparing Strings with == instead of .equals()
        //     String status = "Good";
        //     if (status == "Good") { ... }   // unreliable, compares references
        // Result: LOGICAL ERROR (compiles fine, but may not behave as expected
        // because == checks object reference, not content).
        // Fix: use status.equals("Good") instead.
        String status;

        // (c) MISTAKE 3: integer division truncates the decimal part
        //     double percentageWrong = attendedClasses / totalClasses * 100;
        // Result: LOGICAL ERROR — since both operands are int, the division
        // happens as integer division BEFORE multiplying by 100, so the
        // answer is almost always 0.
        // Fix: cast one operand to double so real division is used:
        double percentage = ((double) attendedClasses / totalClasses) * 100;

        if (percentage >= 75) {
            status = "Good";
        } else {
            status = "Low";
        }

        System.out.printf("Attendance Percentage: %.2f%%%n", percentage);
        System.out.println("Status: " + status);

        sc.close();
    }
}

/*
Summary of the three deliberate mistakes:

 Mistake                        | Type                 | Message / Symptom
---------------------------------------------------------------------------
 Missing semicolon              | Compile-time error   | "';' expected"
 status == "Good"               | Logical error         | Wrong/unreliable result,
                                 | (compiles fine)       | no compiler message
 attendedClasses / totalClasses | Logical error          | Percentage always
 (int / int) without casting    | (compiles fine)        | prints as 0.00%
---------------------------------------------------------------------------
*/
