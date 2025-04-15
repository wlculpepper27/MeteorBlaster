//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a movable sprite and provides methods to move it,
//track its position, direction, speed,etc. It implements the Movable interface to define
//movement-related behavior for any object that can be moved.

import javafx.scene.image.ImageView;

public abstract class MovingSprite extends ImageView implements Movable{
    //variables
    private double direction;
    private double speed;
    private double maxSpeed;
    private double parentWidth;
    private double parentHeight;


    //No-args constructor
    public MovingSprite(){
        setDirection(180);
        setMaxSpeed(5);
    }


    //getters for the center and move method(other helpful methods)
    public double getCenterX(){
        // Stub implementation
        return 0;
    }
    public double getCenterY(){
        // Stub implementation
        return 0;
    }
    public void move(){
        // Stub implementation
    }
    public double getBoundingRadius(){
        // Stub implementation
        return 1;
    }


    //getters and setters to encapsulate private fields
    public double getDirection() {
        return direction;
    }
    public void setDirection(double direction) {
        this.direction = direction;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public double getParentWidth() {
        return parentWidth;
    }
    public void setParentWidth(double parentWidth) {
        this.parentWidth = parentWidth;
    }
    public double getParentHeight() {
        return parentHeight;
    }
    public void setParentHeight(double parentHeight) {
        this.parentHeight = parentHeight;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#MovingSprite\n" + getX() + " " + getY() + " " + getDirection() + " " + getSpeed() + " " + getMaxSpeed() + " " + getParentWidth() + " " + getParentHeight();
    }
}