import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.Timer;

public class CarModel {
    //Field with active vehicles
    private ArrayList<IMotorVehicle> motorVehicles;
    //Fields of observers
    private ArrayList<MoveObserver> moveObservers = new ArrayList<>();
    private ArrayList<AddedVehicleObserver> addedVehicleObservers = new ArrayList<>();
    private ArrayList<SpeedObserver> speedObservers = new ArrayList<>();

    //Constructor

    /*** Constructor for CarModel, initiates motorVehicles
     *
     */
    CarModel(){
        this.motorVehicles = new ArrayList<>() ;
    }

    /*** Starts timer in CarModel
     *
     * @param delay Delay between Timer events
     */
    public void startTimer(int delay) {
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }

    //Observer methods
    void addAddedVehicleObserver(AddedVehicleObserver obs) {
        this.addedVehicleObservers.add(obs);
    }

    public void removeAddedCarObserver(AddedVehicleObserver observer){
    this.addedVehicleObservers.remove(observer);
    }

    public void notifyAddedCarObservers(String fileName) {
        for (AddedVehicleObserver obs : addedVehicleObservers) {
            obs.actOnAddedVehicle(fileName);
        }
    }
    public void notifyRemovedCarObservers() {
        for (AddedVehicleObserver obs : addedVehicleObservers) {
            obs.actOnRemovedVehicle();
        }
    }

    void addMoveObserver(MoveObserver obs) {
        this.moveObservers.add(obs);
    }

    public void removeMoveObserver(MoveObserver observer){
        this.moveObservers.remove(observer);
    }

    public void notifyMoveObservers() {
        for (MoveObserver obs : moveObservers) {
            obs.actOnCarChange();
        }
    }

    void addSpeedObserver(SpeedObserver obs) {
        this.speedObservers.add(obs);
    }

    public void removeSpeedObserver(SpeedObserver observer){
        this.speedObservers.remove(observer);
    }

    public void notifySpeedObservers() {
        for (SpeedObserver obs : speedObservers) {
            obs.actOnSpeedChange();
        }
    }

    /*** TimerListener for moving the vehicles at a timer event
     *
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IMotorVehicle vehicle : motorVehicles) {
                vehicle.move();
            }
            notifyMoveObservers();
        }
    }

    //Possible actions
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IMotorVehicle vehicle : motorVehicles) {
            vehicle.gas(gas);
        }
        notifySpeedObservers();
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IMotorVehicle vehicle : motorVehicles) {
            vehicle.brake(brake);
        }
        notifySpeedObservers();
    }

    void setTrim(){
        for(IMotorVehicle vehicle : motorVehicles) {
            vehicle.setTurbo();
        }
    }

    void liftRamp(){
        for(IMotorVehicle vehicle : motorVehicles){
            vehicle.setLoadSpace(70);
        }
    }

    void lowerRamp(){
        for(IMotorVehicle vehicle : motorVehicles){
            vehicle.setLoadSpace(0);
        }
    }

    void start() {
        for (IMotorVehicle vehicle : motorVehicles) {
            vehicle.startEngine();
        }
        notifySpeedObservers();
    }

    void stop() {
        for (IMotorVehicle vehicle : motorVehicles) {
            vehicle.stopEngine();
        }
        notifySpeedObservers();
    }

    //get and add vehicle
    public ArrayList<IMotorVehicle> getVehicles() {
        return motorVehicles;
    }

    /***
     * Method for adding a vehicle to the model
     * @param vehicle Vehicle to be added
     * @param fileName Path to the image file
     */
    public void addVehicle(IMotorVehicle vehicle, String fileName) {
        this.motorVehicles.add(vehicle);
        notifyAddedCarObservers(fileName);
    }

    /***
     * Method for adding a random car to the model
     */
    public void addRandom() {
        if (motorVehicles.size() > 9) return;
        IMotorVehicle newVehicle = MotorVehicleFactory.build();
        String fileName = "pics/" + newVehicle.getModelName() + ".jpg";

        this.motorVehicles.add(newVehicle);
        notifyAddedCarObservers(fileName);
    }

    /***
     * Method for removing the last vehicle from the model
     */
    public void removeLast() {
        if (motorVehicles.size() <= 0) return;
        int lastIndex = motorVehicles.size()-1;

        motorVehicles.remove(lastIndex);
        notifyRemovedCarObservers();
    }

    //Methods for use in the views
    public ArrayList<Point2D> getAllLocations(){
        ArrayList<Point2D> allLocations = new ArrayList<>();
        for(IMotorVehicle motorVehicle: motorVehicles){
            allLocations.add(motorVehicle.getLocation());
        }
        return allLocations;
    }

    public ArrayList<Double> getAllSpeeds(){
        ArrayList<Double> allSpeeds = new ArrayList<>();
        for(IMotorVehicle motorVehicle: motorVehicles){
            allSpeeds.add(motorVehicle.getCurrentSpeed());
        }
        return allSpeeds;
    }

    public ArrayList<String> getAllNames() {
        ArrayList<String> allNames = new ArrayList<>();
        for (IMotorVehicle motorVehicle : motorVehicles) {
            allNames.add(motorVehicle.getModelName());
        }
        return allNames;
    }

    /***
     * Method for turning the vehicles around
     * @param index Index for the car to be turned around
     */
    public void turnAround(int index){
        for(int i = 0 ; i < 2; i++) {
            motorVehicles.get(index).turnRight();
        }
    }

}
