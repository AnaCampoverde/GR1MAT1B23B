package logica;

import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListaLibrosTest {
    private ListaLibros claseListaLibros;
    private List<Libro> listaLibros;

    @Before
    public void setUp() {
        claseListaLibros = new ListaLibros();
        listaLibros = new ArrayList<Libro>();
        listaLibros.add(new Libro("libro1", "autor1", "genero1", "isbn1", true));
        listaLibros.add(new Libro("libro2", "autor2", "genero2", "isbn2", true));
        listaLibros.add(new Libro("libro3", "autor3", "genero3", "isbn3", false));
        listaLibros.add(new Libro("libro4", "autor4", "genero4", "isbn4", true));
        listaLibros.add(new Libro("libro5", "autor5", "genero5", "isbn5", true));
        claseListaLibros.setListaLibros(listaLibros);
    }

    @Test
    public void given_bookList_when_verifyAvailabilityBooks_then_true(){
        List<Libro> listaLibrosDisponibles = claseListaLibros.verificarLibrosDisponibles();
        boolean valido = true;

        for (Libro libro : listaLibrosDisponibles) {
            System.out.println(libro.getTitulo() + " Disponiblidad:" + libro.isDisponibilidad());
                if (!libro.isDisponibilidad()) {
                valido = false;
            }
        }
        assertTrue(valido);
    }

    @Test
    public void given_bookList_when_changeBookAvailability_then_true(){
        String isbn = "isbn1";
        System.out.println("Disponibilidad antes: " + claseListaLibros.buscarLibro(isbn).isDisponibilidad());
        boolean valor = claseListaLibros.cambiarDisponibilidadLibro(isbn);
        System.out.println("Disponibilidad después: " + claseListaLibros.buscarLibro(isbn).isDisponibilidad());
        assertEquals(false, valor);
    }

}