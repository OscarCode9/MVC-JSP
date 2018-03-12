<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Actualizar Art�culo</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    </head>
    <body>
        <h1>Actualizar Hospital</h1>
        <form action="AdminEnfermos?action=editar" method="post" >
            <table class="highlight" border="1" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th colspan=2>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                            <tr>
                                
                                <td>
                                    <input type="text" placeholder="id" name="id" value="<c:out value="${hospital.idHospital}" />" />
                                </td>
                                
                                <td>
                                    <input type="text" placeholder="Nombre" name="nombre" value="<c:out value="${hospital.nombre}" />" />
                                </td>


                                <td>
                                    <input type="text" placeholder="direccion" name="direccion" value="<c:out value="${hospital.direccion}" />" />
                                </td>

                                <td>
                                    <input type="text" placeholder="telefono" name="telefono" value="<c:out value="${hospital.telefono}" />"/>
                                </td>
                                
                                <td>
                                    <input type="submit" name="registrar" value="Guardar">
                                </td>
                                
                            </tr>

                    </tbody>

                </table>


            
        </form>

    </body>
</html>