package sample;

import java.sql.*;



public class SQLiteConnection {

    //Connection DB
    public static final String DB_NAME = "Gestionexam.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:" + DB_NAME;
    //User Table Variables
    public static final String TABLE_USER = "user";
    public static final String COLUMN_USERID = "_id";
    public static final String COLUMN_ROLE = "role";
    public static final String COLUMN_FIRSTNAME = "First_Name";
    public static final String COLUMN_LASTNAME = "Last_Name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "encrypted_password";
    //Module Table Variables
    public static final String TABLE_MODULE = "module";
    public static final String COLUMN_MODULE_ID = "_id";
    public static final String COLUMN_MODULE_NAME = "name";
    public static final String COLUMN_PROF_ID = "prof_id";
    //Salle Table Variables
    public static final String TABLE_SALLE = "salle";
    public static final String COLUMN_SALLE_ID = "_id";
    public static final String COLUMN_SALLE_NAME = "name";
    public static final String COLUMN_SALLE_CAPACITY = "salle_capacity";
    //Exam Table VARIABLES
    public static final String TABLE_EXAM = "exam";
    public static final String COLUMN_EXAM_ID = "_id";
    public static final String COLUMN_EXAM_PROF_ID = "prof_id";
    public static final String COLUMN_EXAM_DATE = "Jour";
    public static final String COLUMN_EXAM_STARTTIME = "startTime";
    public static final String COLUMN_EXAM_MODULE_ID = "module_id";
    public static final String COLUMN_EXAM_FILLIERE = "filliere";
    public static final String COLUMN_EXAM_SALLE = "salles_id";
    public static final String COLUMN_EXAM_ISCONFIRMED = "isconfirmed";

    public static Connection Connector(){
        try{

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement =conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USER + "( " +
                    COLUMN_USERID + " integer PRIMARY KEY AUTOINCREMENT, " + COLUMN_ROLE + " text, " + COLUMN_FIRSTNAME + " text, " +
                    COLUMN_LASTNAME + " text, " + COLUMN_EMAIL + " text, " + COLUMN_PASSWORD + " text)");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_MODULE + "( " +
                    COLUMN_MODULE_ID + " integer PRIMARY KEY AUTOINCREMENT," + COLUMN_MODULE_NAME + " text, " + COLUMN_PROF_ID + " integer NOT NULL, " +
                    "FOREIGN KEY (" + COLUMN_PROF_ID + ") REFERENCES " + TABLE_USER + " (" + COLUMN_USERID + "))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_SALLE + "( " +
                    COLUMN_SALLE_ID + " integer PRIMARY KEY AUTOINCREMENT, " + COLUMN_SALLE_NAME + " text, " + COLUMN_SALLE_CAPACITY + " int)");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_EXAM + "( " +
                    COLUMN_EXAM_ID + " integer PRIMARY KEY AUTOINCREMENT, " + COLUMN_EXAM_PROF_ID + " , " + COLUMN_EXAM_DATE + " text NOT NULL, " + COLUMN_EXAM_STARTTIME + " time, " +
                    COLUMN_EXAM_MODULE_ID + " integer NOT NULL, " + COLUMN_EXAM_FILLIERE + " text, "  + COLUMN_EXAM_SALLE + " integer NOT NULL, " +
                    COLUMN_EXAM_ISCONFIRMED + " boolean, FOREIGN KEY (" + COLUMN_EXAM_MODULE_ID + ") REFERENCES " + TABLE_MODULE +
                    " (" + COLUMN_MODULE_ID + "), FOREIGN KEY (" + COLUMN_EXAM_SALLE + ") REFERENCES " +
                    TABLE_SALLE + " (" + COLUMN_SALLE_ID + ")" + " FOREIGN KEY (" + COLUMN_EXAM_PROF_ID + ") REFERENCES " + TABLE_USER + " (" + COLUMN_USERID + "))");

            statement.close();
            return conn;
        } catch(SQLException p){
            System.out.println(p);
            return null;
        }
    }
    public static void InsertSalle (Statement statement, int id, String name, int capacity) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_SALLE +
                "(" + COLUMN_SALLE_ID + ", " + COLUMN_SALLE_NAME + ", " + COLUMN_SALLE_CAPACITY + ") " +
                "VALUES('"+name +"', " +id + "," +capacity + ")" );
    }
}