package ro.rainy.jpiano.component;

import javax.swing.*;
import java.awt.*;

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
        System.out.println(note);
        setBounds(left, 10, WWD, WHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawString(getNotation().getSymbol(), 8, 85);
        g2d.drawString(getNotation().getName(), 3, 100);
    }

    private Note getNotation() {
        if (note % 12 == 0) {
            return Note.C;
        } else if (note % 12 == 2) {
            return Note.D;
        } else if (note % 12 == 4) {
            return Note.E;
        } else if (note % 12 == 5) {
            return Note.F;
        } else if (note % 12 == 7) {
            return Note.G;
        } else if (note % 12 == 9) {
            return Note.A;
        } else if (note % 12 == 11) {
            return Note.B;
        }
        return Note.EMPTY;
    }

    @Override
    public int getNote() {
        return note;
    }
}