// Program demonstrating access modifiers: public, private, protected
public class Q7_EmployeeRecord {
    public static void main(String[] args) {
        EmployeeRecord emp = new EmployeeRecord("Suresh Kumar", 45000, "Engineering");

        // public field — directly accessible from anywhere
        System.out.println("Name: " + emp.name);

        // private field — direct access from outside the class FAILS TO COMPILE.
        // Uncommenting the next line gives:
        //   error: salary has private access in EmployeeRecord
        // System.out.println(emp.salary);
        // Reason: 'private' restricts access to within the EmployeeRecord class only,
        // enforcing encapsulation so salary can only change through validated code.

        // protected field — accessible here because this demo class is in the
        // same package as EmployeeRecord (protected allows same-package + subclass access)
        System.out.println("Department: " + emp.department);

        // Safe, validated update through the public setter
        emp.setSalary(50000);
        System.out.println("Salary after valid update: " + emp.getSalary());

        // Attempting an invalid update — the setter rejects it
        emp.setSalary(-1000);
        System.out.println("Salary after rejected update: " + emp.getSalary());
    }
}

class EmployeeRecord {
    public String name;
    private double salary;
    protected String department;

    public EmployeeRecord(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Error: salary cannot be negative. Update ignored.");
            return; // reject the update, keep the existing value
        }
        this.salary = salary;
    }
}
