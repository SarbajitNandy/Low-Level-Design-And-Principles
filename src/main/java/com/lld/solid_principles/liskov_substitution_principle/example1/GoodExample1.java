//package com.lld.solid_principles.liskov_substitution_principle.example1;
//
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
//
//
///**
// * If a discount is applicable on some items lets say beverage items , then we can create a subclass for Beverage
// * and do the discount calculation there
// */
//class BeverageItem extends MenuItem {
//    public BeverageItem(String name, Double price) {
//        super(name, price);
//    }
//
//    public Double getPrice() {
//        return price - (price * 0.1);
//    }
//}
//
//public class GoodExample1 {
//    public static void main(String[] args) {
//        MenuItem m1 = new MenuItem("Chicken", 100d);
//
//        System.out.println(m1.getPrice());
//
//        MenuItem m2 = new BeverageItem("mocktail", 20d);
//
//        System.out.println(m2.getPrice());
//    }
//}
