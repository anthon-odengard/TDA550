import javax.swing.*;
import java.util.ArrayList;

public class CarApp {

    public static void main(String[] args) {
        CarModel carModel = new CarModel();
        CarView carView = new CarView("Car Sim 2.0");
        CarController carCont = new CarController(carView, carModel);
        DrawPanel carPanel = new DrawPanel(carView.getX(), carView.getY()-240, carModel);
        VehicleSpeedView vehicleSpeedView = new VehicleSpeedView(carModel);

        carView.add(carPanel);
        carView.add(vehicleSpeedView);

        carModel.addMoveObserver(carCont);
        carModel.addMoveObserver(carPanel);
        carModel.addAddedVehicleObserver(carPanel);
        carModel.addAddedVehicleObserver(vehicleSpeedView);
        carModel.addSpeedObserver(vehicleSpeedView);

        carModel.addVehicle(MotorVehicleFactory.buildVolvo240(), "pics/Volvo240.jpg");
        carModel.addVehicle(MotorVehicleFactory.buildSaab95(), "pics/Saab95.jpg");
        carModel.addVehicle(MotorVehicleFactory.buildScania(), "pics/Scania.jpg");

        // Start the timer with set delay
        carModel.startTimer(50);
    }

}
