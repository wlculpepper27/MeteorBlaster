//Weston Culpepper
//03/28/25
//Comp167-003
//This class represents a PowerUp object in the game, extending MovingSprite and introducing capture time functionality.

public class PowerUp extends MovingSprite{
    //Variable
    private int captureRemainingTime;

    //No-args constructor
    public PowerUp(){}


    //Getters and setters to encapsulate private fields
    public int getCaptureRemainingTime() {
        return captureRemainingTime;
    }
    public void setCaptureRemainingTime(int captureRemainingTime) {
        this.captureRemainingTime = captureRemainingTime;
    }


    //toString to return the object information is string format
    @Override
    public String toString(){
        return "#PowerUp\n" + super.toString() + "\n" + getCaptureRemainingTime();
    }
}
