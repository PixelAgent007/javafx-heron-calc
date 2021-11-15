package gui;

import javafx.beans.property.*;

import java.math.BigDecimal;

public class Row {
    private final SimpleIntegerProperty schritt;
    private final SimpleObjectProperty<BigDecimal> a;
    private final SimpleObjectProperty<BigDecimal> b;
    private final SimpleIntegerProperty flächeninhalt;

    public Row(int schritt, BigDecimal a, BigDecimal b, int flächeninhalt) {
        this.schritt = new SimpleIntegerProperty(schritt);
        this.a = new SimpleObjectProperty<BigDecimal>(a);
        this.b = new SimpleObjectProperty<BigDecimal>(b);
        this.flächeninhalt = new SimpleIntegerProperty(flächeninhalt);
    }

    public int getSchritt() {
        return schritt.get();
    }

    public BigDecimal getA() {
        return a.get();
    }

    public BigDecimal getB() {
        return b.get();
    }

    public int getFlächeninhalt() {
        return flächeninhalt.get();
    }
}
