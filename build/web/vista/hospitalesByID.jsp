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

        <h3>Administrar hospital
          <c:out value="${hospital.nombre}" />
        </h3>
        <table>
          <tr>
            <td>
              <a href="adminArticulo?action=index">Ir al menú</a>
            </td>
          </tr>
        </table>

        <p>Id hospital:
          <c:out value="${hospital.idHospital}" />
        </p>
        <p>Nombre hospital:
          <c:out value="${hospital.nombre}" />
        </p>
        <p>Dirección:
          <c:out value="${hospital.direccion}" />
        </p>
        <p>Telefono:
          <c:out value="${hospital.telefono}" />
        </p>

        <h3> Lista de doctores: </h3>

        <table class="highlight" border="1" width="100%">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nombre</th>
              <th>Salario</th>
              <th>ID especialidad</th>
              <th>ID hospital</th>
              <th colspan=2>ACCIONES</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="doctor" items="${listaDoctores}">

              <tr>

                <td>

                  <c:out value="${doctor.idDoctor}" />

                </td>

                <td>
                  <c:out value="${doctor.nombre}" />
                </td>
                <td>
                  <c:out value="${doctor.salario}" />
                </td>
                <td>
                  <c:out value="${doctor.idEspecialidad}" />
                </td>

                <td>
                  <c:out value="${doctor.idHospital}" />
                </td>

                <td>

                  <a href="AdminDoctores?action=eliminar&id=<c:out value="${doctor.idDoctor}"/>">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </td>
                <td>
                  <a href="AdminDoctores?action=showedit&id=<c:out value="${doctor.idDoctor}"/>">
                    <i class="fas fa-edit"></i>
                  </a>
                </td>

              </tr>

            </c:forEach>
          </tbody>

        </table>

        <h3> Lista de ingresos</h3>

        <table class="highlight" border="1" width="100%">
          <thead>
            <tr>
              <th>Id Ingresos</th>
              <th>Id Hospital</th>
              <th>Id Enfermo</th>
              <th>Fecha</th>
              <th>Causas</th>
              <th>Habitacion</th>
              <th colspan=2>ACCIONES</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ingreso" items="${listaIngresos}">

              <tr>

                <td>

                  <c:out value="${ingreso.idIngresos}" />

                </td>

                <td>
                  <c:out value="${ingreso.idHospital}" />
                </td>
                <td>
                  <c:out value="${ingreso.idEnfermo}" />
                </td>
                <td>
                  <c:out value="${ingreso.fecha}" />
                </td>

                <td>
                  <c:out value="${ingreso.causas}" />
                </td>

                <td>
                  <c:out value="${ingreso.habitacion}" />
                </td>

                <td>

                  <a href="AdminIngresos?action=eliminar&id=<c:out value="${ingreso.idIngresos}"/>">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </td>
                <td>
                  <a href="AdminIngresos?action=showedit&id=<c:out value="${ingreso.idIngresos}" />">
                    <i class="fas fa-edit"></i>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>

        </table>

        <h3> Lista atenciones</h3>

        <table class="highlight" border="1" width="100%">
          <thead>
            <tr>
              <th>idAtencion</th>
              <th>idDoctor</th>
              <th>idIngresos</th>
              <th>comentarios</th>
              <th>fecha</th>
              <th colspan=2>ACCIONES</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="atencion" items="${listaAtenciones}">

              <tr>

                <td>

                  <c:out value="${atencion.idAtencion}" />

                </td>

                <td>
                  <c:out value="${atencion.idDoctor}" />
                </td>
                <td>
                  <c:out value="${atencion.idIngresos}" />
                </td>
                <td>
                  <c:out value="${atencion.comentarios}" />
                </td>

                <td>
                  <c:out value="${atencion.fecha}" />
                </td>

                <td>

                  <a href="AdminAtenciones?action=eliminar&id=<c:out value="${atencion.idAtencion}"/>">
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </td>
                <td>
                  <a href="AdminAtenciones?action=showedit&id=<c:out value="${atencion.idAtencion}" />">
                    <i class="fas fa-edit"></i>
                  </a>
                </td>

              </tr>

            </c:forEach>

          </tbody>
        </table>
      </div>


      <div id="modal3" class="modal">
        <div class="modal-content">
          <h4>Agregar Doctor un nuevo atencion</h4>

          <form action="AdminAtenciones?action=nuevoAtencio" method="post">

            <div class="input-field col s12 l6">
              <select name="idDoctor">
                <c:forEach var="doctor" items="${listaDoctores}">
                  <option value="${doctor.idDoctor}"/>${doctor.idDoctor}</option>
                </c:forEach>
              </select>
              <label>Id doctor</label>
            </div>

            <div class="input-field col s12 l6">
              <select name="idIngresos">
                <c:forEach var="ingreso" items="${listaIngresos}">
                  <option value="${ingreso.idIngresos}"/>${ingreso.idIngresos}</option>
                </c:forEach>
              </select>
              <label>Id ingreso</label>
            </div>

            <div class="row">
              <div class="input-field col s12">
                <textarea id="textarea1" name="comentarios" class="materialize-textarea"></textarea>
                <label for="textarea1">Comentarios</label>
              </div>
            </div>

            <label for="fechaNacimiento">Fecha de ingreso</label>
            <input type="text" placeholder="Fecha nacimiento" id="fechaNacimiento" class="datepicker" name="fecha" />
            <div class="row center">
                <input type="submit" value="Guardar">
            </div>
            

          </form>

        </div>
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
                  <option value="<c:out value="${especialidad.nombre}"/>">
                    <c:out value="${especialidad.nombre}" />
                  </option>
                </c:forEach>
              </select>
              <label>Especialidad</label>
            </div>


            <label for="idHospital">Id hospital</label>
            <input id="idHospital" type="number" name="idHospital" value="<c:out value="${hospital.idHospital}"/>"/>




            <input type="submit" value="Agregar">

          </form>
        </div>
        <div class="modal-footer">
          <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
        </div>
      </div>

      <div id="modal2" class="modal">
        <div class="modal-content">


          <h4>Agregar ingreso de enfermo</h4>

          <form action="AdminIngresos?action=nuevoIngreso" method="post">

            <label for="idHospital">ID hospital</label>
            <input type="text" name="idHospital" id="idHospital" value="<c:out value="${hospital.idHospital}"/>">



            <div class="input-field col s12">
              <select name="idEnfermo">
                <c:forEach var="enfermo" items="${listaEnfermo}">
                  <option value="${enfermo.idEnfermo}"/>${enfermo.idEnfermo}</option>
                </c:forEach>
              </select>
              <label>Id enfermo</label>
            </div>



            <label for="fechaNacimiento">Fecha de nacimiento</label>
            <input type="text" placeholder="Fecha nacimiento" id="fechaNacimiento" class="datepicker" name="fechaNacimiento" />

            <div class="row">
              <div class="input-field col s12">
                <textarea id="textarea1" name="causas" class="materialize-textarea"></textarea>
                <label for="textarea1">Causas de ingreso</label>
              </div>
            </div>

            <label for="habitacion">Num. habitacion</label>
            <input type="number" name="habitacion" id="habitacion">


            <button class="btn waves-effect waves-light" type="submit" name="action">Guardar

            </button>

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
            <a class="btn-floating yellow darken-1 btn modal-trigger tooltipped" data-position="top" data-delay="50" data-tooltip="Agregar nuevo ingreso"
              data-target="modal2" href="#modal2">
              <i class="fas fa-frown"></i>
            </a>
          </li>
          <li>
            <a class="btn-floating black btn modal-trigger tooltipped" data-position="top" data-delay="50" data-tooltip="Agregar atencion"
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

    <script>

    </script>

    </html>