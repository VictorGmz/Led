package com.clase.led;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.When;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;

public class PrimaryController implements Initializable {

    @FXML
    private ShapeLed shapeLed;
    @FXML
    private ColorPicker cpicker;
    @FXML
    private ToggleButton boton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cpicker.setValue(Color.RED);

        boton.textProperty().bind(new When(shapeLed.onProperty())
                .then("ON")
                .otherwise("OFF"));
        //No funciona, entra en conflicto con el Hover
        //shapeLed.ledColorProperty().bind(cpicker.valueProperty());
        shapeLed.borderColorProperty().bind(cpicker.valueProperty());

    }

    //4. Crea una interfaz que haga uso del led, con un botón de tipo switch 
    //para activarlo/desactivarlo y un ColorPicker para elegir el color de borde
    //y led
    //Boton tipo SWITCH
    @FXML
    private void parpadeoButton(ActionEvent event) {
        if (!shapeLed.isOn()) {
            shapeLed.setBlinking(false);
            shapeLed.setOn(true);
        } else {
            shapeLed.setBlinking(false);
            shapeLed.setOn(false);
        }
    }
    //Color Picker
    @FXML
    private void colorBorde(ActionEvent event) {
        //Como no se puede hacer el bind por entrar en conflixto con el hover
        //usamos el onAction del Color picker
        shapeLed.setLedColor(cpicker.getValue());
        //shapeLed.setBorderColor(cpicker.getValue());
    }

    //5. Cambia el control para dibujar un cuadrado en lugar de un círculo, con 
    //las mismas características, borde, colores y gradientes. Pistas: solo 
    //debes modificar el método draw, tendrás que desplazar los rectángulos para
    //centrarlos, y debes usar el relleno Color.TRANSPARENT
    private String ejercicio5() {
        return "Realizado directamente sobre la clase ShapeLed"
                + "Modificando el método draw, que ha pasado a llamarse"
                + "drawRectangle y drawCircle respectivamente"
                + "drawCircle está comentado, ya que no se pide";
    }
}
