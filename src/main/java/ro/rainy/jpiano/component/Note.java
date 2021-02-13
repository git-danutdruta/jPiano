package ro.rainy.jpiano.component;

/**
 * @project: jPiano
 * @author: daniel
 * @time: 12/02/2021  18:43
 */
public enum Note {
    C("C", "DO"),
    D("D", "RE"),
    E("E", "MI"),
    F("F", "FA"),
    G("G", "SOL"),
    A("A", "LA"),
    B("B", "SI"),
    EMPTY("","");

    private String symbol;
    private String name;

    Note(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}