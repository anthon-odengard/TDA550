import java.awt.geom.Point2D;
import java.util.Stack;

public class TruckBed implements Trailer<Object> {
    private double position;
    private Stack<Object> Load = new Stack<>();
    private Point2D.Double location;
    private boolean isMoving;
    private boolean truckConnected;


    /***
     * Constructor for truck bed trailer
     */
    public TruckBed(){
        this.position = 0;
    }

    public double getRampPosition() {
        return position;
    }

    public void setRampPosition(double position){
        if (position >= 0 && position <= 70) {
            if (this.getTruckConnected()) {
               if (!this.getIsMoving()) {
                   this.position = position;
               }
            } else {
                this.position = position;
            }
        }
    }

    /*** Not implemented yet
     */
    public Stack<Object> getLoad(){
        System.out.println("Not implemented yet");
        return Load;
    }

    public void load(Object o){
        System.out.println("Cannot load car in truckbed");
    }

    public void deLoad(){
        System.out.println("Cannot load car in truckbed");
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public boolean getTruckConnected(){
        return truckConnected;
    }

    public void setLocation(Point2D.Double location){
        this.location = location;
    }
    public void setTruckConnected(boolean truckConnected){
        this.truckConnected = truckConnected;
    };

    public void setIsMoving(boolean isMoving){
        this.isMoving = isMoving;
    }

    public boolean getIsMoving(){
        return this.isMoving;
    }
}
