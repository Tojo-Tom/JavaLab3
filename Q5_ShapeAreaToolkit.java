// Program demonstrating abstract classes and polymorphic arrays
public class Q5_ShapeAreaToolkit {
    public static void main(String[] args) {

        // Polymorphic array: holds different subtypes of the abstract type Shape
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);

        for (Shape s : shapes) {
            s.describe();
            System.out.printf("Area: %.2f%n%n", s.getArea());
        }

        // Attempting to instantiate the abstract class directly is not allowed:
        // Shape generic = new Shape();
        // error: Shape is abstract; cannot be instantiated
        // Reason: an abstract class may have incomplete behaviour (getArea() has
        // no formula of its own), so Java forbids creating objects of it directly —
        // only concrete subclasses that implement all abstract methods can be instantiated.
    }
}

abstract class Shape {
    abstract double getArea(); // no implementation — each subclass must define its own

    void describe() { // concrete method shared by every shape
        System.out.println("This is a shape. Every shape can report its area.");
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }
}
