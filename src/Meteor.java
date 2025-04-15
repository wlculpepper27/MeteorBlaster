//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a Meteor in the game, extending the MovingSprite class.
//It handles meteor data, such as size, points, speed, and the image dimensions for rendering meteors on screen.

import javafx.scene.image.Image;

import java.util.Random;

public class Meteor extends MovingSprite {
    //variables
    private double MIN_SIZE;
    private int points;
    private int size;
    private double meteorImageWidth;
    private double meteorImageHeight;
    private Random rand = new Random();


    //No-arg Constructor
    public Meteor() {}

    //Constructor
    /**
     * @param meteorData - meteor data read from config file
     * @param image      - Loaded sprite sheet image with several meteors
     * @param xLoc       - x location of where the meteor should be created.
     * @param yLoc       - y location of where the meteor should be created
     */
    public Meteor(MeteorData meteorData, Image image, double xLoc, double yLoc) {
        //Use meteorData to initialize MIN_SIZE,
        this.setMIN_SIZE(meteorData.getMinSize());

        setMeteorImageWidth(image.getWidth() / meteorData.getMeteorCols());
        setMeteorImageHeight(image.getHeight() / meteorData.getMeteorRows());

        //#### use xLoc, yLoc to initialize the current x,y position
        this.setX(xLoc);
        this.setY(yLoc);

        //#### Set the current direction to be a random value between 0 and 359 degrees
        this.setDirection(Math.random() * 360);

        //Initialize the displayed image, size and points for this meteor. - uncomment
        setSize(2 + rand.nextInt(3));
        setPoints((5 - this.getSize()) * 5);

        //#### set the speed to be a random value between 1 and the maximum speed.
        this.setSpeed(1 + Math.random() * (meteorData.getMaxSpeed() - 1));
    }


    //getters for the center and move method(other helpful methods)
    public double getMIN_SIZE() {
        return MIN_SIZE;
    }
    public void setMIN_SIZE(double MIN_SIZE) {
        this.MIN_SIZE = MIN_SIZE;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public double getMeteorImageWidth() {
        return meteorImageWidth;
    }
    public void setMeteorImageWidth(double meteorImageWidth) {
        this.meteorImageWidth = meteorImageWidth;
    }
    public double getMeteorImageHeight() {
        return meteorImageHeight;
    }
    public void setMeteorImageHeight(double meteorImageHeight) {
        this.meteorImageHeight = meteorImageHeight;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#Meteor\n" + super.toString() + "\n" + getMIN_SIZE() + " " + getPoints() + " " + getSize() + getMeteorImageWidth() + " " + getMeteorImageHeight();
    }
}