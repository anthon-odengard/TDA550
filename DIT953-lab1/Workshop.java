import javax.swing.text.AbstractDocument;
import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.Arrays;

public class Workshop<T extends Car> {
    private int capacity;
    private int currentAmount;
    ArrayList<T> cars;

    public Workshop(int capacity) {
        this.cars = new ArrayList<>(capacity);
        this.capacity = capacity;
        currentAmount = 0;
    }

    /*** Add method for cars
     *
     * @param t object of type car
     */
    public void add(T t) {
        if (currentAmount < this.capacity) {
            cars.add(t);
            currentAmount++;
        } else {
            System.out.println("WorkShop full");
        }
    }

    /*** Getter method of cars
     * @return ArrayList of cars in workshop
     */
    public ArrayList<T> getCars(){
        return cars;
    }

    /*** Remove car from workshop
     *
     * @param i index of car that you want to remove
     */
    public void remove(int i) { {
        cars.remove(i);
        currentAmount--;
    }
    }

    /*** Getter for a certain car
     * @param i index of car that you want to access
     * @return returns car at index i
     */
    public T getCar(int i) {
        return cars.get(i);
    }
}

