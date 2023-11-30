<%@ page import="logica.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/realizarPrestamo.css">
    <title>Solicitar Préstamo</title>
</head>

<body>
<div class="container">
    <h1>Solicitar Préstamo</h1>
    <p>Realice la búsqueda del libro que desea pedir prestado e ingrese el código ISBN para solicitarlo.</p>

    <div class="formulario">
        <form action="buscarLibro" method="post">
            <label for="parametroBusqueda">&nbsp;&nbsp;&nbsp;Buscar libros:</label>
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
                <th>Título</th>
                <th>Autor</th>
                <th>Género</th>
                <th>ISBN</th>
                <th>Disponibilidad</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Libro> libros = (List) request.getSession().getAttribute("listaLibros");
                if(libros == null) libros = new ArrayList<>();
                //ListaLibros lib = new ListaLibros();
                //List<Libro> libros = lib.getListaLibros();
                String disponibilidad;
                for (Libro libro : libros) {
                    disponibilidad = libro.isDisponibilidad() ? "Disponible" : "Prestado";
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
        <form action="realizarPrestamo" method="post" onsubmit="return abrirNuevaVentana()">
            <label for="isbnLibro">&nbsp;&nbsp;&nbsp;ISBN del libro a pedir:</label>
            <input type="text" id="isbnLibro" name="isbnLibro" placeholder="Ingrese el ISBN aquí">

            <button type="submit">Aceptar</button>
        </form>
    </div>

    <table class="loans-table">
        <!-- Tabla de Préstamos -->
        <caption>Historial de Transacciones</caption>
        <thead>
        <tr>
            <th>ID Prestramo</th>
            <th>Código Estudiante</th>
            <th>ISBN Libro</th>
            <th>Fecha de Préstamo</th>
            <th>Fecha de Devolución</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Prestamo> listaPrestamo = (List<Prestamo>) request.getSession().getAttribute("listaPrestamos");
            if(listaPrestamo == null) listaPrestamo = new ArrayList<>();
            for (Prestamo prestamo : listaPrestamo) {
        %>
        <tr>
            <td><%=prestamo.getIdPrestamo()%>
            </td>
            <td><%=prestamo.getIdUsuario()%>
            </td>
            <td><%=prestamo.getIsbn()%>
            </td>
            <td><%=prestamo.getFechaPrestamo()%>
            </td>
            <td><%=prestamo.getFechaDevolucion()%>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>

<script>
    function abrirNuevaVentana() {
        var isbn = document.getElementById('isbnLibro').value;
        var url = "reciboPrestamo.jsp?isbn=" + isbn;
        window.open(url, "_blank", "width=600,height=400");
        return false;
    }
</script>
</html>

