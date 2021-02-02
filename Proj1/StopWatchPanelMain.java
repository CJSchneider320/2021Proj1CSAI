package Proj1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopWatchPanelMain extends JPanel {
    private JMenuItem quitItem;
    private JCheckBox suspendCheckBox;


    public StopWatchPanelMain(JMenuItem quitItem) {
        this.quitItem = quitItem;

        JPanel panel = new JPanel();
        panel.add(new StopWatchPanel());

        JPanel panel2 = new JPanel();
        panel.add(new StopWatchPanel());

        JPanel panel3 = new JPanel();
        panel.add(new StopWatchPanel());

        suspendCheckBox = new JCheckBox("Suspend Timers");
        suspendCheckBox.setSelected(false);
        panel.add(suspendCheckBox);

        add(panel);


        quitItem.addActionListener(new Mylistener());
        suspendCheckBox.addActionListener(new Mylistener());
    }

    private class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitItem)
                System.exit(1);

            if (e.getSource() == suspendCheckBox) {
                if (StopWatch.isSuspended() == false)
                    StopWatch.setSuspend(true);
                else if (StopWatch.isSuspended() == true)
                    StopWatch.setSuspend(false);
            }


        }
    }
}


