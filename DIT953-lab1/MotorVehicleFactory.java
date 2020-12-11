import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MotorVehicleFactory {

    public static IMotorVehicle buildVolvo240() {
        IMotorVehicle vehicle = new Car(4, 100, Color.black, "Volvo240");
        vehicle.stopEngine();
        return vehicle;
    }

    public static IMotorVehicle buildSaab95() {
        IMotorVehicle vehicle = new Car(4, 100, Color.red, "Saab95");
        vehicle.stopEngine();
        vehicle.addTurbo();
        return vehicle;
    }

    public static IMotorVehicle buildScania() {
        IMotorVehicle vehicle = new Truck(2, 50, Color.white, "Scania");
        vehicle.stopEngine();
        vehicle.setTrailer(new TruckBed());
        return vehicle;
    }

    public static IMotorVehicle buildMAN() {
        IMotorVehicle vehicle = new Truck(2, 70, Color.white, "MAN");
        vehicle.stopEngine();
        vehicle.setTrailer(new CarTrailer(10));
        return vehicle;
    }

    public static  IMotorVehicle build(){
        ArrayList<IMotorVehicle> vehicles = new ArrayList<>();
        int randomNumber = new Random().nextInt(3);

        vehicles.add(MotorVehicleFactory.buildVolvo240());
        vehicles.add(MotorVehicleFactory.buildSaab95());
        vehicles.add(MotorVehicleFactory.buildScania());

        return vehicles.get(randomNumber);
    }
}
