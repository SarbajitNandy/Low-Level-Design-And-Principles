package com.lld.solid_principles.open_close_principle;

/**
 * a class should be open for extension but closed for any modification
 * We would be taking an example of employee bonus calculation.
 * There will be multiple employee types or categories like permanent or Part-time, or managers and developers.
 */

abstract class Employee2 {
    String name;
    double salary;

    public Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public abstract double calculateBonus();
}

class PermanentEmployee extends Employee2 {

    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return this.salary * 0.1 ;
    }
}
class PartTimeEmployee extends Employee2 {

    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return this.salary * 0.05 ;
    }
}

/**
 * Now the Employee class is open for extension and closed for modification
 * to create any other type of employee, just a sub-class out of the Employee class and have it's own bonus calculation logic
 * and only do testing on the new class.
 */

public class GoodExample {
    public static void main(String[] args) {
        Employee2 emp1 = new PermanentEmployee("Sarbajit",10000);
        Employee2 emp2 = new PartTimeEmployee("Shuvankar",10000);

        System.out.println(emp1.calculateBonus());
        System.out.println(emp2.calculateBonus());
    }
}
