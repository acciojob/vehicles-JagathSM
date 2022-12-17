package com.driver;

public class Main {
    public static void main(String[] args) {
        F1 mercedes = new F1("mercedes", false);
        System.out.println(mercedes.isManual());
        mercedes.move(80, 0);
        mercedes.accelerate(200);
        mercedes.accelerate(-60);
        System.out.println(mercedes.getName());
        System.out.println(mercedes.getCurrentSpeed());
        System.out.println(mercedes.getCurrentGear());
    }
}