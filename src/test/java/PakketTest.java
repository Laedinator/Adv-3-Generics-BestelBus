import model.Pakket;
import model.PakkettenBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PakketTest {
    private PakkettenBus testBus;

    @Test
    public void laadPakketMetNegatieveWaardeWeigeren() {
        maakBus();
        Pakket foutPakket = new Pakket("Aike", "Texas spel", -3);
        testBus.laadPakket(foutPakket);
        assertEquals(0, testBus.getLading().size());
    }

    @Test
    public void laadZwaarPakket() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 20);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 25);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        assertEquals(1, testBus.getLading().size());
    }

    @Test
    public void testTotaalGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 10);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 15);
        Pakket pakket3 = new Pakket("Aike", "Texas spel", 12);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        assertEquals(37, testBus.getTotaalGewicht());
    }

    @Test
    public void testTeveelGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 10);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 15);
        Pakket pakket3 = new Pakket("Aike", "Texas spel", 12);
        Pakket pakket4 = new Pakket("Aike", "Texas spel", 12);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        testBus.laadPakket(pakket4);
        assertEquals(37, testBus.getTotaalGewicht());
    }

    @Test
    public void testZoekZwaarstePakket() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 10);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 15);
        Pakket pakket3 = new Pakket("Aike", "Texas spel", 12);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        assertEquals(pakket2, testBus.zoekZwaarstePakket());
    }
    @Test
    public void testZoekZwaarstePakketMetGelijkeGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel 1", 15);
        Pakket pakket2 = new Pakket("Aike", "Texas spel 2", 9);
        Pakket pakket3 = new Pakket("Aike", "Texas spel", 15);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        assertEquals(pakket3, testBus.zoekZwaarstePakket());
    }


    private void maakBus() {
        testBus = new PakkettenBus("Rode bus", 40);
    }

}
