// Program demonstrating constructor overloading and the 'this' keyword
public class Q1_MembershipCard {

    public static void main(String[] args) {
        // Object created using the default (no-argument) constructor
        MembershipCard guestCard = new MembershipCard();

        // Object created using the parameterized constructor
        MembershipCard memberCard = new MembershipCard("Priya Sharma", 101, 3);

        guestCard.printDetails();
        memberCard.printDetails();
    }
}

class MembershipCard {
    String memberName;
    int memberId;
    int validityYears;

    // Default constructor — sets sensible fallback values
    public MembershipCard() {
        memberName = "Guest";
        memberId = 0;
        validityYears = 1;
    }

    // Parameterized constructor — 'this' resolves the name clash between
    // the parameters and the fields that share the same name
    public MembershipCard(String memberName, int memberId, int validityYears) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.validityYears = validityYears;
    }

    void printDetails() {
        System.out.println("Name: " + memberName + ", ID: " + memberId
                + ", Valid for: " + validityYears + " year(s)");
    }
}
