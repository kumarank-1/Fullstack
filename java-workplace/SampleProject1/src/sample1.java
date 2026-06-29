
public class sample1 {
public static void main(String[] args) {
	byte b = 100;
    short s = 10000;
    int i = 100000;
    long l = 10000000000L;
    float f = 10.5f;
    double d = 20.99;
    char c = 'A';
    boolean flag = true;

    System.out.println("=== Primitive Data Types ===");
    System.out.println("byte value: " + b);
    System.out.println("short value: " + s);
    System.out.println("int value: " + i);
    System.out.println("long value: " + l);
    System.out.println("float value: " + f);
    System.out.println("double value: " + d);
    System.out.println("char value: " + c);
    System.out.println("boolean value: " + flag);

    // Non-Primitive Data Types
    String str = "Hello Java";
    int[] arr = {10, 20, 30, 40, 50};

    System.out.println("\n=== Non-Primitive Data Types ===");
    System.out.println("String value: " + str);
    System.out.print("Array values: ");
    for (int val : arr) {
        System.out.print(val + " ");
    }
    System.out.println();
		
	}
}
