package Proj1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 *
 * @author Ferguson
 * @version April 7, 2020
 */
public class StopWatchPanel extends JPanel{

	private StopWatch watch;
	private Timer javaTimer;

	JButton startButton;
	JTextField minField, secField, milliField, addField, subField, newField;

	JLabel lblTime;

	public StopWatchPanel(){

		// create the game object as well as the GUI1024 Frame
		watch = new StopWatch();
		javaTimer = new Timer(5, new TimerListener());

		setLayout(new GridLayout(10,2));
		setBackground(Color.lightGray);

		add(new JLabel("Minutes:"));
		minField = new JTextField("0", 3);
		add(minField);

		add(new JLabel("Seconds:"));
		secField = new JTextField("0", 3);
		add(secField);

		add(new JLabel("Miliseconds:"));
		milliField = new JTextField("0", 3);
		add(milliField);

		add(new JButton("Stop"));

		add(new JButton("Start"));

		add(new JButton("Load"));

		add(new JButton("Save"));

		add(new JButton("Add"));
		addField = new JTextField("0", 3);
		add(addField);

		add(new JButton("Subtract"));
		subField = new JTextField("0", 3);
		add(subField);

		add(new JButton("New"));
		newField = new JTextField("0:0:0", 3);
		add(newField);

		add(new JButton("Continue"));


		//TO DO:  Include code to instantiate objects
		//TO DO: and add them to the JPanel -
		//TO DO: see project description for layout
		add (new JLabel(" "));

		add(new JLabel("Time:"));
		lblTime = new JLabel();
		lblTime.setText(watch.toString());
		add(lblTime);


//		startButton.addActionListener(new ButtonListener());
//		TO DO:  Add action listeners for the JButtons

	}

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event){

			int mins, sec, milli, p;

			if (event.getSource() == startButton){
				try{
					mins = Integer.parseInt(minField.getText());
					sec = Integer.parseInt(secField.getText());
					milli = Integer.parseInt(milliField.getText());
					watch = new StopWatch(mins,sec,milli);
					javaTimer.start();
				}catch(NumberFormatException io){
					JOptionPane.showMessageDialog(null,"Enter an integer in all fields");
				}catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,"Error in field");
				}
			}

			//TO DO:  Include ifs for each JButton

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