package toolkit.utils;

// Reusable string helper — grouped with MathHelper under the same package
public class StringHelper {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
