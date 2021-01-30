package ro.rainy.jpiano.component;

import javax.swing.*;

/**
 * @project: jPiano
 * @author: daniel
 * @time: 29/01/2021  22:33
 */
public class WhiteKey extends JButton implements Key {
    static int WWD = (_WIDTH * 3) / 2;
    static int WHT = (_HEIGHT * 3) / 2;
    final int note;

    public WhiteKey(int pos) {

        note = baseNote + 2 * pos
                - (pos + 4) / 7
                - pos / 7;
        int left = 10 + WWD * pos;
        setBounds(left, 10, WWD, WHT);
    }

    @Override
    public int getNote() {
        return note;
    }
}