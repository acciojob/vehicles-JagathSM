package com.driver;

public class F1 extends Car {
    private boolean isManual;

    private int currentGear;

    private String name;
    private int currentSpeed;
    private int currentDirection;

    @Override
    public int getCurrentGear() {
        return this.gearChange(currentSpeed);
    }

    public F1(String name, boolean isManual) {
        super(name, 4, 4, 6, isManual, "Race Car",2);
        //Use arbitrary values for parameters which are not mentioned
        this.isManual = isManual;

        this.name = name;
        this.currentSpeed = 0;
        this.currentDirection = 0;
        this.currentGear = 1;
    }

    @Override
    public String getName() {
        return name;
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


    public void accelerate(int rate){
        //set the value of new speed by using currentSpeed and rate
        int newSpeed = this.currentSpeed + rate;
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            stop();
        }
        //for all other cases, change the gear accordingly
        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
            gearChange(newSpeed);
        }
        this.currentSpeed = newSpeed;
    }

    public void move(int speed, int direction){
        this.currentSpeed = speed;
        this.currentDirection = direction;
        this.currentGear = gearChange(currentSpeed);
    }

    public void steer(int direction){
        super.steer(direction);
        currentDirection += direction;
    }

    public void changeSpeed(int newSpeed, int newDirection){
        this.move(newSpeed, newDirection);
    }

    public void stop(){
        currentSpeed = 0;
        currentGear = 1;
        System.out.println("stop method called - The vehicle is stopped");
    }

    public int gearChange(int newSpeed){
        if(newSpeed >= 1 && newSpeed <=50) this.currentGear = 1;
        else if(newSpeed >= 51 && newSpeed <=100) this.currentGear = 2;
        else if(newSpeed >= 101 && newSpeed <=150) this.currentGear = 3;
        else if(newSpeed >= 151 && newSpeed <=200) this.currentGear = 4;
        else if(newSpeed >= 201 && newSpeed <=250) this.currentGear = 5;
        else if(newSpeed > 250) currentGear = 6;
        return this.currentGear;
    }



}
