module com.poo_espol.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.poo_espol.mavenproject1 to javafx.fxml;
    exports com.poo_espol.mavenproject1;
}
