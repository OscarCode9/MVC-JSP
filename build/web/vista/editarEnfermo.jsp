<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE >
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Art�culos Java Web JSP y Servlet</title>
        <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    </head>

    <style>
        .side-nav-app {
            position: fixed;
            width: 200px;
        }

        .row-home {
            padding-left: 200px;
        }

        .collection {
            border: 1px solid #e0e0e0;
            border-radius: 2px;
            overflow: hidden;
            position: relative;
        }
    </style>

    <body>



        <div id="slide-out" class="side-nav-app ">
            <div class="collection">
                <a href="#!" class="collection-item active">Hospitales</a>
                <a href="AdminEnfermos?action=mostrar" class="collection-item ">Enfermos</a>
                <a href="#!" class="collection-item">Especialidades</a>
            </div>
        </div>

        <main>
            <div className="row row-home" style="padding-left: 200px;">

                <div class="container">
                    <h4>Enfermos</h4>


                    <div class="row">

                        <div class="col s12 m12 l12">
                            <div class="card blue-grey darken-1">
                                <div class="card-content white-text">

                                    <form action="AdminEnfermos?action=editar" method="post">

                                        
                                         <input type="text" name="nombre" value="<c:out value=" ${enfermo.nombre} " />">
                                        


                                        <strong>ID: </strong>
                                        <input type="number" name="idEnfermo" value="<c:out value="${enfermo.idEnfermo}" />">



                                        <strong>Fecha nacimiento: </strong>
                                        <input type="text"  value="<c:out value="${enfermo.fechaNacimiento}" />" placeholder="Fecha nacimiento" class="datepicker"
                                               name="fechaNacimiento" />




                                        <strong>Sexo: </strong>
                                        <p>
                                            <input name="sexo" value="M" type="radio" id="test1" />
                                            <label for="test1">Masculino</label>
                                        </p>
                                        <p>
                                            <input name="sexo" value="F" type="radio" id="test2" />
                                            <label for="test2">Femenino</label>
                                        </p>




                                        <strong>Direccion: </strong>
                                        <input type="text" name="direccion" value="<c:out value=" ${enfermo.direccion} " />">



                                        <strong>Localidad: </strong>
                                        <input type="text" name="localidad" value="<c:out value=" ${enfermo.localidad} " />">




                                        <strong>Provincia: </strong>
                                        <input type="text" name="provincia" value="<c:out value=" ${enfermo.provincia} " />">



                                        <strong>Pais: </strong>
                                        <input type="text" name="pais" value="<c:out value=" ${enfermo.pais} " />">



                                        <strong>Codigo postal: </strong>
                                        <input type="text" name="codigoPostal" value="<c:out value=" ${enfermo.codigoPostal} " />">

                                        <button class="btn waves-effect waves-light" type="submit" name="action">Guardar
                                            <i class="material-icons right">send</i>
                                        </button>

                                    </form>


                                </div>
                                <div class="card-action">

                                    <a href="AdminEnfermos?action=eliminar&id=<c:out value=" ${enfermo.idEnfermo} "/>">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                    <a href="AdminEnfermos?action=showedit&id=<c:out value=" ${enfermo.idEnfermo} " />">
                                        <i class="fas fa-edit"></i>
                                    </a>


                                </div>
                            </div>
                        </div>



                    </div>







                </div>


            </div>
        </main>

        <div id="modal1" class="modal">
            <div class="modal-content">
                <h4>Agregar nuevo hospital</h4>
                <form action="AdminHospitales?action=nuevoHospital" method="post">

                    <input type="text" placeholder="Nombre" name="nombre" />
                    <input type="text" placeholder="direccion" name="direccion" />
                    <input type="text" placeholder="telefono" name="telefono" />

                    <input type="submit" value="Agregar">

                </form>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
            </div>
        </div>

        <div id="modal2" class="modal">
            <div class="modal-content">

                <h4>Agregar nuevo enfermo</h4>

                <form action="AdminEnfermos?action=nuevoEnfermo" method="post">

                    <input type="text" placeholder="Nombre" name="nombre" />
                    <input type="text" placeholder="Fecha nacimiento" class="datepicker" name="fechaNacimiento" />
                    <p>
                        <input name="sexo" value="M" type="radio" id="test1" />
                        <label for="test1">Masculino</label>
                    </p>
                    <p>
                        <input name="sexo" value="F" type="radio" id="test2" />
                        <label for="test2">Femenino</label>
                    </p>

                    <input type="text" placeholder="Direccion" name="direccion" />

                    <input type="text" placeholder="Localidad" name="localidad" />

                    <input type="text" placeholder="Estado" name="provincia" />

                    <input type="text" placeholder="Pais" name="pais" />

                    <input type="text" placeholder="Codigo Postal" name="codigoPostal" />


                    <input type="submit" value="Agregar">

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
                    <a class="btn-floating red btn modal-trigger" data-target="modal1" href="#modal1">
                        <i class="material-icons">H</i>
                    </a>
                </li>
                <li>
                    <a class="btn-floating yellow darken-1 btn modal-trigger" data-target="modal2" href="#modal2">
                        <i class="material-icons">E</i>
                    </a>
                </li>
                <li>
                    <a class="btn-floating green">
                        <i class="material-icons">Es</i>
                    </a>
                </li>
            </ul>

        </div>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script>
        $(document).ready(function () {
            // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered

            $('.modal').modal();

            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: false // Close upon selecting a date,
            });

        });
    </script>

</html>