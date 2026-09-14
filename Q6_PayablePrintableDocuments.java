// Program demonstrating interfaces and implementing multiple interfaces
public class Q6_PayablePrintableDocuments {
    public static void main(String[] args) {
        Invoice inv = new Invoice("INV-2001", 4500.00);

        inv.makePayment(4500.00);
        inv.printDocument();

        // Assigning the Invoice object to a Payable reference and calling
        // through it — only makePayment() is visible through this reference,
        // even though the underlying object also implements Printable.
        Payable payableRef = inv;
        payableRef.makePayment(100.00);

        // One advantage of two separate interfaces instead of one abstract
        // class with both methods: a class can implement BOTH Payable and
        // Printable independently (Java allows multiple interface
        // implementation but only single class inheritance). A Receipt class,
        // for example, could implement only Printable without being forced
        // to also carry payment behaviour it doesn't need.
    }
}

interface Payable {
    void makePayment(double amount);
}

interface Printable {
    void printDocument();
}

class Invoice implements Payable, Printable {
    String invoiceId;
    double amountDue;

    public Invoice(String invoiceId, double amountDue) {
        this.invoiceId = invoiceId;
        this.amountDue = amountDue;
    }

    @Override
    public void makePayment(double amount) {
        amountDue -= amount;
        System.out.println("Paid Rs." + amount + " towards " + invoiceId
                + ". Remaining due: Rs." + amountDue);
    }

    @Override
    public void printDocument() {
        System.out.println("Printing Invoice " + invoiceId + " (Amount due: Rs." + amountDue + ")");
    }
}
