package com.iteso.sesion5_tarea;


/**
 * Created by Mariana Salas on 02/02/2018.
 */

public class Alumno {

String nombre, telefono, escolaridad, genero, libro;
boolean deporte;

public Alumno (String nombre, String telefono, String escolaridad, String genero, String libro, Boolean deporte){
    this.nombre = nombre;
    this.telefono =telefono;
    this.escolaridad=escolaridad;
    this.genero =genero;
    this.libro=libro;
    this.deporte = deporte;
}

    public String toString(){
        if(deporte == true){
            return ("Nombre :" +nombre+"\nTeléfono: " +telefono+ "\nEscolaridad: " +escolaridad+ "\nGénero: " +genero +"\nLibro Favorito: " +libro + "\nPractica Deporte: Sí");
        }
        else
            return("Nombre :" +nombre+"\nTeléfono: " +telefono+ "\nEscolaridad: " +escolaridad+ "\nGénero: " +genero +"\nLibro Favorito: " +libro + "\nPractica Deporte: No");
    }

}
