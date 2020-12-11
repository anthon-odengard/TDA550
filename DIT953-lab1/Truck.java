import java.awt.*;
import java.awt.geom.Point2D;

public class Truck implements IMotorVehicle{
    private MotorVehicle parent;
    private Trailer trailer = new CarTrailer(10);
    private boolean hasTrailer;

    Truck(int nrDoors, double enginePower, Color color, String modelName) {
        this.parent = new MotorVehicle(nrDoors, enginePower, color, modelName);
        hasTrailer = false;
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors of the vehicle
     */
    public int getNrDoors(){
        return parent.getNrDoors();
    }

    public void setEnginePower(double power) {
        parent.setEnginePower(power);
    }

    /*** Getter method for engine power
     *
     * @return Returns engine power
     */
    public double getEnginePower() {
        return parent.getEnginePower();
    }

    public String getModelName() {
        return parent.getModelName();
    }

    /*** Getter method for current speed
     *
     * @return Returns current speed
     */
    public double getCurrentSpeed(){
        return parent.getCurrentSpeed();
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors
     */
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

    /*** Starts car engine
     *
     */
    public void startEngine() {
        if (!hasTrailer) {
            parent.startEngine();
        }
        else if(trailer.getRampPosition() == 0){
            trailer.setIsMoving(true);
            parent.startEngine();
        }
    }

    /*** Stops car engine
     */
    public void stopEngine(){

        parent.stopEngine();
        trailer.setIsMoving(false);
    }

    /*** Increases the speed of car
     * @param amount of which to increase the speed
     */
    public void incrementSpeed(double amount) {
        if (hasTrailer == false) {
            parent.incrementSpeed(amount);
        }
        else if(trailer.getRampPosition() == 0){
            parent.incrementSpeed(amount);
            trailer.setIsMoving(true);
        }
    }

    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    public void decrementSpeed(double amount) {
        parent.decrementSpeed(amount);
        if(parent.getCurrentSpeed() == 0){
            trailer.setIsMoving(false);
        }
    }

    public Point2D.Double getLocation(){
        return parent.getLocation();
    }

    /*** Getter method for current location of car
     *
     * @return Returns cars current location
     */
    public int getCurrentDirection(){
        return parent.getCurrentDirection();
    }

    /*** Method for calculating the speed factor
     *
     * @return Returns the speed factor
     */
    public double speedFactor(){
        return parent.speedFactor();
    }

    /*** Method for moving car in the current direction
     *
     */
    public void move(){
        parent.move();
        if (hasTrailer) {
            trailer.setLocation(getLocation());
        }
    }

    /*** Method for turning the vehicle lefT
     */
    public void turnLeft(){
        parent.turnLeft();
    }

    /*** Method for turning the vehicle right
     */
    public void turnRight(){
        parent.turnRight();
    }

    /*** Method for increasing the speed
     *
     * @param amount of gas, restricted to values [0,1]
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else {
            return;
        }
    }

    /*** Method for decreasing the car
     *
     * @param amount of braking restricted to values [0,1]
     */
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void setLoadSpace(double loadParameter) {
        trailer.setRampPosition(loadParameter);
    }

    public void addTurbo() {
        parent.addTurbo();
    }

    @Override
    public void setTurbo() {
        parent.setTurbo();
    }

    public void setTrailer(Trailer trailer) {
        if (!hasTrailer) {
            this.trailer = trailer;
            this.trailer.setLocation(this.getLocation());
            this.trailer.setTruckConnected(true);
            hasTrailer = true;
        }
    }

    /***
     * Getter method for trailer
     * @return the trailer of the truck.
     */
    public Trailer getTrailer() {
        return trailer;
    }

    public <A> void load(A load) {

        try {
            trailer.load(load);
        }catch (IllegalArgumentException e){

        }
    }

    public void deLoad() {
        trailer.deLoad();
    }


}






