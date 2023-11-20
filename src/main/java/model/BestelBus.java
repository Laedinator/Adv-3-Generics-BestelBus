package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 * defines the Bestelbus.
 **/
public class BestelBus<L extends Weegbaar> {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<L> lading;

    public BestelBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadPakket(L stukLading) {
        int gewichtNieuwLading = stukLading.getGewicht();
        if (totaalGewicht + gewichtNieuwLading > maximumGewicht || gewichtNieuwLading < 0) {
            return;
        }
        lading.add(stukLading);
        totaalGewicht += stukLading.getGewicht();
    }

    public List<L> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public Pakket zoekZwaarstePakket() {
        return null;
    }
}
