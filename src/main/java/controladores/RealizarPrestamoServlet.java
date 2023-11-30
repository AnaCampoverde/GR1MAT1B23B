package controladores;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import logica.ListaLibros;
import logica.Libro;
import logica.ListaPrestamos;
import logica.Prestamo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "RealizarPrestamoServlet", urlPatterns = {"/realizarPrestamo"})
public class RealizarPrestamoServlet extends HttpServlet {
    private ListaLibros listaLibros ;
    private ListaPrestamos listaPrestamos;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void init() {
        listaLibros = new ListaLibros();
        listaPrestamos = new ListaPrestamos();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = req.getSession();

        List<Libro> listaLibrosDisponibles = listaLibros.verificarLibrosDisponibles();
        List<Prestamo> presamos = (List<Prestamo>) sesion.getAttribute("listaPrestamo");

        sesion.setAttribute("listaLibros", listaLibrosDisponibles);

        response.sendRedirect("RealizarPrestamo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuario = "202010586";
        String isbn = request.getParameter("isbnLibro");
        HttpSession session = request.getSession();

        if (!listaLibros.validadIDLibro(isbn)) {
            session.setAttribute("errorMensaje", "Error: ID de libro inválido.");
            response.sendRedirect("RealizarPrestamo.jsp");
        }
        else if (!listaLibros.cambiarDisponibilidadLibro(isbn)){
            session.setAttribute("errorMensaje", "Error: No se pudo cambiar la disponibilidad.");
            response.sendRedirect("RealizarPrestamo.jsp");
        }
        else {

            session.setAttribute("errorMensaje", null);
            LocalDateTime fechaPrestamo = LocalDateTime.now();
            LocalDateTime fechaDevolucion = fechaPrestamo.plusDays(15);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaPrestamoFormateada = fechaPrestamo.format(formato);
            String fechaDevolucionFormateda = fechaDevolucion.format(formato);
            String id = ListaPrestamos.getNewId();
            Prestamo prestamo = new Prestamo(id, isbn, idUsuario, fechaPrestamoFormateada, fechaDevolucionFormateda);
            if (listaPrestamos.realizarPrestamo(prestamo)) {
                session.setAttribute("listaPrestamo", listaPrestamos.getListaPrestamos());
                doGet(request, response);
            }
        }
    }
}