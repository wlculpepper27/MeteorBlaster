//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a ShieldBoost power-up that increases the player's shield strength, extending the PowerUp class.

public class ShieldBoost extends PowerUp{
    //Variables
    private int boostAmount;


    //Constructor
    public ShieldBoost(double locX, double locY, double direction){
        setX(locX);
        setY(locY);
        setDirection(direction);
    }


    //Getters and setters to encapsulate private fields
    public int getBoostAmount() {
        return boostAmount;
    }
    public void setBoostAmount(int boostAmount) {
        this.boostAmount = boostAmount;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#ShieldBoost\n" + super.toString() + "\n" + getBoostAmount() + "\n";
    }
}
