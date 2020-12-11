import javax.swing.*;
import java.util.ArrayList;

public class VehicleSpeedView extends JPanel implements SpeedObserver, AddedVehicleObserver {
    private ArrayList<JLabel> carLabels;
    private CarModel carModel;
    private ArrayList<String> carNames;
    private ArrayList<String> carSpeedsAsString;

    public VehicleSpeedView(CarModel carModel) {
        this.carModel = carModel;
        this.carLabels = new ArrayList<>();
        this.carNames = new ArrayList<>();
        this.carSpeedsAsString = new ArrayList<>();
    }

    /***
     * Method for updating the state of the model
     */
    private void updateVehicleArrays() {
        this.carNames = carModel.getAllNames();
        this.carSpeedsAsString = toString(carModel.getAllSpeeds());
    }

    /***
     * Method for updating the labels with the current state of the model.
     */
    private void updateVehicleLabels() {
        updateVehicleArrays();
        for(int i = 0; i < carNames.size(); i++){
            JLabel label = carLabels.get(i);
            label.setText(carNames.get(i) + ": " + carSpeedsAsString.get(i) + "      ");
        }
    }

    /***
     * Method for adding a new label
     */
    private void addVehicleLabel() {
        JLabel newLabel = new JLabel();
        carLabels.add(newLabel);
        add(newLabel);
        updateVehicleLabels();
    }

    /***
     * Method for removing the last label
     */
    private void removeVehicleLabel(){
        int lastIndex = carLabels.size()-1;
        this.carLabels.remove(lastIndex);
        remove(lastIndex);
    }

    public ArrayList<JLabel> getVehicleLabels(){
        return carLabels;
    }

    /***
     * Method for noticing if a vehicle has been added
     */
    @Override
    public void actOnAddedVehicle(String s) {
        this.addVehicleLabel();
    }
    /***
     * Method for noticing if a vehicle has been removed
     */
    @Override
    public void actOnRemovedVehicle() {
        this.removeVehicleLabel();
    }
    /***
     * Method for noticing if a vehicle has changed its speed
     */
    @Override
    public void actOnSpeedChange() {
        updateVehicleLabels();
    }

    private ArrayList<String> toString(ArrayList<Double> carSpeeds){
        ArrayList<String> carSpeedsAsStrings = new ArrayList<>();
        for(Double carSpeed : carSpeeds ){
            carSpeedsAsStrings.add(carSpeed.toString());
        }
        return carSpeedsAsStrings;
    }

}
