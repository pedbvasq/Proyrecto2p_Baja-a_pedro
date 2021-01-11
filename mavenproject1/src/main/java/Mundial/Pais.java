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
public class Pais implements Comparable {

    private Continente continente;
    private String nombre;
    private int caso;
    private int muerte;

    @Override
    public int compareTo(Object o) {
        return 0;

    }

    public static ArrayList<Pais> listaPa() {
        return null;
//        ArrayList<Pais> paises = new ArrayList<>();
//        for (String i : Archivo.LeeFichero("pais.csv")) {
//            String lista[] = i.split("|");
//            for (String j : Archivo.LeeFichero("globales.csv")) {
//                String list[] = j.split("|");
//                Pais p = new Pais(new Continente(lista[0]), lista[1], Integer.valueOf(list[1]), Integer.valueOf(list[2]));
//                paises.add(p);
//
//            }
//
//        }
//        return paises;

    }

    public Pais(Continente continente, String nombre, int caso, int muerte) {
        this.continente = continente;
        this.nombre = nombre;
        this.caso = caso;
        this.muerte = muerte;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
