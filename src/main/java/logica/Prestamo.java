package logica;

import java.util.Date;

public class Prestamo {

    private String idPrestamo, isbn, idUsuario, fechaPrestamo, fechaDevolucion;

    public Prestamo(String idPrestamo, String isbn, String idUsuario, String fechaPrestamo, String fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.isbn = isbn;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
