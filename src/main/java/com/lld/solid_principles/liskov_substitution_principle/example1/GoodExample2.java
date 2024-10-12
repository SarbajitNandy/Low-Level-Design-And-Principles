package com.lld.solid_principles.liskov_substitution_principle.example1;

class MenuItem {
    String name;
    Double price;

    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price - getDiscount();
    }

    public Double getDiscount() {
        return 0d;
    }
}

class BeverageItem extends MenuItem {
    public BeverageItem(String name, Double price) {
        super(name, price);
    }

    @Override
    public Double getPrice() {
        return price - getDiscount();
    }

    @Override
    public Double getDiscount() {
        return price*0.1;
    }
}

public class GoodExample2 {
    public static void main(String[] args) {
        MenuItem m1 = new MenuItem("Chicken", 100d);

        System.out.println(m1.getPrice());

        MenuItem m2 = new BeverageItem("mocktail", 20d);

        System.out.println(m2.getPrice());
    }
}
