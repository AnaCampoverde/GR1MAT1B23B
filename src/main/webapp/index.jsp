<%@ page import="logica.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/solicitarPrestamo.css">
    <title>Solicitar Préstamo</title>
</head>

<body>
<div class="container">
    <h1>Solicitar Préstamo</h1>
    <p>Realice la búsqueda del libro que desea pedir prestado e ingrese el código ISBN para solicitarlo.</p>

    <div class="formulario">
        <form action="buscarLibro" method="post">
            <label for="parametroBusqueda">&nbsp;&nbsp;&nbsp;Buscar lirbos:</label>
            <select name="parametroBusqueda" id="parametroBusqueda">
                <option value="autor">Autor</option>
                <option value="titulo">Título</option>
                <option value="genero">Género</option>
            </select>
            <input type="text" id="busqueda" name="busqueda" placeholder="Ingrese la búsqueda aquí">

            <button type="submit">Buscar</button>
        </form>

    </div>

    <div class="tables-container">

        <table class="books-table">
            <!-- Tabla de Libros -->
            <caption>Libros</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Género</th>
                <th>Disponibilidad</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Libro> listaLibros = new ArrayList<Libro>();
                listaLibros = Libro.verificarLibrosDisponibles(listaLibros);
                String disponibilidad;
                for (Libro libro : listaLibros) {
                    disponibilidad = libro.isDisponibilidad() ? "Si" : "No";
            %>
            <tr>
                <td><%=libro.getTitulo()%>
                </td>
                <td><%=libro.getAutor()%>
                </td>
                <td><%=libro.getGenero()%>
                </td>
                <td><%=libro.getIsbn()%>
                </td>
                <td><%=disponibilidad%>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </div>

    <tr>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
    </tr>

    <div class="formulario">
        <form action="solicitarPrestamo" method="post">
            <label for="idLibro">&nbsp;&nbsp;&nbsp;ISBN del libro a pedir:</label>
            <input type="text" id="idLibro" name="idLibro" placeholder="Ingrese el ID aquí">

            <button type="submit">Aceptar</button>
        </form>
    </div>

    <table class="loans-table">
        <!-- Tabla de Préstamos -->
        <caption>Prestamos</caption>
        <thead>
        <tr>
            <th>Cédula Estudiante</th>
            <th>ID Libro</th>
            <th>Fecha de Préstamo</th>
            <th>Fecha de Devolución</th>
            <th>Multa</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Prestamo> listaPrestamo = new ArrayList<>();
            for (Prestamo prestamo : listaPrestamo) {
        %>
        <tr>
            <td><%="usuario"%>
            </td>
            <td><%="libro"%>
            </td>
            <td><%="fecha prestamo"%>
            </td>
            <td><%="fecha devolucion"%>
            </td>
            <td><%="..."%>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>
</html>
