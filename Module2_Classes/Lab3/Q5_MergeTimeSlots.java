// Program demonstrating a method that constructs and returns a new object
public class Q5_MergeTimeSlots {
    public static void main(String[] args) {
        TimeSlot meeting1 = new TimeSlot(9, 11);   // 9 AM - 11 AM
        TimeSlot meeting2 = new TimeSlot(10, 13);  // 10 AM - 1 PM (overlaps with meeting1)

        TimeSlot merged = mergeSlots(meeting1, meeting2);
        System.out.println("Merged slot: " + merged.startHour + ":00 - " + merged.endHour + ":00");

        // Non-overlapping example
        TimeSlot meeting3 = new TimeSlot(14, 15);
        TimeSlot meeting4 = new TimeSlot(16, 17);
        TimeSlot merged2 = mergeSlots(meeting3, meeting4);
        System.out.println("Merged slot: " + merged2.startHour + ":00 - " + merged2.endHour + ":00");
    }

    static TimeSlot mergeSlots(TimeSlot a, TimeSlot b) {
        // Overlap check: slots overlap if one starts before the other ends
        boolean overlapping = a.startHour < b.endHour && b.startHour < a.endHour;

        if (!overlapping) {
            System.out.println("Warning: slots " + a.startHour + "-" + a.endHour
                    + " and " + b.startHour + "-" + b.endHour
                    + " do not overlap. Returning an envelope slot anyway.");
        }

        int mergedStart = Math.min(a.startHour, b.startHour);
        int mergedEnd = Math.max(a.endHour, b.endHour);

        // A brand-new object is created inside the method and returned to the caller
        return new TimeSlot(mergedStart, mergedEnd);
    }
}

class TimeSlot {
    int startHour;
    int endHour;

    public TimeSlot(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }
}
