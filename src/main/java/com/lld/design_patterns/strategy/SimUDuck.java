package com.lld.design_patterns.strategy;


/**
 * The Strategy Pattern defines a set of algorithms encapsulates each one, and make them inter-changeable.
 * Strategy let the algorithm vary independently of clients that Use it
 * NOTE :
 * - Favor composition over Inheritance
 * - Program to an abstraction/interface, not to an implementation
 * - Identify what aspects of your application vary, separate them out of what stays same
 */

/**
 * This is a Duck Simulator.
 * We can have as many type of duck is a field and make them speak or fly or something else.
 * Need to prepare a lld with proper design patter
 * Eg.
 * 1. A Duck Class will be there with low or min details
 * 2. Other types of Duck will inherit this Duck class
 * 3. Fly or Speak behavior can be associated with a Duck
 *
 */
public class SimUDuck {
    public static void main(String[] args) {
        Duck mallarDuck = new MallarDuck();
        Duck woodenDuck = new WoodenDuck();

        mallarDuck.performFly();
        woodenDuck.performFly();

        mallarDuck.performSpeak();
        woodenDuck.performSpeak();

    }
}
