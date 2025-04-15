//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a RadialBomb object, which extends the Torpedo class and adds a blast radius property.

public class RadialBomb extends Torpedo{
    //variables
    private double blastRadius;


    //Constructor
    public RadialBomb(double locX, double locY, double direction){
        setX(locX);
        setY(locY);
        setDirection(direction);
    }


    //getters and setters to encapsulate private fields
    public double getBlastRadius() {
        return blastRadius;
    }
    public void setBlastRadius(double blastRadius) {
        this.blastRadius = blastRadius;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "\n#RadialBomb\n" + super.toString() + "\n" + getBlastRadius();
    }
}
