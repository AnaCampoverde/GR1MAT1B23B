package logica;

import java.util.ArrayList;
import java.util.List;

public class ListaPrestamos {

    private static List<Prestamo> listaPrestamos;
    private static ListaLibros listaLibros;

    public ListaPrestamos() {
        this.listaPrestamos = new ArrayList<Prestamo>();
        this.listaLibros = new ListaLibros();
    }

    public static boolean realizarPrestamo(Prestamo prestamo){
        listaPrestamos.add(prestamo);
        listaLibros.cambiarDisponibilidadLibro(prestamo.getIsbn());
        return false;
    }

    public static String getNewId() {
        // Verificar si la lista está vacía
        if (listaPrestamos == null || listaPrestamos.isEmpty()) {
            return "001";
        } else {
            // Obtener el último elemento de la lista
            Prestamo ultimoElemento = listaPrestamos.get(listaPrestamos.size() - 1);

            int numeroSiguiente = Integer.parseInt(ultimoElemento.getIdPrestamo()) + 1;

            return String.format("%03d", numeroSiguiente);
        }
    }


    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
}
