/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo_espol.mavenproject1;

import Mundial.Continente;
import Mundial.Country;
import Mundial.Pais;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class VentanaDashBoardController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        starTask();
        comboConti.getItems().addAll(Continente.cargarContinente());

    }

    /**
     *
     */
    @FXML
    private VBox vboxCasos;

    /**
     *
     */
    @FXML
    private VBox vboxMuerte;

    /**
     *
     */
    @FXML
    private VBox vboxCasosDias;

    /**
     *
     */
    @FXML
    private VBox vboxPoblacion;

    /**
     *
     */
    @FXML
    private VBox vboxMuertePorDia;

    /**
     *
     */
    @FXML
    private ComboBox<Continente> comboConti;

    /**
     *
     */
    @FXML
    private ComboBox<Pais> comboPais;

    /**
     *
     */
    @FXML
    private DatePicker fecha;

    /**
     *
     */
    @FXML
    private Button consultar;

    /**
     *
     */
    @FXML
    private VBox rootDash;

    /**
     *
     */
    @FXML
    private Label timepoApp;

    /**
     *
     */
    @FXML
    private Label txtcasos;

    /**
     *
     */
    @FXML
    private Label casos;

    /**
     *
     */
    @FXML
    private Label txtdias;

    /**
     *
     */
    @FXML
    private Label dias;

    /**
     *
     */
    @FXML
    private Label txtpoblacion;

    /**
     *
     */
    @FXML
    private Label poblacion;

    /**
     *
     */
    @FXML
    private Label txtmuertes;

    /**
     *
     */
    @FXML
    private Label muertes;

    /**
     *
     */
    @FXML
    private Label txtMuertedias;

    /**
     *
     */
    @FXML
    private Label diasMuerte;

    /**
     *
     */
    @FXML
    private Button btnCerrar;

    /**
     *
     */
    @FXML
    private ImageView mapa;

    /**
     *
     */
    private static String pob;

    /**
     *
     */
    private static String vid;

    /**
     *
     */
    private static String ed;

    /**
     *
     */
    private static String den;

    /**
     *
     * @param pob
     */
    public static void setPob(String pob) {
        VentanaDashBoardController.pob = pob;
    }

    /**
     *
     * @param vid
     */
    public static void setVid(String vid) {
        VentanaDashBoardController.vid = vid;
    }

    /**
     *
     * @param ed
     */
    public static void setEd(String ed) {
        VentanaDashBoardController.ed = ed;
    }

    /**
     *
     * @param den
     */
    public static void setDen(String den) {
        VentanaDashBoardController.den = den;
    }

    /**
     *
     * @return
     */
    public static String getDen() {
        return den;
    }

    /**
     *
     * @return
     */
    public static String getPob() {
        return pob;
    }

    /**
     *
     * @return
     */
    public static String getVid() {
        return vid;
    }

    /**
     *
     * @return
     */
    public static String getEd() {
        return ed;
    }

    /**
     *
     * @param e
     */
    @FXML
    void consultarAccion(ActionEvent e) {
        LocalDate fechaS = fecha.getValue();
        Continente ct = comboConti.getValue();
        String date;
        Pais p = comboPais.getValue();
        if ((fechaS != null) && (ct != null) && (p != null)) {
            date = fecha.getValue().toString();
            for (String[] lista : datosCovid()) {
                if ((date.equals(lista[3].trim())) && (p.getNombre().equals(lista[2].trim()))) {
                    diasMuerte.setText(lista[7].trim());
                    txtMuertedias.setText("Muertes por dia");
                    txtpoblacion.setText("Poblacion");
                    poblacion.setText(lista[8].trim());
                    muertes.setText(lista[6]);
                    txtmuertes.setText("Muertes");
                    casos.setText(lista[4].trim());
                    txtcasos.setText("Casos");
                    txtdias.setText("Casos por dia");
                    dias.setText(lista[5].trim());
                    txtdias.setStyle("-fx-background-color:blue");
                    txtMuertedias.setStyle("-fx-background-color:blue");
                    txtpoblacion.setStyle("-fx-background-color:blue");
                    txtmuertes.setStyle("-fx-background-color:blue");
                    txtcasos.setStyle("-fx-background-color:blue");
                    pob = lista[11].trim();
                    vid = lista[12].trim();
                    den = lista[9].trim();
                    ed = lista[10].trim();
                    try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + p.getNombre() + "Mapa.jpg")) {
                        Image image = new Image(imput, 77, 51, false, false);
                        mapa.setImage(image);

                    } catch (FileNotFoundException ex) {
                        try (FileInputStream imput = new FileInputStream(PrincipalProyecto.imagesrutes + "notFound.jpg")) {
                            Image image = new Image(imput, 77, 51, false, false);
                            mapa.setImage(image);
                        } catch (IOException ex1) {
                            ex1.printStackTrace();
                  
                        }

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                }

            }
            vboxPoblacion.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPoblacional.fxml"));
                    try {
                        Parent root = loader.load();
                        VentanaPoblacionalController controlador = loader.getController();
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
            vboxMuerte.setStyle("-fx-border-width:1");
            vboxMuerte.setStyle("-fx-border-style:solid");
            vboxCasos.setStyle("-fx-border-width:1");
            vboxCasos.setStyle("-fx-border-style:solid");
            vboxCasosDias.setStyle("-fx-border-width:1");
            vboxCasosDias.setStyle("-fx-border-style:solid");
            vboxPoblacion.setStyle("-fx-border-width:1");
            vboxPoblacion.setStyle("-fx-border-style:solid");
            vboxMuertePorDia.setStyle("-fx-border-width:1");
            vboxMuertePorDia.setStyle("-fx-border-style:solid");

        }

    }

    /**
     *
     * @param e
     */
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

    /**
     *
     * @param e
     */
    @FXML
    void fechaConsulta(ActionEvent e) {
        fecha.setEditable(false);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        fecha.setConverter(new LocalDateStringConverter(formatter, null));

    }

    /**
     *
     * @param e
     */
    @FXML
    void paisEleccion(ActionEvent e) {

    }

    /**
     *
     * @param e
     */
    @FXML
    void cerrar(ActionEvent e) {
        Stage s = (Stage) btnCerrar.getScene().getWindow();
        s.close();

    }

    /**
     *
     * @return
     */
    public static ArrayList<String[]> datosCovid() {
        ArrayList<String[]> listaCovid = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(PrincipalProyecto.filerutes + "owid-covid-data_.csv"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String lista[] = linea.split("\\|");
                listaCovid.add(lista);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return listaCovid;

    }

    /**
     *
     */
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

    /**
     *
     */
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
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}
