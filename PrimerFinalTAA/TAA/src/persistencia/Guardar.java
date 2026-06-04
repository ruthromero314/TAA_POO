/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;

/**
 * El programa debe controlar: o Campos vacíos. o Año de ingreso válido (entre
 * 2010 y 2025 inclusive). o Excepciones de lectura y escritura de archivos.
 * --------- ya esta aca
 *
 * @author nicol
 */
public class Guardar {

    final static String ARCHIVO = "alumnos.dat";

    public static String guardarBIN(Alumno nuevoAlumno) {
        List<Alumno> alumnos = new ArrayList<>();
        File file = new File(ARCHIVO);
        String Texto;
        if (file.exists()) {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
                Texto = "--------------Alumnos anteriores--------------\n";
                while (true) {
                    try {
                        Alumno alumno = (Alumno) entrada.readObject();
                        alumnos.add(alumno);
                        Texto = Texto + alumno.obtenerInformacion();
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (Exception e) {
                Texto = "No se pudo leer el objeto\n";
            }
        } else {
            Texto = "No existen alumnos previos\n";
        }

        alumnos.add(nuevoAlumno);
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            for (Alumno alumno : alumnos) {
                salida.writeObject(alumno);//guardar cada alumno
            }
        } catch (Exception e) {
            Texto = "No se pudo guardar el objeto\n";
        }
        return Texto;
    }

}
