package ro.rainy.jpiano;

import javax.swing.*;

public class Starter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Piano()::createAndShowGUI);
    }
}
