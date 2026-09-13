// Program demonstrating objects passed as method parameters
public class Q4_CompareRectangles {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(6, 6);

        compareRectangles(r1, r2);

        // Modifying a field of r1 AFTER the method call
        r1.length = 20;
        System.out.println("r1's length changed to: " + r1.length);

        // In Java, object variables hold a REFERENCE (memory address) to the
        // object. When r1 was passed into compareRectangles(), a COPY of that
        // reference was passed — both the original r1 and the method's local
        // parameter pointed to the SAME object in memory. That is why changes
        // made to the object's fields through either variable are visible
        // everywhere. However, Java itself is technically always
        // "pass-by-value": it is the reference VALUE that gets copied, not
        // the object itself — this is often summarised as "pass by reference
        // value" for objects.
    }

    static void compareRectangles(Rectangle r1, Rectangle r2) {
        double area1 = r1.getArea();
        double area2 = r2.getArea();

        if (area1 > area2) {
            System.out.println("Rectangle 1 is larger (" + area1 + " vs " + area2 + ")");
        } else if (area2 > area1) {
            System.out.println("Rectangle 2 is larger (" + area2 + " vs " + area1 + ")");
        } else {
            System.out.println("Both rectangles have equal area (" + area1 + ")");
        }
    }
}

class Rectangle {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }
}
