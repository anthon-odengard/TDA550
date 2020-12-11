import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements MoveObserver, AddedVehicleObserver{
    private CarModel carModel;

    private ArrayList<BufferedImage> images = new ArrayList<>();
    private ArrayList<Point> carPoints = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel carModel) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.carModel = carModel;
    }

    /***
     * Method for noticing if a vehicle has moved and repainting it at the new location.
     */
    @Override
    public void actOnCarChange() {
        ArrayList<Point2D> allLocations = carModel.getAllLocations();
        for (int i = 0; i < allLocations.size(); i++) {
            int x = (int) Math.round(allLocations.get(i).getX());
            int y = (int) Math.round(allLocations.get(i).getY() + i * 100);

            this.moveit(x,y,i);
            this.repaint();
        }
    }

    /***
     * Method for noticing if a vehicle has been added and repainting it.
     * @param fileName Path to the image file
     */
    @Override
    public void actOnAddedVehicle(String fileName) {
        this.addImage(fileName);
        this.addPoint(new Point(0, carPoints.size() * 100));
        this.repaint();
    }

    /***
     * Method for noticing if a vehicle has been removed.
     */
    @Override
    public void actOnRemovedVehicle() {
        removeImage();
        this.repaint();
    }

    void moveit(int x, int y, int i){
        carPoints.get(i).move(x, y);
    }

    public void addPoint(Point point){
        carPoints.add(point);
    }

    public void addImage(String filename) {
        try {
        images.add(ImageIO.read(DrawPanel.class.getResourceAsStream(filename)));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void removeImage(){
        try {
            int lastIndex = images.size()-1;
            images.remove(lastIndex);
            carPoints.remove(lastIndex);
        } catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= images.size()-1; i++) {
            g.drawImage(images.get(i),(int) carPoints.get(i).getX(),(int) carPoints.get(i).getY(), null); // see javadoc for more info on the parameters
        }
    }
}
