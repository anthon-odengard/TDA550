import java.awt.geom.Point2D;

public interface Movable {
    /*** Method for moving car in the current direction
     *
     */
    void move();

    /*** Method for turning the vehicle lefT
     *
     */
    void turnLeft();

    /*** Method for turning the vehicle right
     *
     */
    void turnRight();
    /*** Increases the speed of car
     * @param amount of which to increase the speed
     */

}

