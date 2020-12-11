
/*** Observer interface for notifying when a vehicle is added and removed
 *
 */
public interface AddedVehicleObserver {
    void actOnAddedVehicle(String fileName);
    void actOnRemovedVehicle();
}
