package service;

import entity.Buchung;
import entity.Konto;
import entity.Student;
import entity.Transaktion;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("finanzservice")
public class FinanceService {

    private static volatile long lastId = 1;

    // Rudimentäre in-memory-Speicherung
    private static final Map<Long, Konto> konten = new HashMap<>();
    private static final Map<String, Transaktion> transaktionen = new HashMap<>();
    private static final Map<Long, Buchung> buchungen = new HashMap<>();

    @GET
    @Path("student")
    public List<Student> suchen(@QueryParam("from") int start, @QueryParam("to") int ende) {
        List<Student> suchergebnis = new LinkedList<>();

        // Queryparameter auswerten
        // if(start == 0 && ende == 0) und so weiter ...


        // Suchen, Liste befüllen
        // suchergebnis.add(...);

        // und zurückgeben:
        return suchergebnis;
    }

    @POST
    @Path("konto")
    public Konto anlegen(Konto neu) {
        Konto konto = konten.get(neu.getKontoNr());
        if(konto != null)
            throw new FinanzException(Response.Status.BAD_REQUEST, "Konto Nr. " + neu.getKontoNr() + " existiert bereits");
        neu.setStand(0);
        neu.setBezeichnung(neu.getBezeichnung().toUpperCase());
        konten.put(neu.getKontoNr(), neu);
        return neu;
    }

    @GET
    @Path("konto")
    public Collection<Konto> leseAlleKonten() {
        return konten.values();
    }

    @GET
    @Path("konto/{kontonr}")
    public Konto leseKontoDetails(@PathParam("kontonr") long knr) {
        Konto konto = konten.get(knr);
        if(konto == null)
            throw new FinanzException(Response.Status.NOT_FOUND, "Konto Nr. " + knr + " existiert nicht");
        else
            return konto;
    }

    @POST
    @Path("transaktion")
    public Transaktion buchen(Transaktion vorgang) {
        vorgang.setTransaktionsId(UUID.randomUUID().toString());
        vorgang.setDatum(new Date());
        System.out.println("ANZAHL: " + vorgang.getBuchungspositionen().size());
        System.out.println(Arrays.toString(vorgang.getBuchungspositionen().toArray()));
        for(Buchung buchung : vorgang.getBuchungspositionen()) {
            buchung.setBuchungsNr(lastId++);
            buchung.setTransaktion(vorgang);
            buchungen.put(buchung.getBuchungsNr(), buchung);
            Konto konto = leseKontoDetails(buchung.getKontoNr());
            konto.setStand(konto.getStand() + buchung.getBetrag());

            // TODO:
            System.out.print("Stand von: " + buchung.getKontoNr());
            System.out.println(konten.get(buchung.getKontoNr()).getStand());
        }
        transaktionen.put(vorgang.getTransaktionsId(), vorgang);
        return vorgang;
    }

    @GET
    @Path("transaktion/{id}")
    public Transaktion leseTransaktion(@PathParam("id") String transaktionsId) {
        Transaktion transaktion = transaktionen.get(transaktionsId);
        if(transaktion == null)
            throw new FinanzException(Response.Status.NOT_FOUND, "Transaktion mit ID " + transaktionsId + " existiert nicht");
        else
            return transaktion;
    }

    @GET
    @Path("transaktion")
    public Collection<Transaktion> zeigeAlleTransaktionen() {
        return transaktionen.values();
    }

}
