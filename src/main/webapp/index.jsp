
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Gestion"%>
<%
    List<Gestion> gestion = (List<Gestion>)request.getAttribute("gestion");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        .container {
  position: relative;
  width: 100px;
  height: 100px;
  background-color: #f9f9f9;
}
/* Estilo para el texto */
.text {
  position: absolute;
  top: 30px;
  left: 350px;
  font-size: 20px;
  color: #333;
}
  .texto-encuadrado {
  border: 1px solid black;
  padding: 10px;
} 
body {
  font-family: "Helvetica Neue", Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
  margin: 0;
  padding: 0;
  background-color: #f9f9f9;
  color: #333;
}

/* Estilo para el encabezado */
header {
  background-color: #333;
  color: #fff;
  padding: 20px;
}

/* Estilo para el título principal */
h1 {
  font-size: 36px;
  font-weight: bold;
  margin: 0;
}
/* Estilo para la tabla */
table {
  width: 50%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

/* Estilo para las celdas encabezado de la tabla */
th {
  background-color: #333;
  color: #fff;
  padding: 10px;
}

/* Estilo para las celdas de datos de la tabla */
td {
  padding: 10px;
  border-bottom: 1px solid #ccc;
}

/* Estilo alternativo para las filas de la tabla */
tr:nth-child(even) {
  background-color: #f9f9f9;
}

/* Estilo para el enlace dentro de una celda de la tabla */
td a {
  color: #337ab7;
  text-decoration: none;
}

td a:hover {
  color: #23527c;
}

/* Estilo para la clase destacada en una celda de la tabla */
td.highlight {
  font-weight: bold;
}
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><center>
       
<div class="texto-encuadrado">
    SEGUNDO PARCIAL TEM-742 <br>
  Nombre: Janneth Choque Quispe <br>
  Carnet: 9952461 <br>
</div>
        
        <h1>Gestion de productos</h1></center>
    <div class="container">
  <p class="text"><a href="Inicio?action=add">Nuevo</a></p>
</div>
        <center><table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${gestion}">
              <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.cantidad}</td>
                <td>${item.precio}</td>
                <td>${item.categoria}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Inicio?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>              
            </c:forEach>
            </table></center>
    </body>
</html>
