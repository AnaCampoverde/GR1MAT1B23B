package logica;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import static java.util.List.of;

public class ListaPrestamosTest {
    private static ListaPrestamos claseListaPrestamo;
    private Prestamo prestamo1,prestamo2,prestamo3;
    @Before
    public void setUp(){
        prestamo1 = new Prestamo("001","978-0451524935","202010586","29/11/2023","25/12/2023");
        prestamo2 = new Prestamo("002","978-6070711386","202010586","29/11/2023","25/12/2023");
        prestamo3 = new Prestamo("003","978-0441172719","202010586","29/11/2023","25/12/2023");
    }
    @Test
    public void given_listPrestamo_when_register_then_ok() {
        claseListaPrestamo = new ListaPrestamos();
        claseListaPrestamo.realizarPrestamo(prestamo1);
        claseListaPrestamo.realizarPrestamo(prestamo2);
        claseListaPrestamo.realizarPrestamo(prestamo3);
        List<Prestamo> listaEsperada = of(new Prestamo[]{prestamo1, prestamo2, prestamo3});
        assertEquals(listaEsperada, claseListaPrestamo.getListaPrestamos());
    }

    @Test
    public void given_listPrestamo_when_countID_then_ok() {
        claseListaPrestamo = new ListaPrestamos();
        claseListaPrestamo.realizarPrestamo(prestamo1);
        claseListaPrestamo.realizarPrestamo(prestamo2);
        String idActual = claseListaPrestamo.getNewId();
        assertEquals("003",idActual);
    }
}