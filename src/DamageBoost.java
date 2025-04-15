//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a DamageBoost power-up that increases the player's damage, extending the PowerUp class.

public class DamageBoost extends PowerUp{
    //Variables
    private int damageIncrease;
    private int activeRemainingTime;

    //No-args Constructor
    public DamageBoost(){
        this.damageIncrease = 0;
        this.activeRemainingTime = 0;
    }

    //Constructor
    public DamageBoost(double locX, double locY, double direction){
        setX(locX);
        setY(locY);
        setDirection(direction);
    }


    //Getters and setters to encapsulate private fields
    public int getDamageIncrease() {
        return damageIncrease;
    }
    public void setDamageIncrease(int damageIncrease) {
        this.damageIncrease = damageIncrease;
    }
    public int getActiveRemainingTime() {
        return activeRemainingTime;
    }
    public void setActiveRemainingTime(int activeRemainingTime) {
        this.activeRemainingTime = activeRemainingTime;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "*\n"+"#DamageBoost\n" + super.toString() + "\n" + getDamageIncrease() + " " + getActiveRemainingTime() + "\n";
    }
}
