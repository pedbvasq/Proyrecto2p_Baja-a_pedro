/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Country;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class DatoGeneralController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(Country g:Country.cargarglobal()){
            if(g.getNombre().equals("World")){
                txtcasos.setText(String.valueOf(g.getCaso()));
                txtmuertes.setText(String.valueOf(g.getMuerte()));
                
                
            }
            
        }
    }
    @FXML
    private Label txtcasos;
    @FXML
    private Label txtmuertes;
    @FXML
    private Button btConsultaPaises;

    @FXML
    void ConsultaPaises(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPaisOrden.fxml"));
        try {
            Parent root = loader.load();
            VentanaPaisOrdenController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
