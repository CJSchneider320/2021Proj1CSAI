package Proj1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Write a description  here.
 *
 * @author Ferguson
 * @version April 7, 2020
 */
public class StopWatchPanel extends JPanel {

    private StopWatch watch;
    private Timer javaTimer;

    JButton startButton, stopButton, loadButton, addButton;
    JButton subButton, saveButton, continueButton, newButton;
    JTextField minField, secField, milliField, addField;
    JTextField subField, newField;

    JLabel lblTime;

    public StopWatchPanel() {

        // create the game object as well as the GUI1024 Frame
        watch = new StopWatch();
        javaTimer = new Timer(5, new TimerListener());

        setLayout(new GridLayout(10, 2));
        setBackground(Color.lightGray);

        add(new JLabel("Minutes:"));
        minField = new JTextField("0", 3);
        add(minField);

        add(new JLabel("Seconds:"));
        secField = new JTextField("0", 3);
        add(secField);

        add(new JLabel("Milliseconds:"));
        milliField = new JTextField("0", 3);
        add(milliField);


        stopButton = new JButton("Stop");
        add(stopButton);

        startButton = new JButton("Start");
        add(startButton);

        loadButton = new JButton("Load");
        add(loadButton);

        saveButton = new JButton("Save");
        add(saveButton);

        addButton = new JButton("Add");
        add(addButton);

        addField = new JTextField("0", 3);
        add(addField);

        subButton = new JButton("Subtract");
        add(subButton);

        subField = new JTextField("0", 3);
        add(subField);

        newButton = new JButton("New");
        add(newButton);

        newField = new JTextField("0:0:0", 3);
        add(newField);

        continueButton = new JButton("Continue");
        add(continueButton);


        //TO DO:  Include code to instantiate objects
        //TO DO: and add them to the JPanel -
        //TO DO: see project description for layout
        add(new JLabel(" "));

        add(new JLabel("Time:"));
        lblTime = new JLabel();
        lblTime.setText(watch.toString());
        add(lblTime);

        ButtonListener bl = new ButtonListener();
        startButton.addActionListener(bl);
        loadButton.addActionListener(bl);
        stopButton.addActionListener(bl);
        addButton.addActionListener(bl);
        saveButton.addActionListener(bl);
        subButton.addActionListener(bl);
        continueButton.addActionListener(bl);
        newButton.addActionListener(bl);

//		startButton.addActionListener(new ButtonListener());
//		TO DO:  Add action listeners for the JButtons

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int mins, sec, milli, p;

            if (event.getSource() == startButton) {
                try {
                    mins = Integer.parseInt(minField.getText());
                    sec = Integer.parseInt(secField.getText());
                    milli = Integer.parseInt(milliField.getText());
                    watch = new StopWatch(mins, sec, milli);
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == stopButton) {
                javaTimer.stop();
            }

            if (event.getSource() == addButton) {
                try {
                    addField.getText();
                    p = Integer.parseInt(addField.getText());
                    watch.add(p);
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == subButton) {
                try {
                    subField.getText();
                    p = Integer.parseInt(subField.getText());
                    watch.sub(p);
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == continueButton) {
                try {
                    mins = Integer.parseInt(minField.getText());
                    sec = Integer.parseInt(secField.getText());
                    milli = Integer.parseInt(milliField.getText());
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == saveButton) {
                int input = 1;
                int minTemp, secTemp, milliTemp;
                try {
                    String filename = "save";
                    filename = JOptionPane.showInputDialog("Please input the name of the file you want to " +
                            "save this StopWatch to (without .txt)");

                    watch.save(filename);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == loadButton) {
                try {
                    String filename = "load";
                    filename = JOptionPane.showInputDialog("Please input the name of the file you want to " +
                            "load a StopWatch from (without .txt)");

                    watch.load(filename);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == newButton) {
                try {
                    String hey = newField.getText();

                    watch = new StopWatch(hey);

                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }

            }

            lblTime.setText(watch.toString());
        }

    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            watch.add(1);
            watch.add(1);
            watch.add(1);
            watch.add(1);
            watch.add(1);
            lblTime.setText(watch.toString());
        }
    }
}