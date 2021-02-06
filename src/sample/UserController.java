package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UserController  implements Initializable {

    @FXML
    private Button userbutton;
    public static String FLName;
    public static String Role;
    private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: transparent;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";


    @Override
    public void initialize(URL location, ResourceBundle rb){

        //userbutton.setStyle(STANDARD_BUTTON_STYLE);
        //userbutton.setOnMouseEntered(e -> userbutton.setStyle(HOVERED_BUTTON_STYLE));
        userbutton.setOnMouseEntered(e -> userbutton.setText(Role));
        //userbutton.setOnMouseExited(e -> userbutton.setStyle(IDLE_BUTTON_STYLE));
        userbutton.setOnMouseExited(e -> userbutton.setText(FLName));
    }

    public void GetUSERFLname(String name){
        userbutton.setText(name);
    }


}