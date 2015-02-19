package com.dtxmaker.luckydraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Created by Maoke Jackson on 19/2/2015.
 */
public class LuckyDraw extends JFrame {
    private LuckyBox luckyBox;
    private LuckyNumber lblNumber;
    private JButton btnSpin;
    private JList<Integer> lstHistory;
    private Vector<Integer> history;

    public LuckyDraw(int min, int max) {
        luckyBox = new LuckyBox(min, max);
        lblNumber = new LuckyNumber(luckyBox);
        btnSpin = new JButton(spinAction);
        lstHistory = new JList<Integer>();
        history = new Vector<Integer>(luckyBox.getSize());

        JScrollPane scrollPane = new JScrollPane(lstHistory);
        scrollPane.setPreferredSize(new Dimension(100, 100));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lblNumber, BorderLayout.CENTER);
        panel.add(btnSpin, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.EAST);
        setContentPane(panel);

        setTitle("Lucky Draw");
        Dimension size = new Dimension(600, 400);
        pack();
        setSize(size);  // set window size
        setMinimumSize(size);   // set minimum window size
        setLocationRelativeTo(null);    // put the window in center of screen
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // exit when user press the X button
        setVisible(true);   // show the window
    }

    public void spin() {
        if (luckyBox.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No more number");
        } else {
            btnSpin.setAction(stopAction);
            lblNumber.start();
        }
    }

    public void stop() {
        btnSpin.setAction(spinAction);

        Integer luckyNumber = lblNumber.stop();
        history.add(luckyNumber);
        lstHistory.setListData(history);
        lstHistory.revalidate();
        int index = history.size() - 1;
        lstHistory.ensureIndexIsVisible(index);
    }

    private AbstractAction spinAction = new AbstractAction("Spin") {
        @Override
        public void actionPerformed(ActionEvent e) {
            spin();
        }
    };

    private AbstractAction stopAction = new AbstractAction("Stop") {
        @Override
        public void actionPerformed(ActionEvent e) {
            stop();
        }
    };

    public static void main(String[] args) {
        System.out.println("Argument number: " + args.length);

        if (args.length < 2) {
            System.err.println("Must contains at least 2 arguments");
        }

        final int min = Integer.parseInt(args[0]);
        final int max = Integer.parseInt(args[1]);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LuckyDraw(min, max);
            }
        });
    }
}
