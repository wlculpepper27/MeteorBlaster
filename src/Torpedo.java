//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a Torpedo object in the game, which extends the MovingSprite class.
//It includes properties like damage and methods for managing damage values and string representation.

public class Torpedo extends MovingSprite{
    //variables
    private double damage;


    //No-args constructor
    public Torpedo(){
        super();
        setDamage(0);
    }


    //getters and setters to encapsulate private fields
    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#Torpedo\n" + super.toString() + "\n" + damage;
    }
}
