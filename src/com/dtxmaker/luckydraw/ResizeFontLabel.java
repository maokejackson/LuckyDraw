package com.dtxmaker.luckydraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * http://java-sl.com/tip_adapt_label_font_size.html
 * <p/>
 * Created by Maoke Jackson on 19/2/2015.
 */
public class ResizeFontLabel extends JLabel {
    public static final int MIN_FONT_SIZE = 3;
    public static final int MAX_FONT_SIZE = 2048;
    Graphics g;

    public ResizeFontLabel() {
        this("");
    }

    public ResizeFontLabel(String text) {
        super(text);
        init();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        adaptLabelFont(this);
    }

    protected void init() {
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                adaptLabelFont(ResizeFontLabel.this);
            }
        });
    }

    protected void adaptLabelFont(JLabel l) {
        if (g == null) {
            return;
        }
        Rectangle r = l.getBounds();
        int fontSize = MIN_FONT_SIZE;
        Font f = l.getFont();

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        while (fontSize < MAX_FONT_SIZE) {
            r1.setSize(getTextSize(l, f.deriveFont(f.getStyle(), fontSize)));
            r2.setSize(getTextSize(l, f.deriveFont(f.getStyle(), fontSize + 1)));
            if (r.contains(r1) && !r.contains(r2)) {
                break;
            }
            fontSize++;
        }

        setFont(f.deriveFont(f.getStyle(), fontSize));
        repaint();
    }

    private Dimension getTextSize(JLabel l, Font f) {
        Dimension size = new Dimension();
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        size.width = fm.stringWidth(l.getText());
        size.height = fm.getHeight();

        return size;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
    }
}
