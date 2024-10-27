package Proj1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

//public class ShowLoc {
//    private Label ltmartyr,ltmale,ltfemale,lavg, lold,lyoung,lloc;
//    private TextField tmartyr,tmale,tfemale,tavg, told,tyoung,tloc;
//    private Button next;
//    private GridPane gpane;
//    private HBox hbox;
//    private Font font;
//    public ShowLoc(){
//        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
//        gpane=new GridPane();
//        hbox=new HBox(80);
//        lavg=new Label("Average martyrs ages :");
//        lold =new Label("oldest martyrs :");
//        ltfemale=new Label("Total number of female martyrs :");
//        ltmale=new Label("Total number of male martyrs :");
//        ltmartyr=new Label("Total number of martyrs :");
//        lyoung=new Label("youngest martyrs :");
//        lloc=new Label("Location name :");
//
//        lavg.setFont(font);
//        lold.setFont(font);
//        ltfemale.setFont(font);
//        ltmale.setFont(font);
//        ltmartyr.setFont(font);
//        lyoung.setFont(font);
//        lloc.setFont(font);
//
//        tloc=new TextField();
//        tavg=new TextField();
//        tfemale=new TextField();
//        tmale=new TextField();
//        told =new TextField();
//        tmartyr=new TextField();
//        tyoung=new TextField();
//        next=new Button("Next");
//
//        gpane.add(lloc,0,0);
//        gpane.add(tloc,1,0);
//        gpane.add(ltmartyr,0,1);
//        gpane.add(ltmale,0,2);
//        gpane.add(ltfemale,0,3);
//        gpane.add(lavg,0,4);
//        gpane.add(lold,0,5);
//        gpane.add(tmartyr,1,1);
//        gpane.add(tmale,1,2);
//        gpane.add(tfemale,1,3);
//        gpane.add(tavg,1,4);
//        gpane.add(told,1,5);
//        gpane.add(lyoung,0,6);
//        gpane.add(tyoung,1,6);
//        gpane.setHgap(20);
//        gpane.setVgap(30);
//        gpane.setAlignment(Pos.CENTER);
//        gpane.setPadding(new Insets(25));
//        hbox.getChildren().addAll(next);
//        hbox.setAlignment(Pos.CENTER);
//        hbox.setPadding(new Insets(25));
//
//
//    }
//
//    public Label getLtmartyr() {
//        return ltmartyr;
//    }
//
//    public TextField getTmartyr() {
//        return tmartyr;
//    }
//
//    public TextField getTmale() {
//        return tmale;
//    }
//
//    public TextField getTfemale() {
//        return tfemale;
//    }
//
//    public TextField getTavg() {
//        return tavg;
//    }
//
//    public TextField getTold() {
//        return told;
//    }
//
//    public Button getNext() {
//        return next;
//    }
//
//    public TextField getTloc() {
//        return tloc;
//    }
//
//    public GridPane getGpane() {
//        return gpane;
//    }
//
//    public HBox getHbox() {
//        return hbox;
//    }
//
//    public TextField getTyoung() {
//        return tyoung;
//    }
//}
