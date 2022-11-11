package com.hoshin.Hoshin.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="native", strategy = "native")// se fija si existe el id para no repetir

    private long id;

    private String primerNombre;

    private String apellido;
    private String email;

    private String contraseña;


    public cliente(){

    }

    public cliente( String primerNombre, String apellido, String email, String contraseña) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }


    public long getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    @Override
    public String toString() { //retornq un string compuesto asi
        return "Cliente {" +
                "id=" + id +
                ", Nombre='" + primerNombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
