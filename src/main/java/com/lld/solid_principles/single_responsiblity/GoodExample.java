package com.lld.solid_principles.single_responsiblity;

class Invoice2 {
    private Marker marker;
    private int quantity;

    public Invoice2(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return marker.price * quantity;
    }
}


class InvoiceDAO {
    Invoice2 invoice;

    public InvoiceDAO(Invoice2 invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        //
    }
}

class Printer {
    Invoice2 invoice;

    public Printer(Invoice2 invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        //
    }
}

public class GoodExample {
    public static void main(String[] args) {
        Marker marker = new Marker(10, "cisco","Red");

        Invoice2 invoice = new Invoice2(marker, 5);

        new Printer(invoice);
        new InvoiceDAO(invoice);

    }
}