<%@ page import="logica.Prestamo" %>
<%@ page import="java.util.List" %>
<%@ page import="logica.ListaPrestamos" %>
<%@ page import="logica.Libro" %>
<%@ page import="logica.ListaLibros" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/realizarPrestamo.css">
    <title>Recibo Prestamo</title>
</head>
<body>

<div class="container">
    <h1>Biblioteca</h1>
    <h2>Recibo de Préstamo</h2>
    <hr>

    <%  List<Prestamo> listaPrestamo = (List) request.getSession().getAttribute("listaPrestamos");
        String id = ListaPrestamos.getLastId();
        Prestamo ultimoPrestamo = new Prestamo();
        for (Prestamo prestamo : listaPrestamo) {
            if(prestamo.getIdPrestamo().equals(id)){
                ultimoPrestamo = prestamo;
            }
        }

        Libro libro = (Libro) request.getSession().getAttribute("libroPrestado");
    %>


    <p>Número de recibo: <%= ultimoPrestamo.getIdPrestamo() %></p>

    <br>
    <br>
    <h3>Datos Estudiante:</h3>
    <p>Número único: <%= ultimoPrestamo.getIdUsuario() %></p>

    <br>
    <br>
    <h3>Datos Libro:</h3>
    <p>ISBN: <%= libro.getIsbn() %></p>
    <p>Autor: <%= libro.getAutor() %></p>
    <p>Título: <%= libro.getTitulo() %></p>
    <p>Genero: <%= libro.getGenero() %></p>

    <br>
    <hr>

    <br>
    <p>Fecha de préstamo: <%= ultimoPrestamo.getFechaPrestamo() %></p>
    <p>Fecha estimada de devolución: <%= ultimoPrestamo.getFechaDevolucion() %></p>
</div>

</body>
</html>