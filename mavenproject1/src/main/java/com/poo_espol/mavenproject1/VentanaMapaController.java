/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaMapaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private ImageView mapa;
    @FXML
    private Button btubicacion;
    @FXML
    private Button btcerrarUbi;

    @FXML
    void cerrarUbicacion(ActionEvent e) {
         Stage s = (Stage) btcerrarUbi.getScene().getWindow();
         s.close();
    }

    @FXML
    void registrarUbicacion(ActionEvent e) {

    }

}
