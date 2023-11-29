package controladores;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import logica.ListaLibros;
import logica.Libro;
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
    private ListaLibros listaLibros = new ListaLibros();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        List<Libro> listaLibrosDisponibles = listaLibros.verificarLibrosDisponibles();

        HttpSession sesion = req.getSession();
        sesion.setAttribute("listaLibros", listaLibrosDisponibles);

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuario = "202010586";
        String isbn = request.getParameter("isbn");
        HttpSession session = request.getSession();

        if (!listaLibros.validadIDLibro(isbn)) {
            session.setAttribute("errorMensaje", "Error: ID de libro inválido.");
            response.sendRedirect("index.jsp");
        }
        else if (!listaLibros.cambiarDisponibilidadLibro(isbn)){
            session.setAttribute("errorMensaje", "Error: No se pudo cambiar la disponibilidad.");
            response.sendRedirect("index.jsp");
        }
        else {

            session.setAttribute("errorMensaje", null);
            LocalDateTime fechaPrestamo = LocalDateTime.now();
            LocalDateTime fechaDevolucion = fechaPrestamo.plusDays(15);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaPrestamoFormateada = fechaPrestamo.format(formato);
            String fechaDevolucionFormateda = fechaDevolucion.format(formato);
            Prestamo prestamo = new Prestamo("");
            doGet(request, response);
        }
    }
}