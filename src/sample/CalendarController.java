package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CalendarController  implements Initializable {
    public CalendarModel calendarModel = new CalendarModel();
    public String Name;

    @FXML
    private Label l9_11;
    @FXML
    private Label l11_13;
    @FXML
    private Label l13_15;
    @FXML
    private Label l15_17;
    @FXML
    private Label m9_11;
    @FXML
    private Label m11_13;
    @FXML
    private Label m13_15;
    @FXML
    private Label m15_17;
    @FXML
    private Label me9_11;
    @FXML
    private Label me11_13;
    @FXML
    private Label me13_15;
    @FXML
    private Label me15_17;
    @FXML
    private Label j9_11;
    @FXML
    private Label j11_13;
    @FXML
    private Label j13_15;
    @FXML
    private Label j15_17;
    @FXML
    private Label v9_11;
    @FXML
    private Label v11_13;
    @FXML
    private Label v13_15;
    @FXML
    private Label v15_17;
    @FXML
    private Label s9_11;
    @FXML
    private Label s11_13;
    @FXML
    private Label s13_15;
    @FXML
    private Label s15_17;

    @FXML
    private Label Filliereshow;



    public void initialize(URL location, ResourceBundle rb) {
        System.out.println(("Hnaaa"));
        calendarModel.ShowFilliere(CalendarModel.FILLIERE, Filliereshow);
        Name = calendarModel.GetModuleName("9:00", "Lundi");
        calendarModel.enablel(Name,l9_11);
        Name = calendarModel.GetModuleName("11:00", "Lundi");
        calendarModel.enablel(Name,l11_13);
        Name = calendarModel.GetModuleName("13:00", "Lundi");
        calendarModel.enablel(Name,l13_15);
        Name = calendarModel.GetModuleName("15:00", "Lundi");
        calendarModel.enablel(Name,l15_17);
        Name = calendarModel.GetModuleName("9:00", "Mardi");
        calendarModel.enablel(Name,m9_11);
        Name = calendarModel.GetModuleName("11:00", "Mardi");
        calendarModel.enablel(Name,m11_13);
        Name = calendarModel.GetModuleName("13:00", "Mardi");
        calendarModel.enablel(Name,m13_15);
        Name = calendarModel.GetModuleName("15:00", "Mardi");
        calendarModel.enablel(Name,m15_17);
        Name = calendarModel.GetModuleName("9:00", "Mercredi");
        calendarModel.enablel(Name,me9_11);
        Name = calendarModel.GetModuleName("11:00", "Mercredi");
        calendarModel.enablel(Name,me11_13);
        Name = calendarModel.GetModuleName("13:00", "Mercredi");
        calendarModel.enablel(Name,me13_15);
        Name = calendarModel.GetModuleName("15:00", "Mercredi");
        calendarModel.enablel(Name,me15_17);
        Name = calendarModel.GetModuleName("9:00", "Jeudi");
        calendarModel.enablel(Name,j9_11);
        Name = calendarModel.GetModuleName("11:00", "Jeudi");
        calendarModel.enablel(Name,j11_13);
        Name = calendarModel.GetModuleName("13:00", "Jeudi");
        calendarModel.enablel(Name,j13_15);
        Name = calendarModel.GetModuleName("15:00", "Jeudi");
        calendarModel.enablel(Name,j15_17);
        Name = calendarModel.GetModuleName("9:00", "Vendredi");
        calendarModel.enablel(Name,v9_11);
        Name = calendarModel.GetModuleName("11:00", "Vendredi");
        calendarModel.enablel(Name,v11_13);
        Name = calendarModel.GetModuleName("13:00", "Vendredi");
        calendarModel.enablel(Name,v13_15);
        Name = calendarModel.GetModuleName("15:00", "Vendredi");
        calendarModel.enablel(Name,v15_17);
        Name = calendarModel.GetModuleName("9:00", "Samedi");
        calendarModel.enablel(Name,s9_11);
        Name = calendarModel.GetModuleName("11:00", "Samedi");
        calendarModel.enablel(Name,s11_13);
        Name = calendarModel.GetModuleName("13:00", "Samedi");
        calendarModel.enablel(Name,s13_15);
        Name = calendarModel.GetModuleName("15:00", "Samedi");
        calendarModel.enablel(Name,s15_17);
    }
}
