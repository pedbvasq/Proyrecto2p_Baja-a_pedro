/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundial;

import com.poo_espol.mavenproject1.PrincipalProyecto;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author pedro
 */
public class Punto implements Serializable{

    /**
     *
     */
    private double coordenadaX;

    /**
     *
     */
    private double coordenadaY;

    /**
     *
     * @return
     */
    public double getCoordenadaX() {
        return coordenadaX;
    }

    /**
     *
     * @param coordenadaX
     */
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     *
     * @return
     */
    public double getCoordenadaY() {
        return coordenadaY;
    }

    /**
     *
     * @param coordenadaY
     */
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    /**
     *
     * @param coordenadaX
     * @param coordenadaY
     */
    public Punto(double coordenadaX, double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    /**
     *
     * @param p2
     * @return
     */
    public boolean distancia(Punto p2) {
        double formulaDistancia = Math.sqrt(Math.pow(p2.coordenadaX - coordenadaX, 2) + Math.pow(p2.coordenadaY - coordenadaY, 2));
        if (formulaDistancia <= 100) {
            return true;

        } else {
            return false;
        }

    }

    /**
     *
     * @return
     */
    public static ArrayList<Punto> listaLugares() {
        ArrayList<Punto> coordenadas = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes + "lugares.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String lista[] = linea.trim().split("-");
                coordenadas.add(new Punto(Double.valueOf(lista[0]), Double.valueOf(lista[1])));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return coordenadas;

    }

    @Override
    public String toString() {
        return "Punto{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }

    

}
