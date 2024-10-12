package com.lld.solid_principles.open_close_principle;

/**
 * a class should be open for extension but closed for any modification
 * We would be taking an example of employee bonus calculation.
 * There will be multiple employee types or categories like permanent or Part-time, or managers and developers.
 */

class Employee {
    String name;
    double salary;
    String employeeType;

    public Employee(String name, double salary, String employeeType) {
        this.name = name;
        this.salary = salary;
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", employeeType='" + employeeType + '\'' +
                '}';
    }

    public double calculateBonuse() {
        // there can be many more employee type in the future, but including them would require a change in the whole code.
        // Thus, this is open for modification , violating the OCP
        switch (this.employeeType) {
            case "Permanent":
                return this.salary * 0.1;
            case "Part-time":
                return this.salary * 0.05;
            default: return this.salary;
        }
    }
}

public class BadExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sarbajit",10000,"Permanent");
        Employee emp2 = new Employee("Shuvankar",10000,"Part-time");

        System.out.println(emp1.calculateBonuse());
        System.out.println(emp2.calculateBonuse());
    }
}
