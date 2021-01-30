package ro.rainy.jpiano.component;

/**
 * @project: jPiano
 * @author: daniel
 * @time: 30/01/2021  22:36
 */
public interface Key {
    int _WIDTH = 16;
    int _HEIGHT = (_WIDTH * 9) / 2;
    int baseNote = 48;
    int getNote();
}