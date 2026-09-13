import java.io.BufferedReader;  // efficiently reads text lines from a file
import java.io.BufferedWriter;  // efficiently writes text lines to a file
import java.io.FileReader;      // low-level reader for the input side
import java.io.FileWriter;      // low-level writer for the output side, in append mode
import java.io.IOException;     // checked exception thrown by file operations
import java.util.Scanner;       // to read feedback comments typed by the user

// Program to save student feedback to a file and later display everything saved
public class Q8_StudentFeedbackLogger {
    public static void main(String[] args) {
        writeFeedback();
        System.out.println();
        readFeedback();
    }

    // Part 1: repeatedly ask for feedback and append each line to feedback.txt
    static void writeFeedback() {
        Scanner sc = new Scanner(System.in);

        // true = append mode, so previous comments are never overwritten
        // try-with-resources automatically closes the writer, even on error
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {

            while (true) {
                System.out.print("Enter feedback (or 'exit' to stop): ");
                String comment = sc.nextLine();

                if (comment.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(comment);
                writer.newLine(); // moves to the next line for the following comment
            }

        } catch (IOException e) {
            System.out.println("Could not write to feedback.txt: " + e.getMessage());
        }
    }

    // Part 2: read feedback.txt and print every stored comment, numbered
    static void readFeedback() {
        System.out.println("All recorded feedback:");

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {

            String line;
            int number = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(number + ". " + line);
                number++;
            }

        } catch (IOException e) {
            System.out.println("Could not read feedback.txt: " + e.getMessage());
        }
    }
}

/*
 * Run the program twice to confirm persistence:
 *   1st run: add comments "Great session" and "Loved the examples"
 *   2nd run: add "More practice needed" -> feedback.txt should then show all
 *            THREE comments, numbered 1-3, proving new comments are appended,
 *            not overwriting what was already saved.
 */
