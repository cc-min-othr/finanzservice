package entity;

import java.util.Date;
import java.util.Set;

public class Transaktion {
    private String transaktionsId;
    private String text;
    private Date datum;
    private Set<Buchung> buchungspositionen;

    public String getTransaktionsId() {
        return transaktionsId;
    }

    public void setTransaktionsId(String transaktionsId) {
        this.transaktionsId = transaktionsId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Set<Buchung> getBuchungspositionen() {
        return buchungspositionen;
    }

    public void setBuchungspositionen(Set<Buchung> buchungspositionen) {
        this.buchungspositionen = buchungspositionen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaktion that = (Transaktion) o;

        return transaktionsId.equals(that.transaktionsId);
    }

    @Override
    public int hashCode() {
        return transaktionsId.hashCode();
    }
}
