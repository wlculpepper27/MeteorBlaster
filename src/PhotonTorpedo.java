//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a PhotonTorpedo object, which extends the Torpedo class and adds a thermal seek range property.

public class PhotonTorpedo extends Torpedo{
    //variable
    private int thermalSeekRange;


    //No-arg Constructor
    public PhotonTorpedo(){}

    //Constructor
    public PhotonTorpedo(double locX, double locY, double direction) {
        setX(locX);
        setY(locY);
        setDirection(direction);
    }


    //getters and setters to encapsulate private fields
    public int getThermalSeekRange() {
        return thermalSeekRange;
    }
    public void setThermalSeekRange(int thermalSeekRange) {
        this.thermalSeekRange = thermalSeekRange;
    }


    //toString to return the object information is string format
    public String toString() {
        return( "\n#PhotonTorpedo\n" + super.toString() + "\n" + getThermalSeekRange());
    }
}
