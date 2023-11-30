<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario automático</title>
</head>
<body>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        document.getElementById('prestamo').submit();
    });
</script>

<form id="prestamo" action="realizarPrestamo" method="get">
</form>

</body>
</html>

