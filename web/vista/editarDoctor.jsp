<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrar Hospital</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <h1>Editar Doctor 
                <c:out value="${doctor.nombre}" />
            </h1>
            <table>
                <tr>
                    <td>
                        <a href="adminArticulo?action=index">Ir al menú</a>
                    </td>
                </tr>
            </table>


            <form action="AdminDoctores?action=nuevoDoctor" method="post">

                <input type="text" placeholder="Nombre del doctor" name="nombre" value="<c:out value="${doctor.nombre}" />" />
                <input type="number" placeholder="Salario" name="salario" value="<c:out value="${doctor.salario}" />" />


                <div class="input-field col s12">
                    <select name="nombreEspecialidad">
                        <c:forEach var="especialidad" items="${listaEspecialidad}">
                            <option value="<c:out value="${especialidad.nombre}"/>">
                                <c:out value="${especialidad.nombre}"/>
                            </option>
                        </c:forEach>
                    </select>
                    <label>Especialidad</label>
                </div>
                <label for="idHospital">Id hospital</label>

                <input id="idHospital" type="number" name="idHospital" value="<c:out value="${doctor.idHospital}"/>"/>


                <input type="submit" value="Agregar">

            </form>

        </div>


        <div id="modal1" class="modal">
            <div class="modal-content">
                <h4>Agregar Doctor a este hospital</h4>

                <form action="AdminDoctores?action=nuevoDoctor" method="post">

                    <input type="text" placeholder="Nombre del doctor" name="nombre" value="" />
                    <input type="number" placeholder="Salario" name="salario" value="" />


                    <div class="input-field col s12">
                        <select name="nombreEspecialidad">
                            <c:forEach var="especialidad" items="${listaEspecialidad}">
                                <option value="<c:out value=" ${especialidad.nombre} "/>">
                                    <c:out value="${especialidad.nombre}" />
                                </option>
                            </c:forEach>
                        </select>
                        <label>Especialidad</label>
                    </div>
                    
                    <label for="idHospital">Id hospital</label>

                    <input id="idHospital" type="number" name="idHospital" value="<c:out value=" ${hospital.idHospital} "/>"/>




                    <input type="submit" value="Agregar" />

                </form>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
            </div>
        </div>


        <div class="fixed-action-btn horizontal click-to-toggle">
            <a class="btn-floating btn-large red">
                <i class="fas fa-bars"></i>
            </a>

            <ul>
                <li>
                    <a class="btn-floating red btn modal-trigger tooltipped" data-position="top" data-delay="50" data-tooltip="Agregar doctor a este hospital"
                       data-target="modal1" href="#modal1">
                        <i class="fas fa-hospital"></i>
                    </a>
                </li>
                <li>
                    <a class="btn-floating yellow darken-1 btn modal-trigger tooltipped" data-position="top" data-delay="50" data-tooltip="Agregar enfermo"
                       data-target="modal2" href="#modal2">
                        <i class="fas fa-frown"></i>
                    </a>
                </li>
                <li>
                    <a class="btn-floating green btn modal-trigger tooltipped" data-position="top" data-delay="50" data-tooltip="Agregar especialidad"
                       data-target="modal3" href="#modal3">
                        <i class="fas fa-user-md"></i>
                    </a>
                </li>
            </ul>

        </div>



    </body>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

    <script>
        $(document).ready(function () {
            $('.modal').modal();
            $('select').material_select();

        });
    </script>

    <script>

    </script>

</html>