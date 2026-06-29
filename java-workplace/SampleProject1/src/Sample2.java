
public class Sample2 {
	public static void main(String[] args) {
        int a = 20, b = 10;

        // Arithmetic Operators
        System.out.println("=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Relational Operators
        System.out.println("\n=== Relational Operators ===");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        // Logical Operators
        boolean x = true, y = false;
        System.out.println("\n=== Logical Operators ===");
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x     : " + (!x));

        // Assignment Operators
        int n = 5;
        System.out.println("\n=== Assignment Operators ===");
        System.out.println("Initial n = " + n);
        n += 3;
        System.out.println("n += 3 -> " + n);
        n -= 2;
        System.out.println("n -= 2 -> " + n);
        n *= 4;
        System.out.println("n *= 4 -> " + n);
        n /= 3;
        System.out.println("n /= 3 -> " + n);
        n %= 3;
        System.out.println("n %= 3 -> " + n);

        // Unary Operators
        int p = 10;
        System.out.println("\n=== Unary Operators ===");
        System.out.println("p = " + p);
        System.out.println("++p = " + (++p));
        System.out.println("p++ = " + (p++));
        System.out.println("After p++ , p = " + p);
        System.out.println("--p = " + (--p));
        System.out.println("p-- = " + (p--));
        System.out.println("After p-- , p = " + p);
    }
}
