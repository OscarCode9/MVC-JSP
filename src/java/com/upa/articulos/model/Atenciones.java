/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulos.model;

/**
 *
 * @author oscarcode
 */

/*
CREATE TABLE Atencion (
    idAtencion int not null AUTO_INCREMENT,
    idDoctor int,
    idIngresos int,
    comentarios varchar(45),
    fecha datetime,
    PRIMARY KEY (idAtencion),
    FOREIGN KEY (idDoctor) REFERENCES Doctores(idDoctor),
    FOREIGN KEY (idIngresos) REFERENCES Ingresos(idIngresos)
);
*/
public class Atenciones {
    
    private int idDoctor;
    private int idIngresos;
    private String comentarios;
    private String fecha;
    private int idAtencion;

    public Atenciones(int idAtencion, int idDoctor, int idIngresos, String comentarios, String fecha) {
        this.idAtencion = idAtencion;
        this.idDoctor = idDoctor;
        this.idIngresos = idIngresos;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    
    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }
    
    
    

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    public int getIdDoctor() {
        return idDoctor;
    }

    public int getIdIngresos() {
        return idIngresos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    
}
