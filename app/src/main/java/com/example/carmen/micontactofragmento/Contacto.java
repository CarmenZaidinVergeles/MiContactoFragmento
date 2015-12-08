package com.example.carmen.micontactofragmento;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Chrno on 02/12/2015.
 */
public class Contacto implements Serializable{
    String nombre;
    List<String> telefonos;
    public Contacto(){}
    public Contacto(String nombre, List<String> telefonos) {
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefonos=" + telefonos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }
    public String getStringTelefonos(){
        String s="";
        for(String a:telefonos){
            s+=a;
        }
        return s;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }
}
