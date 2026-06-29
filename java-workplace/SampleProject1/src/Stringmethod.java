
public class Stringmethod {
	    public static void main(String[] args) {
	        String names = "John, Jenny, Jim, Jack, Joe";

	        // 1) length
	        int length = names.length();
	        System.out.println("Names are " + length + " characters wide.");

	        // 2) charAt + indexOf + lastIndexOf
	        char ch = names.charAt(0);
	        System.out.println("Character at index 0 is " + ch);

	        ch = names.charAt(length - 1);
	        System.out.println("Character at length - 1 is " + ch);

	        int idx = names.indexOf('o');
	        System.out.println("Index of 'o' is " + idx);

	        idx = names.lastIndexOf('o');
	        System.out.println("Last index of 'o' is " + idx);

	        idx = names.indexOf("Jim");
	        System.out.println("Index of \"Jim\" is " + idx);

	        // 3) toUpperCase and immutability
	        System.out.println("Original names: " + names);
	        String uppercaseNames = names.toUpperCase();
	        System.out.println("Uppercase names: " + uppercaseNames);

	        String replacedNames = names.replace('J', 'K');
	        System.out.println("Replaced names: " + replacedNames);
	        System.out.println("Original still unchanged: " + names);

	        // 4) substring + split
	        String sub1 = names.substring(idx); // from Jim till end
	        System.out.println("Substring from Jim: " + sub1);

	        String sub2 = names.substring(idx, idx + 3); // Jim
	        System.out.println("Substring exact Jim: " + sub2);

	        String[] results = names.split(",");
	        System.out.println("\nSplit by comma:");
	        for (String s : results) {
	            System.out.println("[" + s + "]");
	        }

	        System.out.println("\nSplit + trim:");
	        for (String s : results) {
	            System.out.println("[" + s.trim() + "]");
	        }

	        String[] results2 = names.split(", ");
	        System.out.println("\nSplit by comma+space:");
	        for (String s : results2) {
	            System.out.println("[" + s + "]");
	        }

	        // 5/6) concat and email validation with contains + endsWith
	        String firstName = "John";
	        String lastName = "Watson";
	        String fullName = firstName.concat(" ").concat(lastName);
	        System.out.println("\nFull name: " + fullName);

	        String email = "john@example.com";
	        if (email.isEmpty()) {
	            System.out.println("Email cannot be empty");
	        } else if (email.contains("@") && email.endsWith(".com")) {
	            System.out.println("Email is valid, proceed with registration");
	        } else {
	            System.out.println("Invalid email: " + email);
	        }

	        // 7) startsWith / contains search example
	        String[] myPhoneNumbers = {
	            "+919812345678", "+12025550123", "+447700900123", "+919900112233", "+33123456789"
	        };

	        String searchKeyword = "+91";
	        System.out.println("\nPhone numbers starting with " + searchKeyword + ":");
	        for (String number : myPhoneNumbers) {
	            if (number.startsWith(searchKeyword)) {
	                System.out.println(number);
	            }
	        }

	        String anyKeyword = "12";
	        System.out.println("\nPhone numbers containing " + anyKeyword + ":");
	        for (String number : myPhoneNumbers) {
	            if (number.contains(anyKeyword)) {
	                System.out.println(number);
	            }
	        }

	        // 8) count occurrences of a character
	        char[] charArray = names.toCharArray();
	        int count = 0;
	        for (char c : charArray) {
	            if (c == 'o') count++;
	        }
	        System.out.println("\n'o' appears " + count + " times.");
	    }
}
