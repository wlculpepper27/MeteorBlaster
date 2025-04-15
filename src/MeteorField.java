//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a field of meteors in the game. It is responsible for managing meteor creation, movement, and interaction within the game environment.
//It handles the meteor sprite sheet, creating new meteors at random positions within specified bounds, and moving them.

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

public class MeteorField {
    //variables
    private Random rand = new Random();
    private MeteorData meteorData;
    //#### Declare the properties on the UML Class Diagram here
    private Image meteorSheet;
    private ArrayList<Meteor> meteors;



    //No-Arg Constructor
    public MeteorField(){
        this.meteors = new ArrayList<>();
    }


    //Constructor
    public MeteorField( MeteorData meteorData){
        this.setMeteorData(meteorData); //allows access to meteorData outside the constructor.
        //#### Instantiate the meteors ArrayList
        meteors = new ArrayList<>();
        //#### Read in the meteor sprite sheet.
        try {
            meteorSheet = new Image( new FileInputStream(meteorData.getMeteorSpriteFile()));
        } catch (java.io.FileNotFoundException ex) {
            System.exit(-1);
        }
       createMeteors(6, 1024, 768);
    }


    //Mutator and accessor methods
    /**
     * Create numMeteors in the area defined by maxX and maxY
     * @param numMeteors the number of meteors to create and add to the meteors ArrayList
     * @param maxX maximum x location to create the meteor
     * @param maxY maximum y location to create the meteor
     */
    public void createMeteors( int numMeteors, int maxX, int maxY) {
        for(int i = 0; i < numMeteors; i++){
            double xLoc = rand.nextDouble() * maxX;
            double yLoc = rand.nextDouble() * maxY;
            Meteor newMeteor = new Meteor(meteorData, meteorSheet, xLoc, yLoc);
            meteors.add(newMeteor);
        }
    }
    public void moveMeteors(){
        for(Meteor meteor : meteors){
            meteor.move();
        }
    }


    //Getters and setters to encapsulate private fields
    public MeteorData getMeteorData() {
        return meteorData;
    }
    public void setMeteorData(MeteorData meteorData) {
        this.meteorData = meteorData;
    }
    public Image getMeteorSheet() {
        return meteorSheet;
    }
    public void setMeteorSheet(Image meteorSheet) {
        this.meteorSheet = meteorSheet;
    }


    //ArrayList getters and setters to encapsulate private fields
    public int getMeteorSize(){
        return meteors.size();
    }
    public Meteor getMeteor(int index){
        return meteors.get(index);
    }
    public void setMeteor(int index, Meteor meteor) {
        meteors.set(index, meteor);
    }
    public void addMeteor(Meteor meteor) {
        meteors.add(meteor);
    }
    public Meteor removeMeteor(int index){
        return meteors.remove(index);
    }



    //toString to return the object information is string format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n*\n");
        sb.append("#MeteorField\n");
        for (Meteor m : meteors) {
            sb.append(m.toString() + "\n");
        }
        return sb.toString();
    }
}

