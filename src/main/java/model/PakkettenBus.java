package model;

import java.util.ArrayList;
import java.util.List;

public class PakkettenBus {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<Pakket> lading;

    public PakkettenBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadPakket(Pakket pakket) {
        int gewichtPakket = pakket.getGewicht();
        if (totaalGewicht + gewichtPakket > maximumGewicht || gewichtPakket < 0) {
            return;
        }
        lading.add(pakket);
        totaalGewicht += pakket.getGewicht();
    }

    public List<Pakket> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public Pakket zoekZwaarstePakket() {
        return null;
    }

}
