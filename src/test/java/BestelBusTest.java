import model.BestelBus;
import model.Pakket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 **/
public class BestelBusTest {
    private BestelBus testBus;

    @Test
    public void laadPakketMetNegatieveWaardeWeigeren() {
        maakBus();
        Pakket foutPakket = new Pakket("Mike", "Letter", -3);
        testBus.laadPakket(foutPakket);
        assertEquals(0, testBus.getLading().size());
    }

    @Test
    public void laadZwaarPakket() {
        maakBus();
        Pakket pakket1 = new Pakket("Mike", "Fiets", 25);
        Pakket pakket2 = new Pakket("Aike", "Skateboard", 20);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        assertEquals(1, testBus.getLading().size());
    }

    @Test
    public void testTotaalGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Mike", "Fiets", 20);
        Pakket pakket2 = new Pakket("Aike", "Skateboard", 10);
        Pakket pakket3 = new Pakket("Max", "Texas spel", 9);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        assertEquals(39, testBus.getTotaalGewicht());
    }

    @Test
    public void testTeveelGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Mike", "Fiets", 20);
        Pakket pakket2 = new Pakket("Aike", "Skateboard", 10);
        Pakket pakket3 = new Pakket("Max", "Texas spel", 9);
        Pakket pakket4 = new Pakket("Bert", "Texas spel", 9);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        testBus.laadPakket(pakket4);
        assertEquals(39, testBus.getTotaalGewicht());
    }


    private void maakBus() {
        testBus = new BestelBus<>("Blauwe Bus", 40);
    }
}
