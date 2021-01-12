/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class PrincipalProyecto extends Application{
    public static String filerutes = "src/main/resources/com/poo_espol/mavenproject1/files" ;
    public static String imagesrutes ="src/main/resources/com/poo_espol/mavenproject1/imagenes";
    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader(PrincipalProyecto.class.getResource("VentanaDeInicio.fxml"));
       Parent root = loader.load();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Estadisticas Covid-19");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
       
    }
    
    
}
