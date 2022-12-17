package com.driver;

public class F1 extends Car {
    private int currentSpeed;
    private int currentDirection;

    public F1(String name, boolean isManual) {
        super(name, 4, 4, 6, isManual, "Race Car",2);
        //Use arbitrary values for parameters which are not mentioned
        this.currentSpeed = 0;
        this.currentDirection = 0;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void accelerate(int rate){
        int newSpeed = this.currentSpeed + rate; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        this.currentSpeed = newSpeed;
        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            this.stop();
            this.changeGear(1);
        }
        //for all other cases, change the gear accordingly

        if(newSpeed > 0) {
            move(newSpeed, getCurrentDirection());
        }
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
