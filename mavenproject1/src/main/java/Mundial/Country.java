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
public class Country implements Comparable<Country> {

    private String nombre;
    private int caso;
    private int muerte;


    public Country(String nombre, int caso, int muerte) {
        this.nombre = nombre;
        this.caso = caso;
        this.muerte = muerte;
   
    }

    public static ArrayList<Country> cargarglobal() {
        ArrayList<Country> globales = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes + "globales.csv"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String lista[] = linea.split("\\|");
                int c = Integer.valueOf(lista[1].trim());
                int m = Integer.valueOf(lista[2].trim());
                globales.add(new Country(lista[0].trim(), c, m));

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return globales;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCaso() {
        return caso;
    }

    public void setCaso(int caso) {
        this.caso = caso;
    }

    public int getMuerte() {
        return muerte;
    }

    public void setMuerte(int muerte) {
        this.muerte = muerte;
    }

    @Override
    public int compareTo(Country c) {

        if (this.caso < c.getCaso()) {
            return 1;
        } else if (this.caso > c.getCaso()) {
            return -1;
        }

        return 0;

    }

    public String toString() {
        return nombre;
    }

}
