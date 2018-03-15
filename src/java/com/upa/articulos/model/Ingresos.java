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

/*CREATE TABLE Ingresos (
    idIngresos int not null AUTO_INCREMENT,
    idHospital int,
    idEnfermo int,
    fecha datetime,
    causas varchar(45),
    habitacion int(3),
    PRIMARY KEY (idIngresos),
    FOREIGN KEY (idHospital) REFERENCES Hospitales(idHospital),
    FOREIGN KEY (idEnfermo) REFERENCES Enfermos(idEnfermo)
);*/
public class Ingresos {
    private int idIngresos;
    private int idHospital;
    private int idEnfermo;
    private String fecha;
    private String causas;
    private int habitacion;

    public Ingresos(int idIngresos, int idHospital, int idEnfermo, String fecha, String causas, int habitacion) {
        
        this.idIngresos = idIngresos;
        this.idHospital = idHospital;
        this.idEnfermo = idEnfermo;
        this.fecha = fecha;
        this.causas = causas;
        this.habitacion = habitacion;
    }

    public int getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }
    

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public void setIdEnfermo(int idEnfermo) {
        this.idEnfermo = idEnfermo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    
    public int getIdHospital() {
        return idHospital;
    }

    public int getIdEnfermo() {
        return idEnfermo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCausas() {
        return causas;
    }

    public int getHabitacion() {
        return habitacion;
    }
    
    
    
    
}
