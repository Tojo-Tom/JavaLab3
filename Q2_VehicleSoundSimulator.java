// Program demonstrating multilevel inheritance and runtime polymorphism
public class Q2_VehicleSoundSimulator {
    public static void main(String[] args) {

        // A Vehicle reference pointing to a Car object
        Vehicle v = new Car();
        v.makeSound();

        // Even though the reference TYPE is Vehicle, the Car version of
        // makeSound() runs. This is called dynamic method dispatch (runtime
        // polymorphism): Java decides WHICH overridden method to run based on
        // the ACTUAL object type at runtime, not the type of the reference
        // variable used to call it.
    }
}

class Vehicle {
    void makeSound() {
        System.out.println("Vehicle: generic movement sound.");
    }
}

class MotorVehicle extends Vehicle {
    @Override
    void makeSound() {
        System.out.println("MotorVehicle: engine roars to life.");
    }
}

class Car extends MotorVehicle {
    @Override
    void makeSound() {
        super.makeSound(); // calls MotorVehicle's version first
        System.out.println("Car: vroom vroom!");
    }
}
