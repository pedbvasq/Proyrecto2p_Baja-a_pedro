/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaPaisOrdenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Total casos","Total Muertes");
        comboEleccion.setItems(list);
        
    }

    @FXML
    private ComboBox<String> comboEleccion;
    @FXML
    private VBox rootConsultaPais;
    @FXML
    private FlowPane rootInformacionPais;

    @FXML
    void ordenarPor(ActionEvent e) {
        String s = comboEleccion.getValue();
        

    }

}
