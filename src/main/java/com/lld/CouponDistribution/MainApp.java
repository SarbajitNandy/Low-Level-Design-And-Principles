package com.lld.CouponDistribution;

public class MainApp {
    public static void main(String[] args) {
        User user1 = new User("1","Sarbajit");
        User user2 = new User("2","Sambhit");
        User user3 = new User("3","Subha");

        EcomApp app = new EcomApp();

        app.visited(user1);
        app.visited(user2);
        app.visited(user2);
        app.visited(user3);

        System.out.println(app.issueCoupon());
    }
}
