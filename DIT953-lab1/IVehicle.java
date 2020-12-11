import java.awt.*;
import java.awt.geom.Point2D;

public interface IVehicle extends Movable {
    public int getNrDoors();

    /*** Getter method for engine power
     *
     * @return Returns engine power
     */

    /*** Getter method for number of doors
     *
     * @return Returns number of doors
     */
    Color getColor();

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    void setColor(Color clr);

    /*** Getter method for current location of car
     *
     * @return Returns cars current location
     */
    int getCurrentDirection();

    /*** Method for calculating the speed factor
     *
     * @return Returns the speed factor
     */

    Point2D.Double getLocation();



}
