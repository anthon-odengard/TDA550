public interface IMotorVehicle extends IVehicle, Loadable, IEngine {
    /***
     * Add turbo to MotorVehicle
     */
    void addTurbo();
    /***
     * MotorVehicle trim
     */
    void setTurbo();

    /*** Starts car engine
     *
     */
    void startEngine();

    /*** Stops car engine
     */
    void stopEngine();

    /***
     *
     * @return performance parameter of Motorvehicle
     */
    double speedFactor();

    /***
     *
     * @param amount increase speed of Motorvehicle
     */

    void incrementSpeed(double amount);

    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    void decrementSpeed(double amount);

    /***
     *
     * @param amount public method for increasing car Speed
     */
    void gas(double amount);

    /*** Method for decreasing the car
     *
     * @param amount of braking restricted to values [0,1]
     */
    void brake(double amount);

    /***
     * @param loadParameter sets the loadSpace parameter
     */
    void setLoadSpace(double loadParameter);

    /***
     *
     * @return currentSpeed
     */
    double getCurrentSpeed();

    /***
     *
     * @return model name of Motorvehicle
     */
    String getModelName();

    /***
     *
     * @param trailer sets Trailer if desired
     */
    void setTrailer(Trailer trailer);
}
