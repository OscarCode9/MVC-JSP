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
idEnfermo int not null AUTO_INCREMENT,
    nombre varchar(45),
    fechaNacimiento DATE,
    sexo CHAR(1),
    direccion VARCHAR(45),
    localidad VARCHAR(45),
    provincia VARCHAR (45),
    pais VARCHAR(45),
    codigoPostal varchar(5
*/
public class Enfermos {
    
    private int idEnfermo;
    
    private String nombre; 
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String codigoPostal;
    
    
    public Enfermos(int idEnfermo, String nombre, String fechaNacimiento, String sexo, String direccion,
    String localidad, String provincia, String pais, String codigoPostal){
        this.idEnfermo = idEnfermo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public void setIdEnfermo(int idEnfermo) {
        this.idEnfermo = idEnfermo;
    }

    public int getIdEnfermo() {
        return idEnfermo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    
    
    
}
