<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Administrar Atenciones</title>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
      <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
    </head>

    <body>

      <div class="containe">
          <h4>Editar atencion con id : <c:out value="${atencion.idAtencion}"/></h4>
      </div>

      

      <div class="container">
        <form action="AdminAtenciones?action=editar" method="post">
          <input type="number" name="idAtencion" value="<c:out value="${atencion.idAtencion}"/>">
          <input type="number" name="idDoctor" value="<c:out value="${atencion.idDoctor}"/>">
          <input type="number" name="idIngresos" value="<c:out value="${atencion.idIngresos}"/>">

         

          <div class="row">
              <div class="input-field col s12">
                  <textarea id="textarea1" value="<c:out value="${atencion.comentarios}"/>" name="comentarios" class="materialize-textarea">${atencion.comentarios}</textarea>
                  <label for="textarea1">Comentarios</label>
              </div>
          </div>

          <label for="fechaNacimiento">Fecha de nacimiento</label>
          <input type="text" placeholder="Fecha nacimiento" id="fechaNacimiento" class="datepicker" name="fecha" />


          

          <button class="btn waves-effect waves-light" type="submit" name="action">Guardar</button>
  
          


        </form>

       
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