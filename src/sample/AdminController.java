package sample;
// yuw ywuw ywuw ywuw yuww
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class AdminController  implements Initializable {

    AdminModel adminModel;
    public static String FLName;
    public static String Role;
    private static final String STANDARD_BUTTON_STYLE = "-fx-background-color: transparent;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";

    ObservableList<TableModel> olist = FXCollections.observableArrayList();

    @FXML
    private Button adminbutton;

    @FXML
    private Button Validatebutton;

    @FXML
    private Button Deletebutton;

    @FXML
    private TextField textField;

    @FXML
    private TableView<TableModel> table;

    @FXML
    private TableColumn<TableModel, String> colmodule;

    @FXML
    private TableColumn<TableModel, String> coldate;

    @FXML
    private TableColumn<TableModel, String> colstime;

    @FXML
    private TableColumn<TableModel, String> colfill;

    @Override
    public void initialize(URL location, ResourceBundle rb) {

        Validatebutton.setDisable(true);
        Deletebutton.setDisable(true);
        //adminbutton.setStyle(STANDARD_BUTTON_STYLE);
        //userbutton.setOnMouseEntered(e -> userbutton.setStyle(HOVERED_BUTTON_STYLE));
        adminbutton.setOnMouseEntered(e -> adminbutton.setText(Role));
        //userbutton.setOnMouseExited(e -> userbutton.setStyle(IDLE_BUTTON_STYLE));
        adminbutton.setOnMouseExited(e -> adminbutton.setText(FLName));


        try {
            Connection connection = SQLiteConnection.Connector();
            System.out.println("hi");
            ResultSet results = connection.createStatement().executeQuery("SELECT  module.name, exam.startTime , exam.Jour, exam.filliere FROM exam INNER JOIN module ON exam.module_id = module._id WHERE exam.isconfirmed=0");
//            ResultSet results = connection.createStatement().executeQuery("SELECT " + SQLiteConnection.COLUMN_EXAM_MODULE_ID + ", " +
//                    SQLiteConnection.COLUMN_EXAM_DATE + ", " + SQLiteConnection.COLUMN_EXAM_STARTTIME + ", " +
//                    SQLiteConnection.COLUMN_EXAM_ENDTIME +
//                    " FROM " + SQLiteConnection.TABLE_EXAM +
//                    " WHERE " + SQLiteConnection.COLUMN_EXAM_ISCONFIRMED + " = 0");
            while (results.next()) {
                olist.add(new TableModel(results.getString("name"),//Modify hadi
                        results.getString(SQLiteConnection.COLUMN_EXAM_DATE),
                        results.getString(SQLiteConnection.COLUMN_EXAM_STARTTIME),
                        results.getString(SQLiteConnection.COLUMN_EXAM_FILLIERE)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        colmodule.setCellValueFactory(new PropertyValueFactory<>("Module"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colstime.setCellValueFactory(new PropertyValueFactory<>("Starttime"));
        colfill.setCellValueFactory(new PropertyValueFactory<>("Filliere"));

        table.setItems(olist);
    }

    public void GetUSERFLname(String name) {
        adminbutton.setText(name);
    }

    public void Activatebuttons() {
        String s = textField.getText();
        if (s != null) {
            Validatebutton.setDisable(false);
            Deletebutton.setDisable(false);
        }
    }

    public void Update(ActionEvent actionEvent) throws SQLException {
        String s = textField.getText();
        Updatee(s);
    }
    public void Updatee(String s) throws SQLException{
        update2(s);
    }

    static void update2(String s) {
        String sql = "UPDATE " + SQLiteConnection.TABLE_EXAM + " SET " + SQLiteConnection.COLUMN_EXAM_ISCONFIRMED +
                "=1 WHERE " + SQLiteConnection.COLUMN_EXAM_ID + "=?";
        try (Connection conn = SQLiteConnection.Connector();
             PreparedStatement ptmt = conn.prepareStatement(sql)) {


            ptmt.setString(1,s);
            ptmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}