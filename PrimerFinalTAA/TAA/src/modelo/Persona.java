/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author nicol
 */
public abstract class Persona implements Serializable{

    String nombre;
    String cedula;

    public abstract String obtenerInformacion();

    public Persona(String nombre, String cedula) {
        if (nombre == null || nombre.trim().isBlank()
                || cedula == null || cedula.trim().isBlank()) {
            System.out.println("Todos los campos deben ser llenados");
        } else {
            this.nombre = nombre;
            this.cedula = cedula;
        }

    }

}
