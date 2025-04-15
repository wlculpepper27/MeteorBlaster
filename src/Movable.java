//Weston Culpepper
//03/28/25
//Comp167-003
//This interface allows objects to be moved and provides methods for obtaining position and size information

public interface Movable {
    //Interface methods
    double getCenterX();
    double getCenterY();
    void move();
    double getBoundingRadius();
}
