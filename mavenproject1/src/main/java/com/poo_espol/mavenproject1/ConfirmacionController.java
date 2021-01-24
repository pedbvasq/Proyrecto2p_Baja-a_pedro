/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Punto;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class ConfirmacionController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     */
    @FXML
    private Button registrar;

    /**
     *
     */
    @FXML
    private Button btnCancelar;

    /**
     *
     * @param e
     */
    @FXML
    void cerrar(ActionEvent e) {
        System.out.println("cerrando");
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.close();

    }

    /**
     *
     * @param e
     * @throws IOException
     */
    @FXML
    void registrarUbi(ActionEvent e) throws IOException {
        System.out.println("guardando");
        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        String linea = VentanaMapaController.getPosicionX() + "-" + VentanaMapaController.getPosicionY();
        try {
            fichero = new FileWriter(PrincipalProyecto.filerutes + "lugares.txt", true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (null != fichero) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        try (ObjectOutputStream objStrm = new ObjectOutputStream(new FileOutputStream("LugarRegistro.bin", true));) {
            Punto p = new Punto(VentanaMapaController.getPosicionX(), VentanaMapaController.getPosicionY());
            objStrm.writeObject(p);
            System.out.println(p);

        } catch (IOException ed) {
           

        }
        
    }
}
