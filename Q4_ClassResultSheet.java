// Program to compute class statistics (highest, lowest, average) from an array of marks
public class Q4_ClassResultSheet {
    public static void main(String[] args) {

        // Marks of 6 students out of 100
        int[] marks = {78, 92, 55, 88, 67, 74};

        int highest = marks[0];
        int lowest = marks[0];
        int sum = 0;

        // Traverse the array once to find highest, lowest and the sum
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > highest) highest = marks[i];
            if (marks[i] < lowest) lowest = marks[i];
            sum += marks[i];
        }

        double average = (double) sum / marks.length;

        // Count students scoring above average
        int aboveAverage = 0;
        for (int mark : marks) {
            if (mark > average) aboveAverage++;
        }

        System.out.println("Highest Mark: " + highest);
        System.out.println("Lowest Mark: " + lowest);
        System.out.printf("Average Mark: %.2f%n", average);
        System.out.println("Students above average: " + aboveAverage);

        /*
         * Deliberate bug — accessing one index beyond the array's length:
         *
         *   System.out.println(marks[marks.length]); // valid indices are 0..5
         *
         * This throws:
         *   Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
         *   Index 6 out of bounds for length 6
         *
         * Fix: the last valid index is (marks.length - 1), so use
         *   System.out.println(marks[marks.length - 1]);
         */
    }
}
