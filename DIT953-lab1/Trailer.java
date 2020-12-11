import java.awt.geom.Point2D;
import java.awt.*;
import java.util.Stack;

public interface Trailer <T> {
    /*** Specifies the location of the trailer.
     *
     * @param location x and y coordinates for location
     */
    void setLocation(Point2D.Double location);

    /*** Getter method for location
     *
     * @return x and y coordinates of location
     */
    Point2D.Double getLocation();

    /*** Getter method for ramp position
     *
     * @return current position of ramp
     */
    double getRampPosition();

    /*** Setter method for ramp position
     *
     *0-70 for bed, 0-1 for car trailer 1 = open, 0 = closed.
     */
    void setRampPosition(double position);

    boolean getTruckConnected();
    void setTruckConnected(boolean truckConnected);
    /*** Getter method of trailer cargo
     *
     * @return generic stack dependent on implementation
     */
    void setIsMoving(boolean isMoving);
    boolean getIsMoving();
    Stack<T> getLoad();

    /*** Setter method for trailer cargo
     *
     * for cargo type
     */
    void load(T t);

    /*** Method for deloading cargo
     *
     */
    void deLoad();
}
















