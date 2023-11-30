package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.Libro;
import logica.ListaLibros;
import logica.ListaPrestamos;
import logica.Prestamo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "BuscarLibrosServlet", urlPatterns = {"/buscarLibros"})
public class BuscarLibrosServlet extends HttpServlet {

    ListaLibros listaLibros;

    @Override
    public void init() throws ServletException {
        listaLibros = RealizarPrestamoServlet.getListaLibros();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        // En tu servlet o controlador
        String parametroBusqueda = request.getParameter("parametroBusqueda");
        String busqueda = request.getParameter("busqueda");

        List<Libro> librosFiltrados = listaLibros.filtrarListaPorParametro(parametroBusqueda, busqueda);
        sesion.setAttribute("listaLibros", librosFiltrados);
        response.sendRedirect("RealizarPrestamo.jsp");
    }
}

