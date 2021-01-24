/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class PrincipalProyecto extends Application {

    /**
     *
     */
    public static String filerutes = "files\\";

    /**
     *
     */
    public static String imagesrutes = "Imagenes\\";

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(PrincipalProyecto.class.getResource("VentanaDeInicio.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Estadisticas Covid-19");
        stage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();

    }

    /**
     *
     */
    public static void error() {
        VBox root = new VBox();
        root.setStyle("-fx-background-color:red");
        Stage st = new Stage();
        Scene scene = new Scene(root, 400, 120);
        st.setScene(scene);
        st.show();
        Label lb = new Label("ERROR #404");
        Label lb1 = new Label("LO SENTIMOS, ESTAMOS INTENTANDO SOLUCIONAR EL PROBLEMA");
        Label L = new Label("INTENTA MAS TARDE");
        Button cerrar = new Button("Cerrar");
        cerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage s = (Stage) cerrar.getScene().getWindow();
                s.close();

            }
        });
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(lb, lb1, L, cerrar);
    }

}
