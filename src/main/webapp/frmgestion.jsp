<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Gestion"%>
<%
    Gestion gestion = (Gestion) request.getAttribute("gestion");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><style>
 
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
    <body>
        <h1>
                 <c:if test="${gestion.id==0}">
                     Nuevo Registro
                 </c:if>  
                  <c:if test="${gestion.id !=0}">
                     Editar Registro
                 </c:if>  
             </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${gestion.id}" />
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${gestion.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="${gestion.cantidad}" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="${gestion.precio}" /></td>
                </tr>
                
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="${gestion.categoria}" /></td>
                </tr>
                
                
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
