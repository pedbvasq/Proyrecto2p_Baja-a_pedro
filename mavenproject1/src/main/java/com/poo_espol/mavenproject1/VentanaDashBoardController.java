/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Continente;
import Mundial.Pais;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaDashBoardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        starTask();
        comboConti.getItems().setAll(Continente.cargarContinente());

    }
    @FXML
    private ComboBox<Continente> comboConti;
    @FXML
    private ComboBox<Pais> comboPais;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button consultar;
    @FXML
    private VBox rootDash;
    @FXML
    private Label timepoApp;
    @FXML
    private Label txtcasos;
    @FXML
    private Label casos;
    @FXML
    private Label txtdias;
    @FXML
    private Label dias;
    @FXML
    private Label txtpoblacion;
    @FXML
    private Label poblacion;
    @FXML
    private Label txtMuertedias;
    @FXML
    private Label diasMuerte;
    @FXML
    private Button btnCerrar;

    @FXML
    void consultarAccion(ActionEvent e) {

    }

    @FXML
    void continenteAccion(ActionEvent e) {
        Continente ct = comboConti.getValue();
        ArrayList<Pais> lispa = new ArrayList<>();
        for (Pais p : Pais.listaPaises()) {
            if (ct.getNombre().equals(p.getContinente().getNombre())) {
                lispa.add(p);

            }

        }
        comboPais.getItems().setAll(lispa);

    }

    @FXML
    void fechaConsulta(ActionEvent e) {

    }

    @FXML
    void paisEleccion(ActionEvent e) {

    }

    @FXML
    void cerrar(ActionEvent e) {
        Stage s = (Stage) btnCerrar.getScene().getWindow();
        s.close();
       

    }

    public void starTask() {
        Thread contadorTiempo = new Thread(new Runnable() {
            @Override
            public void run() {
                runTask();
            }
        }) {

        };
        contadorTiempo.setDaemon(true);
        contadorTiempo.start();

    }

    public void runTask() {
        int contador = 1;
        while (contador != 0) {
            int ct = contador++;
            String status = " Tiempo en la applicacion :" + ct + " Segundos";
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    timepoApp.setText(status);
                    timepoApp.setStyle("-fx-background-color:red");

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

}
