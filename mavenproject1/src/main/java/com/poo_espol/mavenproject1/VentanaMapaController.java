/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Punto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
    private Label conteo;
    @FXML
    private ImageView mapa;
    @FXML
    private Button btubicacion;
    @FXML
    private Button btcerrarUbi;
    @FXML
    private Pane rootMapa;
  

    
    
    private static double posicionX;
    private static double posicionY;

    public static double getPosicionX() {
        return posicionX;
    }

    public static void setPosicionX(double posicionX) {
        VentanaMapaController.posicionX = posicionX;
    }

    public static double getPosicionY() {
        return posicionY;
    }

    public static void setPosicionY(double posicionY) {
        VentanaMapaController.posicionY = posicionY;
    }

    @FXML
    void cerrarUbicacion(ActionEvent e) {
        Stage s = (Stage) btcerrarUbi.getScene().getWindow();
        s.close();
    }

    @FXML
    void registrarUbicacion(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmacion.fxml"));
        try {
            Parent root = loader.load();
            ConfirmacionController controlador = loader.getController();
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
    void mapaClick(MouseEvent e) {
        rootMapa.getChildren().clear();
        System.out.println();
        posicionX = e.getX();
        posicionY = e.getY();
        ImageView img = null;

        try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + "UbicacionUsuario.jpg")) {
            Image image = new Image(imput, 30, 30, false, false);
            img = new ImageView(image);
            img.setLayoutX(posicionX);
            img.setLayoutY(posicionY);
            rootMapa.getChildren().add(img);
            starTask();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        

    }

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

    public void runTask() {

        for (Punto p : Punto.listaLugares()) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ImageView img = null;
                    if (p.distancia(new Punto(posicionX, posicionY))) {

                        try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + "UbicacionContagio.png")) {

                            Image image = new Image(imput, 30, 30, false, false);
                            img = new ImageView(image);
                            img.setLayoutX(p.getCoordenadaX());
                            img.setLayoutY(p.getCoordenadaY());
                            rootMapa.getChildren().add(img);

                        } catch (FileNotFoundException ex) {
                            System.out.println(ex.getMessage());
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }

                }
            });

            try {
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}
