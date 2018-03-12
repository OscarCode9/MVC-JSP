<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Administrar Artículos</title>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
            <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
        </head>

        <body>

            <div class="container">

                <h1>Lista de Hospitales</h1>
                <table>
                    <tr>
                        <td>
                            <a href="adminArticulo?action=index">Ir al menú</a>
                        </td>
                    </tr>
                </table>

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
                        <c:forEach var="hospital" items="${lista}">

                            <tr>
                                
                                <td>
                                    <c:out value="${hospital.idHospital}" />
                                    
                                </td>

                                <td>
                                    <c:out value="${hospital.nombre}" />
                                </td>
                                <td>
                                    <c:out value="${hospital.direccion}" />
                                </td>
                                <td>
                                    <c:out value="${hospital.telefono}" />
                                </td>

                                <td>
                                    
                                    <a href="AdminHospitales?action=eliminar&id=<c:out value="${hospital.idHospital}"/>"><i class="fas fa-trash-alt"></i></a>
                                </td>
                                <td>
                                    <a href="AdminHospitales?action=showedit&id=<c:out value="${hospital.idHospital}" />"><i class="fas fa-edit"></i></a>
                                </td>

                            </tr>

                        </c:forEach>

                        <tr>
                            <td> Agregar nuevo hospital</td>
                        </tr>
                        <tr>
                            <form action="AdminHospitales?action=nuevoHospital" method="post">


                                <td>
                                    <input type="text" placeholder="Nombre" name="nombre" />
                                </td>


                                <td>
                                    <input type="text" placeholder="direccion" name="direccion" />
                                </td>

                                <td>
                                    <input type="text" placeholder="telefono" name="telefono" />
                                </td>


                                <td>
                                    <input type="submit" value="Agregar">
                                </td>

                            </form>


                        </tr>

                    </tbody>

                </table>


            </div>



        </body>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

        <script>
        
        </script>

        </html>