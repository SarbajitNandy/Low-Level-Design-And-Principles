package com.lld.solid_principles.single_responsiblity;


/**
 * A class should have only one reason to change.
 * Example - lets prepare a real life scenario of invoicing. A marker in a salable item and
 * we will prepare an invoice for it.
 */

class Marker {
    String brand;
    String color;
    double price;

    public Marker(double price, String color, String brand) {
        this.price = price;
        this.color = color;
        this.brand = brand;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public double calculateTotal() {
        return marker.price*quantity;
    }

    public void printInvoice() {  // Printing process can be altered based on hardware availability
        //
    }

    public void saveToDB() {  // Can be changed in case a new DB layer is introduced.
        //
    }
}
