package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class FilliereModel {

    ObservableList<String> list = FXCollections.observableArrayList();

    public void loadData(ComboBox<String> choicebox){
        String a = "2AP1";
        String b = "2AP2";
        String c = "GI1";
        String d = "GC1";
        String e = "GSTR1";
        String f = "GM1";
        String g = "SCM1";
        String h = "GI2";
        String i = "GC2";
        String j = "GSTR2";
        String k = "GM2";
        String l = "SCM2";
        String m = "GI3";
        String n = "GC3";
        String o = "GSTR3";
        String p = "GM3";
        String q = "SCM3";


        list.addAll(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q);
        choicebox.getItems().addAll(list);
    }
}
