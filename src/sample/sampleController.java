package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class sampleController  implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), pane);
        t.setToX(pane.getLayoutX()*20);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
                pane.getChildren().removeAll();
                pane.getChildren().setAll(fxml);
            }  catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
    @FXML
    private void open_signin(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), pane);
        t.setToX(pane.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
                pane.getChildren().removeAll();
                pane.getChildren().setAll(fxml);
            }catch(IOException ex){

            }
        });
    }
    @FXML
    private void open_signup(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), pane);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                pane.getChildren().removeAll();
                fxml = FXMLLoader.load(getClass().getResource("Filliere.fxml"));
                pane.getChildren().setAll(fxml);
            }catch(IOException ex){

            }
        });
    }
}