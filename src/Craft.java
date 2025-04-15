//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents the player's craft in the game, including rotate, fire torpedoes, and adjust speed.
//It extends the MovingSprite class and manages attributes like facing direction, shield strength, and movement.

import javafx.scene.media.AudioClip;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
/**
 * Some of the methods are started for you.  Make sure you refer to the UML class diagram
 * for all the methods that must be implemented.
 */


public class Craft extends MovingSprite{
    //variables
    private double DECREASE_AMT;
    private double INCREASE_AMT;
    private double facingDirection;
    private Image[] images;
    private int craftDisplayed;
    private int numImages;
    private ArrayList<Torpedo> torpedos;
    private URL phaserResource;
    private AudioClip phaserClip;
    private double shieldStrength;

    //No-args Constructor
    public Craft(){
        this.torpedos = new ArrayList<>();
    }


    //Constructor
    public Craft(CraftData craftData) {
        //#### Initialize INCREASE_AMT, DECREASE_AMT NUM_IMAGES using craftData
        this.INCREASE_AMT = craftData.getThrustIncreaseAmount();
        this.DECREASE_AMT = craftData.getThrustDescreaseAmount();
        this.numImages = craftData.numImageFiles();

        //#### Instantiate torpedoes and images
        this.torpedos = new ArrayList<>();
        if (numImages > 0) {
            this.images = new Image[numImages];
        } else {
            System.err.println("Error: No images found for craft!");
            System.exit(-1);
        }


        //#### Read in the image files.  There is a hint under the Craft UML diagram.
        try {
            for (int i = 0; i < numImages; i++) {
                images[i] = new Image( new FileInputStream(craftData.getImageFile(i)));
            }
        }
        catch (java.io.FileNotFoundException ex) {
            System.exit(-1);
        }

        //#### Uncomment these once you have completed the above.
        this.setImage(images[0]);
        phaserResource = getClass().getResource("resources/fireTorpedo.mp3");
        phaserClip = new AudioClip(phaserResource.toString());
    }


    //Mutator and accessor methods
    /**
     * Update the facingDirection by angle degrees.  Angle can be +/-.  You must
     * make sure it remains between 0 and 359 degrees.  The mod function should help you.
     * @param angle  increase/decrease angle amount
     */
    public void rotate(double angle) {
        if(this.getFacingDirection() > 0 && this.getFacingDirection() < 360){
            setFacingDirection(this.getFacingDirection() + angle);
        }
    }
    /**
     * Instantiate a new Torpedo ana add it to the
     */
    public void fireTorpedo() {
        Torpedo newTorpedo = new Torpedo();
        torpedos.add(newTorpedo);
        phaserClip.play();
    }
    public void moveTorpedoes(){
        for(int i = 0; i < torpedos.size(); i++){
            move();
        }
    }
    public void abortTorpedoes(){
        torpedos.clear();
    }
    public void increaseSpeed(){
        if(getSpeed() + INCREASE_AMT <= getMaxSpeed()){
            setSpeed(getMaxSpeed());
        }
        else if(getSpeed() + INCREASE_AMT < getMaxSpeed()){
            setSpeed(getSpeed() + INCREASE_AMT);
        }
    }
    public void decreaseSpeed(){
        if(getSpeed() - DECREASE_AMT > 0){
            setSpeed(getSpeed() - DECREASE_AMT);
        }
        else if(getSpeed() - DECREASE_AMT <= 0){
            setSpeed(0);
        }
    }
    public void toggleImage(){
        craftDisplayed = (craftDisplayed + 1) % numImages;
        setImage(images[craftDisplayed]);
    }

    @Override
    public void move() {
        // Calculate new x and y positions
        double newX = getX() + getSpeed() * Math.cos(Math.toRadians(getFacingDirection()));
        double newY = getY() + getSpeed() * Math.sin(Math.toRadians(getFacingDirection()));

        // Update the craft's position
        setX(newX);
        setY(newY);
    }


    //getters and setters to encapsulate private fields
    public double getFacingDirection() {
        return facingDirection;
    }
    public void setFacingDirection(double facingDirection) {
        this.facingDirection = facingDirection;
    }
    public int getCraftDisplayed() {
        return craftDisplayed;
    }
    public void setCraftDisplayed(int craftDisplayed) {
        this.craftDisplayed = craftDisplayed;
    }
    public double getShieldStrength() {
        return shieldStrength;
    }
    public void setShieldStrength(double shieldStrength) {
        this.shieldStrength = shieldStrength;
    }


    //ArrayList getters and setters to encapsulate private fields
    public int getTorpedoSize(){
        return torpedos.size();
    }
    public Torpedo getTorpedo(int index){
        return torpedos.get(index);
    }
    public void setTorpedo(int index, Torpedo torpedo) {
        torpedos.set(index, torpedo);
    }
    public void addTorpedo(Torpedo torpedo) {
        torpedos.add(torpedo);
    }
    public Torpedo removeTorpedo(int index){
        return torpedos.remove(index);
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#Craft\n" + super.toString() + "\n" + getFacingDirection() + " " + getCraftDisplayed() + " " + getShieldStrength();
    }
}
