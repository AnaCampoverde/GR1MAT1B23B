package logica;

import java.util.ArrayList;
import java.util.List;

public class ListaPrestamos {

    List<Prestamo> listaPrestamos;
    ListaLibros listaLibros;

    public ListaPrestamos() {
        this.listaPrestamos = new ArrayList<Prestamo>();
        this.listaLibros = new ListaLibros();
    }

    public boolean realizarPrestamo(Prestamo prestamo){
        listaPrestamos.add(prestamo);
        listaLibros.cambiarDisponibilidadLibro(prestamo.getIsbn());
        return false;
    }

    public String getNewId() {
        // Verificar si la lista está vacía
        if (lista == null || lista.isEmpty()) {
            return "001";
        } else {
            // Obtener el último elemento de la lista
            String ultimoElemento = lista.get(lista.size() - 1);

            // Convertir a entero y aumentar en uno
            int numeroSiguiente = Integer.parseInt(ultimoElemento) + 1;

            // Formatear el resultado y devolverlo
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
