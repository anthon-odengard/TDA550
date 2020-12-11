import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state.
 */

public class CarController implements MoveObserver {
    private CarModel model;
    private CarView frame;
    private int gasAmount = 0;

    //Constructor
    public CarController(CarView f, CarModel m) {
        this.frame = f;
        this.model = m;
        initButtonListeners();
    }

    /***
     * Method for noticing if a vehicle has hit the boundary of the JFrame.
     */
    @Override
    public void actOnCarChange() {
        ArrayList<Point2D> allLocations = model.getAllLocations();
        for (int i = 0; i < allLocations.size(); i++) {
            int x = (int) Math.round(allLocations.get(i).getX());
            int y = (int) Math.round(allLocations.get(i).getY() + i * 100);

            if (x + 100 > frame.getX() || x < 0 || y + 60 > frame.getY() || y < 0) {
                model.turnAround(i);
            }
        }
    }

    /***
     * Method for initiating all ActionListeners on the buttons
     */
    private void initButtonListeners() {
        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });

        frame.setTrimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTrim();
                if (frame.setTrimButton.getForeground() == Color.RED) {
                    frame.setTrimButton.setForeground(Color.ORANGE);
                } else {
                    frame.setTrimButton.setForeground(Color.RED);
                }
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftRamp();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerRamp();
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.start();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stop();
            }
        });

        frame.AddVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRandom();
            }
        });

        frame.RemoveVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLast();
            }
        });
    }

}
