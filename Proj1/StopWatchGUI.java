package Proj1;

import javax.swing.*;

public class StopWatchGUI {
	public static void main(String args[]){

		StopWatch test = new StopWatch("100:5:323");
		test.save("testFile.txt");
		test.load("testFile.txt");

		System.out.println(test.getMinutes() + " " + test.getSeconds() + " " + test.getMilliseconds());

		JMenu fileMenu;
		JMenuItem quitItem;
		JMenuBar menus;

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		menus = new JMenuBar();

		menus.add(fileMenu);

		JFrame gui = new JFrame("Stop Watch");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Proj1.StopWatchPanelMain panel = new StopWatchPanelMain(quitItem);
		gui.getContentPane().add(panel);

		gui.setSize(600,400);
		gui.setJMenuBar(menus);
		gui.pack();
		gui.setVisible(true);


	}



}
