package com.example.oops;
import java.util.Date;
public class User {
	    String name;
	    String phone;
	    String email;
	    char gender;
	    Date birthDate;
	    String password;

	    // Default constructor
	    public User() {
	        this.name = "NA";
	        this.phone = "NA";
	        this.email = "demo@example.com";
	        this.gender = 'F';
	        this.birthDate = new Date();
	        this.password = "password";
	    }

	    // Parameterized constructor
	    public User(String name, String phone, String email, char gender, Date birthDate, String password) {
	        this.name = name;
	        this.phone = phone;
	        this.email = email;
	        this.gender = gender;
	        this.birthDate = birthDate;
	        this.password = password;
	    }

	    public void setUserData(String name, String phone, String email, char gender, Date birthDate, String password) {
	        this.name = name;
	        this.phone = phone;
	        this.email = email;
	        this.gender = gender;
	        this.birthDate = birthDate;
	        this.password = password;
	    }

	    public void showUserData() {
	        System.out.println("Name      : " + name);
	        System.out.println("Phone     : " + phone);
	        System.out.println("Email     : " + email);
	        System.out.println("Gender    : " + gender);
	        System.out.println("BirthDate : " + birthDate);
	        System.out.println();
	    }
}
