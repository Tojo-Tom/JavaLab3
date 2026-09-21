// Program demonstrating static fields/methods and final constants
public class Q8_TicketBooking {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("Anand");
        Ticket t2 = new Ticket("Bhavya");
        Ticket t3 = new Ticket("Chitra");

        // Static method called without needing any object reference
        Ticket.printTotalTicketsSold();

        // Attempting to modify a static final constant — this will NOT compile.
        // Ticket.BASE_FARE = 100;
        // error: cannot assign a value to final variable BASE_FARE
        // Reason: 'final' means the value is fixed once assigned and can never
        // be reassigned, which is exactly what a fixed base fare requires.
    }
}

class Ticket {
    String passengerName;               // instance field — unique to each Ticket object
    static int ticketCount = 0;         // static field — shared across ALL Ticket objects
    static final double BASE_FARE = 50; // static final constant — fixed, same for every ticket

    public Ticket(String passengerName) {
        this.passengerName = passengerName;
        ticketCount++; // increments the single shared counter every time a Ticket is made
        System.out.println("Ticket booked for " + passengerName
                + " (Total tickets so far: " + ticketCount + ")");
    }

    static void printTotalTicketsSold() {
        System.out.println("Total tickets sold: " + ticketCount);
    }
}
