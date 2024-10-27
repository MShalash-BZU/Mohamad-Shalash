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

//public class ShowFx {
//    private Label ltmartyr,ltmale,ltfemale,lavg,lmax,ldis;
//    private TextField tmartyr,tmale,tfemale,tavg,tmax,tdis;
//    private Button next,prev,load;
//    private GridPane gpane;
//    private HBox hbox;
//    private Font font;
//    public ShowFx(){
//        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
//        gpane=new GridPane();
//        hbox=new HBox(80);
//        lavg=new Label("Average martyrs ages :");
//        lmax =new Label("Date has maximum martyrs :");
//        ltfemale=new Label("Total number of female martyrs :");
//        ltmale=new Label("Total number of male martyrs :");
//        ltmartyr=new Label("Total number of martyrs :");
//        ldis=new Label("District name :");
//
//        lavg.setFont(font);
//        lmax.setFont(font);
//        ltfemale.setFont(font);
//        ltmale.setFont(font);
//        ltmartyr.setFont(font);
//        ldis.setFont(font);
//
//        tavg=new TextField();
//        tfemale=new TextField();
//        tmale=new TextField();
//        tmax=new TextField();
//        tmartyr=new TextField();
//        tdis=new TextField();
//        next=new Button("Next");
//        prev=new Button("Prev");
//        load=new Button("Load District");
//        next.setFont(font);
//        prev.setFont(font);
//        load.setFont(font);
//        load.setAlignment(Pos.BOTTOM_LEFT);
//        gpane.add(ldis,0,0);
//        gpane.add(tdis,1,0);
//        gpane.add(ltmartyr,0,1);
//        gpane.add(ltmale,0,2);
//        gpane.add(ltfemale,0,3);
//        gpane.add(lavg,0,4);
//        gpane.add(lmax,0,5);
//        gpane.add(tmartyr,1,1);
//        gpane.add(tmale,1,2);
//        gpane.add(tfemale,1,3);
//        gpane.add(tavg,1,4);
//        gpane.add(tmax,1,5);
//        gpane.setHgap(20);
//        gpane.setVgap(30);
//        gpane.setAlignment(Pos.CENTER);
//        gpane.setPadding(new Insets(25));
//        hbox.getChildren().addAll(prev,next,load);
//        hbox.setAlignment(Pos.CENTER);
//        hbox.setPadding(new Insets(25));
//
//
//    }
//
//
//    public TextField getTdis() {
//        return tdis;
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
//    public Button getLoad() {
//        return load;
//    }
//
//    public TextField getTavg() {
//        return tavg;
//    }
//
//    public TextField getTmax() {
//        return tmax;
//    }
//
//    public Button getNext() {
//        return next;
//    }
//
//    public Button getPrev() {
//        return prev;
//    }
//
//    public GridPane getGpane() {
//        return gpane;
//    }
//
//    public HBox getHbox() {
//        return hbox;
//    }
//}
