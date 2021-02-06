package sample;

import javafx.scene.control.Label;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalendarModel {
    public static String FILLIERE;

    public String GetModuleName(String s, String jour){
        Connection connection =SQLiteConnection.Connector();
        try {
            ResultSet results = connection.createStatement().executeQuery(
                    "SELECT " + SQLiteConnection.TABLE_MODULE + "." + SQLiteConnection.COLUMN_MODULE_NAME +
                            " FROM " + SQLiteConnection.TABLE_EXAM + " INNER JOIN " + SQLiteConnection.TABLE_MODULE +
                            " ON " + SQLiteConnection.TABLE_EXAM + "." + SQLiteConnection.COLUMN_EXAM_MODULE_ID +
                            " = " + SQLiteConnection.TABLE_MODULE + "." + SQLiteConnection.COLUMN_MODULE_ID +
                            " WHERE " + SQLiteConnection.TABLE_EXAM + "." + SQLiteConnection.COLUMN_EXAM_STARTTIME +
                            " = '" + s + "' AND " + SQLiteConnection.COLUMN_EXAM_FILLIERE + "='" + FILLIERE +"' AND " +
                            SQLiteConnection.COLUMN_EXAM_DATE + "='" + jour + "' AND " + SQLiteConnection.COLUMN_EXAM_ISCONFIRMED + "=1");
            return results.getString("name");
        } catch (SQLException e){
            return "NotFound";
        }
    }
    public void ShowFilliere(String filliere, Label label){
        label.setText("Planning Controls Finaux, Filliere : " + filliere);
    }
    public void enablel(String name, Label label){
        if(name.equals("NotFound")){
            label.setVisible(false);
        }
        else{
            label.setVisible(true);
            label.setText(name);
        }
    }
}
