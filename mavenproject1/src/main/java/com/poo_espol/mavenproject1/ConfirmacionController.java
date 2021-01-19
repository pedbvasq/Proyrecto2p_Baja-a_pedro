/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Punto;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private Button registrar;
    @FXML
    private Button btnCancelar;

    @FXML
    void cancelar(ActionEvent e) {
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.close();

    }

    @FXML
    void registroUbi(ActionEvent e) {
        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        String linea = VentanaMapaController.getPosicionX() + "-" + VentanaMapaController.getPosicionY();
        try {
            fichero = new FileWriter(PrincipalProyecto.filerutes + "lugares.txt", true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");
            VentanaMapaController.getConteo().setText("UBICACION REGISTRADA");

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
        try (ObjectOutputStream objStrm = new ObjectOutputStream(new FileOutputStream("registros.txt", true));) {
            Punto p = new Punto(VentanaMapaController.getPosicionX(), VentanaMapaController.getPosicionY());
            objStrm.writeObject(p);

        } catch (IOException ed) {
            System.out.println("Exception during serialization" + e);

        }

    }
}
