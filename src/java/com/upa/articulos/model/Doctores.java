/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulos.model;

import java.util.logging.Logger;

/**
 *
 * @author oscarcode
 */

/*
    idDoctor int not null AUTO_INCREMENT,
    nombre varchar(45),
    salario decimal(8,2),
    idEspecialidad int,
    idHospital int,
    PRIMARY KEY (idDoctor),
    FOREIGN KEY (idHospital) REFERENCES Hospitales(idHospital),
    FOREIGN KEY (idEspecialidad) REFERENCES Especialidades(idEspecialidad)
*/
public class Doctores {
    private String nombre; 
    private float salario;
    private int idEspecialidad;
    private int idHospital;

    public Doctores(String nombre, float salario, int idEspecialidad, int idHospital) {
        this.nombre = nombre;
        this.salario = salario;
        this.idEspecialidad = idEspecialidad;
        this.idHospital = idHospital;
    }
    private static final Logger LOG = Logger.getLogger(Doctores.class.getName());

    public String getNombre() {
        return nombre;
    }

    public float getSalario() {
        return salario;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }
    
    
    
    
}
