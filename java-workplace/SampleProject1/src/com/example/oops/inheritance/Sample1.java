package com.example.oops.inheritance;

public class Sample1 {
//	 public static void main(String[] args) {
//	        Child child = new Child();
//	        child.wealth = child.wealth - 5000;
//	        child.showDetails();
//	    }
	    public static void main(String[] args) {
	        Shoe s = new Shoe(1, "UltraBoost", "Comfort shoes", 200, "Adidas", new int[]{7,8,9}, new String[]{"Black","White"});
	        Television tv = new Television(2, "Bravia", "4K Smart TV", 800, "Sony", 55, new String[]{"Black"}, "OLED");
	        MobilePhone m = new MobilePhone(3, "Galaxy S", "Flagship phone", 999, "Samsung", 12, 256, "Android");

	        s.showShoe();
	        tv.showTelevision();
	        m.showMobilePhone();
	    }

}
