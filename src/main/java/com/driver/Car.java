package com.driver;

public class Car extends Vehicle {
    private int wheels;
    private String type;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;
    private int seats;

    private int currentSpeed;
    private int currentDirection;

    public Car(String name, int wheels, int doors, int gears, boolean isManual, String type, int seats) {
        super(name);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.type = type;
        this.seats = seats;
        this.currentGear = 1;

        this.currentSpeed = 0;
        this.currentDirection = 0;
        //Hint: Car extends Vehicle
    }

    public void changeGear(int newGear){
        currentGear = newGear;
        switch (currentGear){
            case 1:
                currentSpeed = 1;
                break;
            case 2:
                currentSpeed = 51;
                break;
            case 3:
                currentSpeed = 101;
                break;
            case 4:
                currentSpeed = 151;
                break;
            case 5:
                currentSpeed = 201;
                break;
            case 6:
                currentSpeed = 251;
                break;
        }
        System.out.println("changeGear method called - The gear is changed to: " + currentGear);
    }

    public void changeSpeed(int newSpeed, int newDirection){
        super.move(newSpeed, newDirection);
        if(newSpeed >= 0 || newSpeed <=20) currentGear = 1;
        else if(newSpeed >= 51 || newSpeed <=100) currentGear = 2;
        else if(newSpeed >= 101 || newSpeed <=150) currentGear = 3;
        else if(newSpeed >= 151 || newSpeed <=200) currentGear = 4;
        else if(newSpeed >= 201 || newSpeed <=250) currentGear = 5;
        else if(newSpeed > 250) currentGear = 6;
        System.out.println("changeSpeed method called - The speed is changed to: " + newSpeed + ", and the direction is changed to: " + newDirection + " degrees");
    }

    public void move(int speed, int direction){
        //set the values of currentSpeed and currentDirection
        this.currentSpeed = speed;
        this.currentDirection = direction;

        System.out.println("move method called - The speed is changed to: " + currentSpeed + ", and the direction is changed to: " + currentDirection + " degrees");
    }

    public void steer(int direction){
        //direction is in degrees, add it to the current direction
        currentDirection = direction;
        System.out.println("steer method called - The direction is changed to: " + currentDirection + " degrees");
    }

    public void stop(){
        currentSpeed = 0;
        System.out.println("stop method called - The vehicle is stopped");
    }

}
