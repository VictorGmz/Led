module com.clase.led {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.clase.led to javafx.fxml;
    exports com.clase.led;
}
