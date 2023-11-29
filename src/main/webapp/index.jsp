<%@ page import="logica.*" %>
<%@ page import="java.util.List" %>
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
    <p>Seleccione el estudiante registrado y los libros disponibles para realizar un préstamo.</p>

    <div class="tables-container">
        <table class="books-table">
        </table>
    </div>

    <tr>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
        <th colspan="2">&nbsp;&nbsp;&nbsp;</th>
    </tr>

    <div class="formulario">
        <form action="solicitarPrestamo" method="post">
            <label for="idLibro">&nbsp;&nbsp;&nbsp;ID del logica.Libro:</label>
            <input type="text" id="idLibro" name="idLibro" placeholder="Ingrese el ID aquí">

            <button type="submit">Aceptar</button>
        </form>
    </div>

    <table class="loans-table">
    </table>

</div>
</body>
</html>

