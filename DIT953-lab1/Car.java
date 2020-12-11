import java.awt.*;
import java.awt.geom.Point2D;

/***
 *
 */
public class Car implements IMotorVehicle {
    private MotorVehicle parent;

    /*** Creates a car with the specified attributes
     * @param nrDoors Number of doors of car
     * @param enginePower Engine power of car
     * @param color Color of car
     * @param modelName Name of car model
     */
    Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.parent = new MotorVehicle(nrDoors, enginePower, color, modelName);
    }

    public void setEnginePower(double power) {
        parent.setEnginePower(power);
    }

    public double getEnginePower() {

        return parent.getEnginePower();
    }

    public String getModelName() {

        return parent.getModelName();
    }


    public double getCurrentSpeed(){
        return parent.getCurrentSpeed();
    }

    public int getNrDoors(){
        return parent.getNrDoors();
    }

    public Color getColor(){
        return parent.getColor();
    }

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    public void setColor(Color clr){
        parent.setColor(clr);
    }

    public void addTurbo() {
        parent.addTurbo();
    }

    public void setTurbo() {
        parent.setTurbo();
    }

    public void startEngine(){
        parent.startEngine();
    }

    public void stopEngine(){
        parent.stopEngine();
    }

    public void incrementSpeed(double amount) {
        parent.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount){
        parent.decrementSpeed(amount);
    }

    public Point2D.Double getLocation(){
        return parent.getLocation();
    }

    public void setLocation(Point2D.Double location) {
        parent.setLocation(location);
    }

    public int getCurrentDirection(){
        return parent.getCurrentDirection();
    }

    public double speedFactor(){
        return parent.speedFactor();
    }

    public void move(){
        parent.move();
    }

    public void turnLeft(){
        parent.turnLeft();
    }

    public void turnRight(){
        parent.turnRight();
    }

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void setLoadSpace(double loadParameter) {
        //Not implemeted yet
    }

    public <A> void load(A load) {
        //Not implemented yet

    }

    public void deLoad() {
        //Not implemented yet

    }

    public void setTrailer(Trailer trailer) {

    }
}
