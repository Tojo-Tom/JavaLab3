import java.util.Scanner; // to read the product index the user wants to search

// Program to alert low-stock products and safely search for a product's stock level
public class Q8_WarehouseInventoryAlert {
    public static void main(String[] args) {

        // Stock quantities of 8 products
        int[] stock = {5, 20, 8, 15, 2, 30, 9, 40};

        // Loop through the array and print REORDER / OK for each product
        System.out.println("Stock Alerts:");
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] < 10) {
                System.out.println("Product " + i + ": REORDER (stock = " + stock[i] + ")");
            } else {
                System.out.println("Product " + i + ": OK (stock = " + stock[i] + ")");
            }
        }

        // Search feature with exception handling for invalid indices
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a product index to check its stock: ");
        int index = sc.nextInt();

        try {
            System.out.println("Stock at index " + index + " = " + stock[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Triggered when index is negative or >= stock.length
            System.out.println("Invalid product index. Please enter a value between 0 and "
                    + (stock.length - 1) + ".");
        }

        // Total stock across all products
        int totalStock = 0;
        for (int qty : stock) {
            totalStock += qty;
        }
        System.out.println("Total stock across all products: " + totalStock);

        sc.close();
    }
}
