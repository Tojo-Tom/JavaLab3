// Program demonstrating inheritance basics and the 'super' keyword
public class Q1_StaffHierarchy {
    public static void main(String[] args) {
        Manager mgr = new Manager("Deepa Iyer", 501, 8);
        mgr.displayInfo(); // both parent and child logic execute
    }
}

class Staff {
    String name;
    int staffId;

    public Staff(String name, int staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Staff ID: " + staffId);
    }
}

class Manager extends Staff {
    int teamSize;

    public Manager(String name, int staffId, int teamSize) {
        super(name, staffId); // calls Staff's constructor to initialize inherited fields
        this.teamSize = teamSize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();  // reuse the parent's printing logic first
        System.out.println("Manages a team of: " + teamSize);
    }
}
