/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 * El programa debe controlar: o Campos vacíos. o Año de ingreso válido (entre
 * 2010 y 2025 inclusive). o Excepciones de lectura y escritura de archivos.
 *
 * @author nicol
 */
public class Alumno extends Persona implements Serializable{

    String carrera;
    int anhoIngreso;

    @Override
    public String obtenerInformacion() {
        return "\n" + super.nombre +" "+ super.cedula +" " + carrera +" "+ anhoIngreso;
    }

    public Alumno(String carrera, int anhoIngreso, String nombre, String cedula) {
        if (anhoIngreso >= 2010 && anhoIngreso <= 2025) {
            this.anhoIngreso = anhoIngreso;
        } else {
            System.out.println("El año de ingreso es inválido");
        }
        if (carrera == null || carrera.trim().isBlank()) {
            System.out.println("Todos los campodeben ser llenados");
        } else {
            this.carrera = carrera;
        }

        super(nombre, cedula);
    }

}
