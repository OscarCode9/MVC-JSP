package com.upa.articulos.model;

public class Hospitales {

    private int idHospital;
    private String nombre;
    private String direccion;
    private String telefono;

    public Hospitales(int idHospital, String nombre, 
            String direccion, String telefono) {
        
        this.idHospital = idHospital;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    //getters y setters

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    
}
