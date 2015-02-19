package com.dtxmaker.luckydraw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maoke Jackson on 19/2/2015.
 */
public class LuckyNumber extends ResizeFontLabel implements ActionListener {
    public static final int DELAY = 100;

    private LuckyBox luckyBox;
    private Timer timer;

    public LuckyNumber(LuckyBox luckyBox) {
        this.luckyBox = luckyBox;

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

        timer = new Timer(DELAY, this);
    }

    public void start() {
        timer.start();
    }

    public Integer stop() {
        timer.stop();
        Integer number = generateRandomNumber();
        luckyBox.removeNumber(number);
        return  number;
    }

    private Integer generateRandomNumber() {
        Integer number = luckyBox.randomNumber();
        setNumber(number);
        return number;
    }

    public void setNumber(Integer number) {
        if (number == null) {
            setText("");
        } else {
            setText(String.valueOf(number));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateRandomNumber();
    }
}
