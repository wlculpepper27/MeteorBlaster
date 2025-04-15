//Weston Culpepper
//03/28/25
//Comp167-003
//This class manages the game universe, including craft, meteor field, power-ups, and moving objects.
//It saves and loads the game state and provides methods to modify and interact with other things in the game.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUniverse {
    //variables
    private ArrayList<MovingSprite> movingObjects;
    private ArrayList<PowerUp> powerUps;
    private MeteorField meteorField;
    private Craft craft;
    //private GamerProfile gamerProfile;


    //No-args constructor
    public GameUniverse() {
        craft = new Craft();
        powerUps = new ArrayList<>();
        meteorField = new MeteorField();
        movingObjects = new ArrayList<>();
    }


    //Constructor
    public GameUniverse(MeteorBlasterConfigData configData) {
    }


    //Mutator and accessor methods
    public void saveGame(String filename) {

        try {
            PrintWriter pw = new PrintWriter(new File(filename));
            pw.write(this.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void loadGame(String filename)throws FileNotFoundException {
        Scanner scnr = new Scanner(new File(filename));

        String header = scnr.nextLine().trim();

        scnr.nextLine();

        String craftSpriteLine = scnr.nextLine().trim();
        String[] craftSpriteParts = craftSpriteLine.split(" ");
        double craftX = Double.parseDouble(craftSpriteParts[0]);
        double craftY = Double.parseDouble(craftSpriteParts[1]);
        double craftDirection = Double.parseDouble(craftSpriteParts[2]);
        double craftSpeed = Double.parseDouble(craftSpriteParts[3]);
        double craftMaxSpeed = Double.parseDouble(craftSpriteParts[4]);
        double craftParentWidth = Double.parseDouble(craftSpriteParts[5]);
        double craftParentHeight = Double.parseDouble(craftSpriteParts[6]);

        String craftDataLine = scnr.nextLine().trim();
        String[] craftDataParts = craftDataLine.split(" ");
        double craftFacingDirection = Double.parseDouble(craftDataParts[0]);
        int craftDisplayed = Integer.parseInt(craftDataParts[1]);
        double craftShieldStrength = Double.parseDouble(craftDataParts[2]);

        craft.setX(craftX);
        craft.setY(craftY);
        craft.setDirection(craftDirection);
        craft.setSpeed(craftSpeed);
        craft.setMaxSpeed(craftMaxSpeed);
        craft.setParentWidth(craftParentWidth);
        craft.setParentHeight(craftParentHeight);
        craft.setFacingDirection(craftFacingDirection);
        craft.setCraftDisplayed(craftDisplayed);
        craft.setShieldStrength(craftShieldStrength);


        while (scnr.hasNextLine()) {
            String line = scnr.nextLine().trim();
            if (line.isEmpty()) continue;

            if (line.equals("#PhotonTorpedo")) {
                scnr.nextLine();
                scnr.nextLine();
                String ptSpriteLine = scnr.nextLine().trim();
                String[] ptParts = ptSpriteLine.split(" ");
                double ptX = Double.parseDouble(ptParts[0]);
                double ptY = Double.parseDouble(ptParts[1]);
                double ptDirection = Double.parseDouble(ptParts[2]);
                double ptSpeed = Double.parseDouble(ptParts[3]);
                double ptMaxSpeed = Double.parseDouble(ptParts[4]);
                double ptParentWidth = Double.parseDouble(ptParts[5]);
                double ptParentHeight = Double.parseDouble(ptParts[6]);
                double ptDamage = Double.parseDouble(scnr.nextLine().trim());
                int ptThermalSeekRange = Integer.parseInt(scnr.nextLine().trim());

                PhotonTorpedo pt = new PhotonTorpedo();
                pt.setX(ptX);
                pt.setY(ptY);
                pt.setDirection(ptDirection);
                pt.setSpeed(ptSpeed);
                pt.setMaxSpeed(ptMaxSpeed);
                pt.setParentWidth(ptParentWidth);
                pt.setParentHeight(ptParentHeight);
                pt.setDamage(ptDamage);
                pt.setThermalSeekRange(ptThermalSeekRange);
                craft.addTorpedo(pt);
            }

            else if (line.equals("#RadialBomb")) {

                scnr.nextLine();
                scnr.nextLine();
                String rbSpriteLine = scnr.nextLine().trim();
                String[] rbParts = rbSpriteLine.split(" ");
                double rbX = Double.parseDouble(rbParts[0]);
                double rbY = Double.parseDouble(rbParts[1]);
                double rbDirection = Double.parseDouble(rbParts[2]);
                double rbSpeed = Double.parseDouble(rbParts[3]);
                double rbMaxSpeed = Double.parseDouble(rbParts[4]);
                double rbParentWidth = Double.parseDouble(rbParts[5]);
                double rbParentHeight = Double.parseDouble(rbParts[6]);

                double rbDamage = Double.parseDouble(scnr.nextLine().trim());
                double rbBlastRadius = Double.parseDouble(scnr.nextLine().trim());

                RadialBomb rb = new RadialBomb(rbX, rbY, rbDirection);
                rb.setSpeed(rbSpeed);
                rb.setMaxSpeed(rbMaxSpeed);
                rb.setParentWidth(rbParentWidth);
                rb.setParentHeight(rbParentHeight);
                rb.setDamage(rbDamage);
                rb.setBlastRadius(rbBlastRadius);
                craft.addTorpedo(rb);

            }
            else if (line.equals("*")) {
                continue;
            }
            else if(line.equals("#MeteorField")){
                continue;
            }
            else if (line.equals("#Meteor")) {
                scnr.nextLine();

                Meteor meteor = new Meteor();
                String dbSpriteLine = scnr.nextLine().trim();
                String[] dbParts = dbSpriteLine.split(" ");
                meteor.setX(Double.parseDouble(dbParts[0]));
                meteor.setY(Double.parseDouble(dbParts[1]));
                meteor.setDirection(Double.parseDouble(dbParts[2]));
                meteor.setSpeed(Double.parseDouble(dbParts[3]));
                meteor.setMaxSpeed(Double.parseDouble(dbParts[4]));
                meteor.setParentWidth(Double.parseDouble(dbParts[5]));
                meteor.setParentHeight(Double.parseDouble(dbParts[6]));

                String dbExtraLine = scnr.nextLine().trim();
                String[] dbExtraParts = dbExtraLine.split(" ");

                meteor.setMIN_SIZE(Integer.parseInt(dbExtraParts[0]));
                meteor.setPoints(Integer.parseInt(dbExtraParts[1]));
                meteor.setSize(Integer.parseInt(dbExtraParts[2]));
                meteor.setMeteorImageWidth(Double.parseDouble(dbExtraParts[3]));
                meteor.setMeteorImageHeight(Double.parseDouble(dbExtraParts[4]));

                meteorField.addMeteor(meteor);

            }

            else if (line.equals("#DamageBoost")) {
                scnr.nextLine();
                scnr.nextLine();
                String dbSpriteLine = scnr.nextLine().trim();
                String[] dbParts = dbSpriteLine.split(" ");
                double dbX = Double.parseDouble(dbParts[0]);
                double dbY = Double.parseDouble(dbParts[1]);
                double dbDirection = Double.parseDouble(dbParts[2]);
                double dbSpeed = Double.parseDouble(dbParts[3]);
                double dbMaxSpeed = Double.parseDouble(dbParts[4]);
                double dbParentWidth = Double.parseDouble(dbParts[5]);
                double dbParentHeight = Double.parseDouble(dbParts[6]);
                int captureTime = Integer.parseInt(scnr.nextLine().trim());

                String dbExtraLine = scnr.nextLine().trim();
                String[] dbExtraParts = dbExtraLine.split(" ");
                int damageIncrease = Integer.parseInt(dbExtraParts[0]);
                int activeRemainingTime = Integer.parseInt(dbExtraParts[1]);

                DamageBoost db = new DamageBoost(dbX, dbY, dbDirection);
                db.setSpeed(dbSpeed);
                db.setMaxSpeed(dbMaxSpeed);
                db.setParentWidth(dbParentWidth);
                db.setParentHeight(dbParentHeight);
                db.setCaptureRemainingTime(captureTime);
                db.setDamageIncrease(damageIncrease);
                db.setActiveRemainingTime(activeRemainingTime);
                powerUps.add(db);
            }

            else if (line.equals("#ShieldBoost")) {

                scnr.nextLine();
                scnr.nextLine();
                String sbSpriteLine = scnr.nextLine().trim();
                String[] sbParts = sbSpriteLine.split(" ");
                double sbX = Double.parseDouble(sbParts[0]);
                double sbY = Double.parseDouble(sbParts[1]);
                double sbDirection = Double.parseDouble(sbParts[2]);



                ShieldBoost sb = new ShieldBoost(sbX, sbY, sbDirection);
                sb.setSpeed(Integer.parseInt(sbParts[3]));
                sb.setMaxSpeed(Integer.parseInt(sbParts[4]));
                sb.setParentWidth(Double.parseDouble(sbParts[5]));
                sb.setParentHeight(Double.parseDouble(sbParts[6]));
                sb.setCaptureRemainingTime(Integer.parseInt(scnr.nextLine().trim()));
                sb.setBoostAmount(Integer.parseInt(scnr.nextLine().trim()));
                powerUps.add(sb);
            }
        }
        scnr.close();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(craft.toString());
        for (int i = 0; i < craft.getTorpedoSize(); i++) {
            sb.append(craft.getTorpedo(i).toString());
        }
        sb.append(meteorField.toString());
        for (PowerUp p: powerUps){
            sb.append(p.toString());
        }
        return sb.toString();
    }


    //ArrayList getters and setters to encapsulate private fields
    public int getMeteorSize(){
        return movingObjects.size();
    }
    public MovingSprite getMeteor(int index){
        return movingObjects.get(index);
    }
    public void setMeteor(int index, MovingSprite ms) {
        movingObjects.set(index, ms);
    }
    public void addMeteor(MovingSprite ms) {
        movingObjects.add(ms);
    }
    public MovingSprite removeMeteor(int index){
        return movingObjects.remove(index);
    }
}

