/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.ComparadorPais;
import Mundial.Country;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

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
        ObservableList<String> list = FXCollections.observableArrayList("Total casos", "Total Muertes");
        comboEleccion.setItems(list);

    }

    @FXML
    private ComboBox<String> comboEleccion;
    @FXML
    private VBox rootConsultaPais;
    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private Label a3;
    @FXML
    private VBox informacion;

    @FXML
    void ordenarPor(ActionEvent e) {

        String s = comboEleccion.getValue();
        a1.setText("Paises");
        a2.setText("Total casos");
        a3.setText("Total Muertes");
        informacion.getChildren().clear();

        if (s.equals("Total casos")) {

            ArrayList<Country> paises = Country.cargarglobal();
            Collections.sort(paises);
            ImageView img = null;
            for (int i = 1; i < 11; i++) {
                try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + paises.get(i).getNombre())) {
                    Image image = new Image(imput);
                    img = new ImageView(image);

                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                HBox lista = new HBox();
                Label lb1 = new Label(paises.get(i).getNombre());
                Label lb2 = new Label(String.valueOf(paises.get(i).getCaso()));
                Label lb3 = new Label(String.valueOf(paises.get(i).getMuerte()));
                lista.getChildren().addAll(lb1, lb2, lb3);
                lista.setAlignment(Pos.CENTER);
                lista.setPadding(new Insets(20, 0, 0, 0));
                lista.setSpacing(100);
                informacion.setSpacing(10);
                informacion.getChildren().addAll(lista);
                informacion.setAlignment(Pos.CENTER);

            }
            Button consultaDetallada = new Button();
            consultaDetallada.setText("Consulta Detallada");
            consultaDetallada.setStyle("-fx-background-color:blue");
            informacion.getChildren().add(consultaDetallada);
            consultaDetallada.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaDashBoard.fxml"));
                    try {
                        Parent root = loader.load();
                        VentanaDashBoardController controlador = loader.getController();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
                        

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } else {

            ArrayList<Country> paises = Country.cargarglobal();
            Collections.sort(paises, new ComparadorPais());
            ImageView img = null;
            for (int i = 1; i < 10; i++) {
                try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + paises.get(i).getNombre())) {
                    Image image = new Image(imput);
                    img = new ImageView(image);

                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                HBox lista = new HBox();

                Label lb1 = new Label(paises.get(i).getNombre());
                Label lb2 = new Label(String.valueOf(paises.get(i).getCaso()));
                Label lb3 = new Label(String.valueOf(paises.get(i).getMuerte()));
                lista.getChildren().addAll(lb1, lb2, lb3);
                lista.setAlignment(Pos.CENTER);
                lista.setPadding(new Insets(20, 0, 0, 0));
                lista.setSpacing(100);
                informacion.setAlignment(Pos.CENTER);
                informacion.setSpacing(10);
                informacion.getChildren().addAll(lista);

            }
            Button consultaDetallada = new Button();
            consultaDetallada.setText("Consulta Detallada");
            consultaDetallada.setStyle("-fx-background-color:blue");
            informacion.getChildren().addAll(consultaDetallada);

            consultaDetallada.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaDashBoard.fxml"));
                    try {
                        Parent root = loader.load();
                        VentanaDashBoardController controlador = loader.getController();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
                        
                        
                      
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        }

    }
      
    
    
}
