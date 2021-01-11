/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundial;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Continente {

    private String nombre;

    public Continente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    

    public static ArrayList<Continente> listaCont() {
        ArrayList<String> datos = Archivo.LeeFichero("continentes.txt");
        ArrayList<Continente> continentes = new ArrayList<>();
        for (String i : datos) {
            continentes.add(new Continente(i));
        }

        return continentes;

    }
    
}
