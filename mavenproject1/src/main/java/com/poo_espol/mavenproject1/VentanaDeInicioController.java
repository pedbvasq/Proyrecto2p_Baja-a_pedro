/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaDeInicioController implements Initializable {

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
    private Button consultaMundial;

    /**
     *
     */
    @FXML
    private Button consultaZona;

    /**
     *
     * @param e
     */
    @FXML
    void zonaControl(ActionEvent e){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaMapa.fxml"));
        try {
            Parent root = loader.load();
            VentanaMapaController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
    }

    /**
     *
     * @param e
     */
    @FXML
    void datosMundialControl(ActionEvent e){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DatoGeneral.fxml"));
        try {
            Parent root = loader.load();
            DatoGeneralController controlador = loader.getController();
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
