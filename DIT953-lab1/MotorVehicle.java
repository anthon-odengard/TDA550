import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MotorVehicle implements IMotorVehicle {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point2D.Double location;
    private double[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int currentDirection = 1;
    private ArrayList<Object> cargo;
    private Boolean hasTurbo = false;
    private double trimFactor = 1;

    /*** Creates a car with the specified attributes
     * @param nrDoors Number of doors of car
     * @param enginePower Engine power of car
     * @param color Color of car
     * @param modelName Name of car model
     */
    MotorVehicle (int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.location = new Point2D.Double();
    }

    public Point2D.Double getLocation(){
        return location;
    }

    public void setLocation(Point2D.Double location){
        this.location = location;
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors of the vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public void setEnginePower(double power){
        this.enginePower = power;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    public void setColor(Color clr){
        color = clr;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine(){
        currentSpeed = 1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    public void decrementSpeed(double amount){
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
        return;
    }

    public int getCurrentDirection(){ return currentDirection;}

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void move() {
        location.setLocation(location.getX() + directions[currentDirection][0] * currentSpeed,
                location.getY() + directions[currentDirection][1] * currentSpeed);
    }

    public void turnLeft() {
        --currentDirection;
        if (currentDirection < 0) {
            currentDirection = directions.length - 1;
        }
    }

    public void turnRight() {
        currentDirection++;
        if (currentDirection > directions.length - 1){
            currentDirection = 0;
        }
    }

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void setLoadSpace(double loadParameter) {
        //Not implemented yet

    }

    public void setLoad() {}

    public void load(Object load) {
        this.cargo.add(load);
    }

    public void deLoad(){
        this.cargo.remove(0);
    }

    public void addTurbo() {
        hasTurbo = true;
    }

    public void setTurbo() {
        if (!hasTurbo) return;
        if (trimFactor == 1){ trimFactor = 1.25;}
        else{ trimFactor = 1;}
    }

    public void setTrailer(Trailer trailer) {

    }
}


