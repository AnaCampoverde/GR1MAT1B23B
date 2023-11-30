package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ListaLibros {

    private List<Libro> listaLibros;

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ListaLibros() {
        listaLibros = new ArrayList<Libro>();
        listaLibros.add(new Libro("1984", "George Orwell", "Ficción",
                "978-0451524935", true));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "Ficción",
                "978-6070711386", true));
        listaLibros.add(new Libro("Dune", "Frank Herbert", "Ciencia Ficción",
                "978-0441172719", true));
        listaLibros.add(new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasía",
                "978-0261102385", true));
        listaLibros.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía",
                "978-8478884455", true));
        listaLibros.add(new Libro("Sapiens: De animales a dioses", "Yuval Noah Harari", "No Ficción",
                "978-8499924217", true));
        listaLibros.add(new Libro("Neuromante", "William Gibson", "Ciencia Ficción",
                "978-8498009162", true));
        listaLibros.add(new Libro("Breve historia del tiempo", "Stephen Hawking", "No Ficción",
                "978-6073111398", true));
        listaLibros.add(new Libro("El nombre del viento", "Patrick Rothfuss", "Fantasía",
                "978-8499082479", true));
    }

    public List<Libro> verificarLibrosDisponibles() {
        List<Libro> librosValidos = new ArrayList<>();

        for (Libro libro : this.listaLibros) {
            if (libro.isDisponibilidad()) {
                librosValidos.add(libro);
            }
        }
        return librosValidos;
    }

    public boolean cambiarDisponibilidadLibro(String isbn) {
        for (Libro libro : this.listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setDisponibilidad(!libro.isDisponibilidad());
                return libro.isDisponibilidad();
            }
        }
        return false;
    }

    public boolean validadIDLibro(String isbn) {
        for (Libro libro : this.listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public Libro buscarLibro(String parametro, String busqueda) {

        switch (parametro) {
            case "autor": {
                for (Libro libro : verificarLibrosDisponibles()) {
                    if (libro.getAutor().equals(busqueda)) {
                        return libro;
                    }
                }
            }
            case "titulo": {
                for (Libro libro : verificarLibrosDisponibles()) {
                    if (libro.getTitulo().equals(busqueda)) {
                        return libro;
                    }
                }
            }
            case "genero": {
                for (Libro libro : verificarLibrosDisponibles()) {
                    if (libro.getGenero().equals(busqueda)) {
                        return libro;
                    }
                }
            }
            case "isbn": {
                for (Libro libro : verificarLibrosDisponibles()) {
                    if (libro.getIsbn().equals(busqueda)) {
                        return libro;
                    }
                }
            }
        }
        return null;
    }

    public List<Libro> filtrarListaPorParametro(String parametro, String busqueda) {
        List<Libro> listaFiltrada = new ArrayList<Libro>();
        switch (parametro) {
            case "autor": {
                for (Libro libro : this.listaLibros) {
                    if (libro.getAutor().toLowerCase().contains(busqueda.toLowerCase())) {
                        listaFiltrada.add(libro);
                    }
                }
                break;
            }
            case "titulo": {
                for (Libro libro : this.listaLibros) {
                    if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                        listaFiltrada.add(libro);
                    }
                }
                break;
            }
            case "genero": {
                for (Libro libro : this.listaLibros) {
                    if (libro.getGenero().toLowerCase().contains(busqueda.toLowerCase())) {
                        listaFiltrada.add(libro);
                    }
                }
                break;
            }
        }
        return ordenarListaPorTitulo(listaFiltrada);
    }

    private List<Libro> ordenarListaPorTitulo(List<Libro> lista) {
        Collections.sort(lista, Comparator.comparing(Libro::getTitulo));
        return lista;
    }
}