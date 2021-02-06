package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FilliereController implements Initializable {
    ObservableList<String> list = FXCollections.observableArrayList();
    public FilliereModel filliereModel =  new FilliereModel();

    @FXML
    private ComboBox<String> Fill;

    @FXML
    private Button submit;

    public void initialize(URL location, ResourceBundle rb){
        submit.setDisable(true);
        filliereModel.loadData(Fill);
    }

    public void ActivateSubmit(){
        String filliere = Fill.getValue();
        if (filliere != null){
            submit.setDisable(false);
        }
    }

    public void Submit(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        Stage primaryStage = new Stage();
        CalendarModel.FILLIERE = Fill.getValue();
        Parent root = loader.load(getClass().getResource("Calendar.fxml").openStream());
        CalendarController calendarController = (CalendarController) loader.getController();
        System.out.println("Hnaa 2");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

}
