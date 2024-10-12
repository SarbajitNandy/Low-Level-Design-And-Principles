package com.lld.solid_principles.liskov_substitution_principle.example1;

import java.awt.*;

/**
 * If S is a subtype of T, then objects of type T may be replaced with objects of type S
 * Derived types must be completely substitutable for their base types. Follows strong behavioural subtyping
 * Describes how to do inheritance properly
 */

//class MenuItem {
//    String name;
//    Double price;
//
//    public MenuItem(String name, Double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//}


/**
 * If a discount is applicable on some items lets say beverage items , then we can create a subclass for Beverage
 * and do the discount calculation there
 */
//class BeverageItem extends MenuItem {
//    public BeverageItem(String name, Double price) {
//        super(name, price);
//    }
//
//    public Double getPriceWithDiscount() {
//        return price - (price * 0.1);
//    }
//}

/**
 * In the above case, the controller, to the price of an item, needs to call `getPrice` of other items, and `getPriceWithDiscount` for Beverage items
 * this breaks the LSP where any subtype should be able to replace the main class
 */

public class BadExample {
    public static void main(String[] args) {
//        MenuItem m1 = new MenuItem("Chicken", 100d);
//
//        System.out.println(m1.getPrice());
//
//        // Can't use MenuItem here, then `getPriceWithDiscount` won't be accessible
//        BeverageItem m2 = new BeverageItem("mocktail", 20d);
//
//        System.out.println(m2.getPriceWithDiscount());
    }
}