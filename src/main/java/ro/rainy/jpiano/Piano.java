package ro.rainy.jpiano;

import ro.rainy.jpiano.component.BlackKey;
import ro.rainy.jpiano.component.Key;
import ro.rainy.jpiano.component.WhiteKey;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @project: jPiano
 * @author: daniel
 * @time: 29/01/2021  22:33
 */

public class Piano implements MouseListener {
    final int OCTAVES = 4;

    private WhiteKey[] whites = new WhiteKey[7 * OCTAVES + 1];
    private BlackKey[] blacks = new BlackKey[5 * OCTAVES];

    MidiChannel channel;

    public Piano() {

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            synth.loadAllInstruments(synth.getDefaultSoundbank());
            Instrument[] insts = synth.getLoadedInstruments();
            MidiChannel channels[] = synth.getChannels();
            for (int i = 0; i < channels.length; i++) {
                if (channels[i] != null) {
                    channel = channels[i];
                    break;
                }
            }

            for (int i = 0; i < insts.length; i++) {
                if (insts[i].toString()
                        .startsWith("Instrument MidiPiano")) {
                    channel.programChange(i);
                    break;
                }
            }
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void mousePressed(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOn(key.getNote(), 127);
    }

    public void mouseReleased(MouseEvent e) {
        Key key = (Key) e.getSource();
        channel.noteOff(key.getNote());
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void createAndShowGUI() {

        JPanel contentPane = new JPanel(null) {
            @Override
            public Dimension getPreferredSize() {
                int count = getComponentCount();
                Component last = getComponent(count - 1);
                Rectangle bounds = last.getBounds();
                int width = 10 + bounds.x + bounds.width;
                int height = 10 + bounds.y + bounds.height;

                return new Dimension(width, height);
            }

            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };


        for (int i = 0; i < blacks.length; i++) {
            blacks[i] = new BlackKey(i);
            contentPane.add(blacks[i]);
            blacks[i].addMouseListener(this);
        }
        for (int i = 0; i < whites.length; i++) {
            whites[i] = new WhiteKey(i);
            contentPane.add(whites[i]);
            whites[i].addMouseListener(this);
        }

        JFrame frame = new JFrame("Midi Piano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(contentPane));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}