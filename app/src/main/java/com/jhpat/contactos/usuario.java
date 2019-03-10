package com.jhpat.contactos;

import java.io.Serializable;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class usuario implements  Serializable{

    private String nombre;
    private String usuario;
    private String contraseña;
    private String edad;

    public usuario(String nombre, String usuario,String contraseña,String edad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.edad = edad;
    }

    public usuario(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña =contraseña;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
