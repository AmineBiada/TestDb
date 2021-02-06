package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LoginController  implements Initializable {
    public LoginModel loginmodel = new LoginModel();

    @FXML
    private Label isConnected;

    @FXML
    private TextField TextEmail;

    @FXML
    private TextField TextPassword;
    @FXML
    private Button LoginButton;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        LoginButton.setDisable(true);
        if(loginmodel.isDBConnected()){
            isConnected.setText("             Connected");
        }
        else {
            isConnected.setText("         Not Connected");
        }
    }

    public void enableButton(){
        String mail=TextEmail.getText();
        String pass=TextPassword.getText();
        boolean isDisabled = ((mail.isEmpty() || mail.trim().isEmpty() ) || (pass.trim().isEmpty() || pass.isEmpty()));
        LoginButton.setDisable(isDisabled);
    }

    public void Login(ActionEvent event) throws SQLException {
        String role;
        try {
            System.out.println(TextEmail.getText() + " " + TextPassword.getText());
            if (loginmodel.isLogin(TextEmail.getText(), TextPassword.getText())){
                role = loginmodel.GetUserRole(TextEmail.getText(),TextPassword.getText());
                isConnected.setText("Email and Password are Correct");
                if(role.equals("Professeur")) {
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    Stage primaryStage = new Stage();
                    Parent root = loader.load(getClass().getResource("User.fxml").openStream());
                    UserController userController = (UserController) loader.getController();
                    UserController.FLName = loginmodel.GetUserFLName(TextEmail.getText(), TextPassword.getText());
                    UserController.Role = loginmodel.GetUserRole(TextEmail.getText(), TextPassword.getText());
                    userController.GetUSERFLname(UserController.FLName);
                    Scene scene = new Scene(root);
                    scene.setFill(Color.TRANSPARENT);
                    primaryStage.setScene(scene);
                    primaryStage.initStyle(StageStyle.TRANSPARENT);
                    primaryStage.show();
                }
                else if(role.equals("Administrateur")){
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    Stage primaryStage = new Stage();
                    Parent root = loader.load(getClass().getResource("Administrateur.fxml").openStream());
                    root.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    AdminController adminController = (AdminController) loader.getController();
                    AdminController.FLName = loginmodel.GetUserFLName(TextEmail.getText(), TextPassword.getText());
                    AdminController.Role = loginmodel.GetUserRole(TextEmail.getText(), TextPassword.getText());
                    adminController.GetUSERFLname(AdminController.FLName);
                    Scene scene = new Scene(root);
                    scene.setFill(Color.TRANSPARENT);
                    primaryStage.setScene(scene);
                    primaryStage.initStyle(StageStyle.TRANSPARENT);
                    primaryStage.show();
                }

            }
            else{
                isConnected.setText("Email or Password are inCorrect");
            }
        } catch (SQLException | IOException e){
            e.printStackTrace();
            isConnected.setText("Email or Password are");
        }
    }

}
