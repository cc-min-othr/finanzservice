package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Konto {
    private long kontoNr;
    private String bezeichnung;
    private long stand;

    public long getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(long kontoNr) {
        this.kontoNr = kontoNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public long getStand() {
        return stand;
    }

    public void setStand(long stand) {
        this.stand = stand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Konto konto = (Konto) o;

        return kontoNr == konto.kontoNr;
    }

    @Override
    public int hashCode() {
        return (int) (kontoNr ^ (kontoNr >>> 32));
    }
}
