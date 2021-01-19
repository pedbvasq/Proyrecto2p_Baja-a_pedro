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
public class Punto {

    private double coordenadaX;
    private double coordenadaY;

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    

    public Punto(double coordenadaX, double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }



    public boolean distancia(Punto p2) {
        double formulaDistancia = Math.sqrt(Math.pow(p2.coordenadaX - coordenadaX, 2) + Math.pow(p2.coordenadaY - coordenadaY, 2));
        if (formulaDistancia <= 100) {
            return true;

        } else {
            return false;
        }

    }

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

    

}
