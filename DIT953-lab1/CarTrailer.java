import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.Stack;
import java.util.Iterator;

public class CarTrailer implements Trailer<Car>{
    private double rampPosition;
    private int capacity;
    private Stack<Car> loadedCars;
    private Point2D.Double location;
    private boolean isMoving;
    private boolean truckConnected;


    /***
     * Constructor for car trailer
     * @param capacity sets the maximum loading capacity of the car trailer.
     */
    public CarTrailer(int capacity){
        this.rampPosition = 0;
        this.capacity = capacity;
        loadedCars = new Stack<>();
        setLocation(new Point2D.Double());
    }

    public void setLocation(Point2D.Double location) {
       this.location = location;
        Iterator<Car> iter = loadedCars.iterator();
        while (iter.hasNext()) {
            iter.next().setLocation(this.getLocation());
        }
    }

    public double getRampPosition() {
        return rampPosition;
    }

    public void setRampPosition(double rampPosition){
        if (rampPosition > 1) rampPosition = 1;
        if ( rampPosition == 1 || rampPosition == 0) {
            if (!this.getIsMoving() && this.getTruckConnected()) {
                this.rampPosition = rampPosition;
            }else if(!this.getTruckConnected()){
                this.rampPosition = rampPosition;
            }
        }else;
    }

    public void load(Car car){
        if(loadedCars.size() < this.capacity && rampPosition == 1
                && getLocation().distance(car.getLocation()) <= 0.1) {
            loadedCars.push(car);
        }else;
    }

    public void deLoad(){
        if(loadedCars.size() > 0 && rampPosition == 1) {
            loadedCars.pop();
        }else;
    }

    public Stack<Car> getLoad() {
        return loadedCars;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public boolean getTruckConnected(){
        return truckConnected;
    }

    public void setTruckConnected(boolean truckConnected){
        this.truckConnected = truckConnected;
    }

    public void setIsMoving(boolean isMoving){
        this.isMoving = isMoving;
    }

    public boolean getIsMoving(){
        return this.isMoving;
    }
}


