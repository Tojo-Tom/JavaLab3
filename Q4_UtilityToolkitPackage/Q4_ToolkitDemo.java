// This class lives in the DEFAULT package and uses the custom toolkit.utils package

// import toolkit.utils.MathHelper;   // single-class import — brings in ONLY MathHelper
import toolkit.utils.*;               // whole-package import — brings in every public
                                       // class in toolkit.utils (MathHelper AND StringHelper)

public class Q4_ToolkitDemo {
    public static void main(String[] args) {
        int squared = MathHelper.square(7);
        String reversed = StringHelper.reverse("recursion");

        System.out.println("Square of 7: " + squared);
        System.out.println("Reversed 'recursion': " + reversed);
    }
}

/*
 * Folder structure matching the package declaration "package toolkit.utils;":
 *
 *   Q4_UtilityToolkitPackage/
 *     Q4_ToolkitDemo.java          (default package)
 *     toolkit/
 *       utils/
 *         MathHelper.java          (package toolkit.utils;)
 *         StringHelper.java        (package toolkit.utils;)
 *
 * To compile and run:
 *   javac toolkit/utils/MathHelper.java toolkit/utils/StringHelper.java Q4_ToolkitDemo.java
 *   java Q4_ToolkitDemo
 */
