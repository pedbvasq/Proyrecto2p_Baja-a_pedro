/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaPoblacionalController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        starTask();
        llenarDatos();

    }

    /**
     *
     */
    @FXML
    private Label edadP;

    /**
     *
     */
    @FXML
    private Label vida;

    /**
     *
     */
    @FXML
    private Label pobreza;

    /**
     *
     */
    @FXML
    private Label dPoblacion;

    /**
     *
     */
    @FXML
    private Label tiempoCerrar;

    /**
     *
     */
    @FXML
    private Button txtcerrar;

    /**
     *
     * @param e
     */
    @FXML
    void cerrar(ActionEvent e) {
        Stage s = (Stage) txtcerrar.getScene().getWindow();
        s.close();

    }

    /**
     *
     */
    public void starTask() {
        Thread restarTiempo = new Thread(new Runnable() {
            @Override
            public void run() {
                runTask();
            }
        }) {

        };
        restarTiempo.setDaemon(true);
        restarTiempo.start();

    }

    /**
     *
     */
    public void runTask() {
        for (int i = 5; i > 0; i--) {
            String status = " Ventana se cerra en Tiempo :" + i + " Segundos";
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    tiempoCerrar.setText(status);
                    tiempoCerrar.setStyle("-fx-background-color:red");

                }
            });
            try {
                System.out.println(status);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     *
     */
    public void llenarDatos() {
        edadP.setText(VentanaDashBoardController.getEd());
        pobreza.setText(VentanaDashBoardController.getPob());
        vida.setText(VentanaDashBoardController.getVid());
        dPoblacion.setText(VentanaDashBoardController.getDen());
    }
}
