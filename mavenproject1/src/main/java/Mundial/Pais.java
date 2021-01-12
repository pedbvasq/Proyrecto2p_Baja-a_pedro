/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundial;

import com.poo_espol.mavenproject1.PrincipalProyecto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Pais extends Global implements Comparable<Pais> {

    private Continente continente;

    public Pais(String nombre, int caso, int muerte, Continente continente) {
        super(nombre, caso, muerte);
        this.continente = continente;
    }

    @Override
    public int compareTo(Pais p) {
        return 0;

    }

    public static ArrayList<Pais> cargarPais(Global g) {
        ArrayList<Pais> paises = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes + "paises.csv"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String lista[] = linea.split("\\|");

                paises.add(new Pais(g.nombre, g.caso, g.muerte, new Continente(lista[0].trim())));

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return paises;

    }

    @Override
    public String toString() {
        return nombre;
    }

}
