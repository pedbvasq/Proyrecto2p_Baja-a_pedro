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
public class Pais {

    /**
     *
     */
    private Continente continente;

    /**
     *
     */
    private String nombre;

    /**
     *
     * @param continente
     * @param nombre
     */
    public Pais(Continente continente, String nombre) {
        this.continente = continente;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public Continente getContinente() {
        return continente;
    }

    /**
     *
     * @param continente
     */
    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Pais> listaPaises(){
          ArrayList<Pais> paises = new ArrayList<>();
       try (BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes + "paises.csv"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String lista[] = linea.split("\\|");
                paises.add(new Pais(new Continente(lista[0].trim()),lista[1]));

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
