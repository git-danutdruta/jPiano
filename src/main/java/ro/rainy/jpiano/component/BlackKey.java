package ro.rainy.jpiano.component;

import javax.swing.*;
import java.awt.*;

/**
 * @project: jPiano
 * @author: daniel
 * @time: 29/01/2021  22:35
 */
public class BlackKey extends JButton implements Key {
    final int note;

    public BlackKey(int pos) {
        note = baseNote + 1 + 2 * pos + (pos + 3) / 5 + pos / 5;
        int left = 10 + _WIDTH
                + ((_WIDTH * 3) / 2) * (pos + (pos / 5)
                + ((pos + 3) / 5));
        setBackground(Color.BLACK);
        setBounds(left, 10, _WIDTH, _HEIGHT);
    }

    public int getNote() {
        return note;
    }
}
