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
/*CREATE TABLE Especialidades (
    idEspecialidad int not null AUTO_INCREMENT,
    nombre varchar(45),
    PRIMARY KEY(idEspecialidad)
);*/
public class Especialidad {
    private  String nombre;
    private int idEspecialidad;
    public Especialidad(int idEspecialidad, String nombre){
        
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
