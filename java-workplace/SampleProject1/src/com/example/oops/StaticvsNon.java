package com.example.oops;

public class StaticvsNon {
    public static void main(String[] args) {
        Dish dish1 = new Dish();
        Dish dish2 = new Dish("Pizza", 300, 2);
        Dish dish3 = new Dish("Pasta", 250, 1);
        Dish dish4 = dish1;
        
        dish1.incrementQuantity();
        dish1.incrementQuantity();
        dish2.incrementQuantity();
        dish2.incrementQuantity();
        dish2.incrementQuantity();
        dish1.decrementQuantity();

        dish1.showDish();
        dish2.showDish();

        Dish.showNumberOfDishes();
    }
}
