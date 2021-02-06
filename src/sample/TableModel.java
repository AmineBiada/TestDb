package sample;

public class TableModel {

    public String getFilliere() {
        return Filliere;
    }

    String Module;
    String Date;
    String Starttime;
    String Filliere;

    public TableModel(String module, String date, String starttime, String filliere) {
        Module = module;
        Date = date;
        Starttime = starttime;
        Filliere = filliere;
    }

    public String getModule() {
        return Module;
    }

    public String getDate() {
        return Date;
    }

    public String getStarttime() {
        return Starttime;
    }




}
