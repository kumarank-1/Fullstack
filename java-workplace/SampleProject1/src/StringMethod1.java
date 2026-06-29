import java.util.Scanner;

public class StringMethod1 {
	    public static void main(String[] args) {
	        String email = "john@example.com";
	        String password = "John@123";

	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter email: ");
	        String userEmail = scanner.nextLine();

	        System.out.print("Enter password: ");
	        String userPassword = scanner.nextLine();

	        // Correct string comparison
	        if (email.equalsIgnoreCase(userEmail) && password.equals(userPassword)) {
	            System.out.println("Email and password matched. Please enter home.");
	        } else {
	            System.out.println("Please try again.");
	        }

	        // Interned string vs object string comparison demo
	        String myEmail = new String("john@example.com");
	        String yourEmail = "john@example.com";

	        System.out.println("email == myEmail ? " + (email == myEmail));     // false
	        System.out.println("email == yourEmail ? " + (email == yourEmail)); // true (interned)
	        System.out.println("email.equals(myEmail) ? " + email.equals(myEmail)); // true

	        // compareToIgnoreCase example
	        int cmp = email.compareToIgnoreCase(userEmail);
	        System.out.println("compareToIgnoreCase result: " + cmp + " (0 means equal ignoring case)");

	        scanner.close();
	    }
}
