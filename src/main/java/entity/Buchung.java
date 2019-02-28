package entity;

import javax.xml.bind.annotation.XmlTransient;

public class Buchung {
    private long buchungsNr;
    private long betrag;
    @XmlTransient
    private transient Transaktion transaktion;
    // private Konto konto; // Rekursive Abhängigkeiten!!
    private long kontoNr;

    public long getBuchungsNr() {
        return buchungsNr;
    }

    public void setBuchungsNr(long buchungsNr) {
        this.buchungsNr = buchungsNr;
    }

    public long getBetrag() {
        return betrag;
    }

    public void setBetrag(long betrag) {
        this.betrag = betrag;
    }

    public Transaktion getTransaktion() {
        return transaktion;
    }

    public void setTransaktion(Transaktion transaktion) {
        this.transaktion = transaktion;
    }

    public long getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(long kontoNr) {
        this.kontoNr = kontoNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buchung buchung = (Buchung) o;

        return buchungsNr == buchung.buchungsNr;
    }

    @Override
    public int hashCode() {
        return (int) (buchungsNr ^ (buchungsNr >>> 32));
    }
}
