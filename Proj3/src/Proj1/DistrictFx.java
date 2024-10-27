package Proj1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class DistrictFx {
    private Label ldis,lshow,lsearch,larea,lres,lins,ldel,lupd,linsert,lupdate1,lupdate2,ldelete,DISNAME,DMAR;
    private TextField t1,tins,tupd2,tname,ttotal;
    private Button btnshow,btnsearch,btndel,btnins,btnupdate,update,delete,insert,back,next,prev,load;
    private GridPane gpane,gpane2;
    private HBox hBox,hboxins,hboxdel,hnext;
    private VBox vBoxupdate,vshow,vshow2;
    private Font font;
    private ComboBox<String> tdel,tupd1;
    public DistrictFx(){
        vshow=new VBox(10);
        vshow2=new VBox(10);
        hnext=new HBox(80);
        back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
        back.setStyle("-fx-background-color: transparent;");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setPadding(new Insets(25));
        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        hBox=new HBox();
        hboxins=new HBox(7);
        hboxdel=new HBox(7);
        vBoxupdate =new VBox(10);
        gpane=new GridPane();
        gpane2=new GridPane();
        t1=new TextField();
        ldis=new Label("Insert and operations on district :");
        larea=new Label("District :");
        lsearch=new Label("Total number of martyrs for a given date :");
        lshow=new Label("show the statistics of districts :");
        lres=new Label("res");
        lupd=new Label("Update District :");
        lins=new Label("Insert District :");
        ldel=new Label("Delete District :");
        linsert=new Label("Enter the name :");
        lupdate1=new Label("Enter the old name :");
        lupdate2=new Label("Enter the new name :");
        ldelete=new Label("Enter the name :");
        DISNAME=new Label("District Name :");
        DMAR=new Label("Total Martyr :");
        DMAR.setFont(font);
        DISNAME.setFont(font);
        lres.setFont(font);
        larea.setFont(font);
        ldis.setFont(font);
        lshow.setFont(font);
        lsearch.setFont(font);
        ldel.setFont(font);
        lins.setFont(font);
        lupd.setFont(font);
        linsert.setFont(font);
        lupdate1.setFont(font);
        lupdate2.setFont(font);
        ldelete.setFont(font);

        tins=new TextField();
        tdel=new ComboBox<>();
        tupd1=new ComboBox<>();
        tupd2=new TextField();
        tname=new TextField();
        ttotal=new TextField();
        ttotal.setMaxWidth(220);
        tname.setMaxWidth(220);
        tupd1.setMaxWidth(200);
        tupd2.setMaxWidth(200);


        btndel=new Button("Delete");
        btnins=new Button("Insert");
        btnshow=new Button("Show");
        btnsearch=new Button("Calculate");
        btnupdate=new Button("Update");
        update=new Button("Update");
        delete=new Button("Delete");
        insert=new Button("Insert");
        next=new Button("Next");
        prev=new Button("Prev");
        load=new Button("Load District");

        double buttonWidth = 180;
        btndel.setMinWidth(buttonWidth);
        btnins.setMinWidth(buttonWidth);
        btnshow.setMinWidth(buttonWidth);
        btnsearch.setMinWidth(buttonWidth);
        btnupdate.setMinWidth(buttonWidth);
        update.setMinWidth(buttonWidth);
        delete.setMinWidth(buttonWidth);
        insert.setMinWidth(buttonWidth);
        next.setMinWidth(120);
        prev.setMinWidth(120);



        double buttonHeight = 35;
        btndel.setMinHeight(buttonHeight);
        btnins.setMinHeight(buttonHeight);
        btnshow.setMinHeight(buttonHeight);
        btnsearch.setMinHeight(buttonHeight);
        btnupdate.setMinHeight(buttonHeight);
        update.setMinHeight(buttonHeight);
        delete.setMinHeight(buttonHeight);
        insert.setMinHeight(buttonHeight);
        next.setMinHeight(25);
        prev.setMinHeight(25);
        load.setMinWidth(120);
        load.setMinHeight(25);

        btndel.setFont(font);
        btnins.setFont(font);
        btnshow.setFont(font);
        btnsearch.setFont(font);
        btnupdate.setFont(font);
        update.setFont(font);
        delete.setFont(font);
        insert.setFont(font);
        next.setFont(font);
        prev.setFont(font);
        load.setFont(font);


        gpane.add(lins,0,0);
        gpane.add(btnins,0,1);
        gpane.add(lupd,0,2);
        gpane.add(btnupdate,0,3);
        gpane.add(btndel,0,5);
        gpane.add(ldel,0,4);
//        gpane.add(lshow,0,6);
//        gpane.add(btnshow,0,7);
//        gpane.add(lsearch,0,8);
//        gpane.add(btnsearch,0,9);

        gpane.setHgap(20);
        gpane.setVgap(10);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));
//        gpane2.add(larea,0,0);
//        gpane2.add(t1,1,0);
//        gpane2.add(btnins,1,1);
//        gpane2.add(btndel,1,2);
//        gpane2.add(btnupdate,1,3);
//        gpane2.setAlignment(Pos.CENTER);
//        gpane2.setHgap(20);
//        gpane2.setVgap(30);
//        gpane2.setPadding(new Insets(25));

        hBox.getChildren().add(lres);
        hBox.setPadding(new Insets(25));
        hBox.setAlignment(Pos.CENTER);

        hboxdel.getChildren().addAll(ldelete,tdel,delete);
        hboxdel.setAlignment(Pos.CENTER);
        hboxdel.setPadding(new Insets(25));

        hboxins.getChildren().addAll(linsert,tins,insert);
        hboxins.setAlignment(Pos.CENTER);
        hboxins.setPadding(new Insets(25));

        vBoxupdate.getChildren().addAll(lupdate1,tupd1,lupdate2,tupd2,update);
        vBoxupdate.setAlignment(Pos.CENTER);
        vBoxupdate.setPadding(new Insets(25));

        hnext.getChildren().addAll(prev,next);
        hnext.setAlignment(Pos.CENTER);

        vshow.getChildren().addAll(DISNAME,tname,DMAR,ttotal,hnext,load);
        vshow.setAlignment(Pos.CENTER);
        vshow.setPadding(new Insets(25));


    }

    public VBox getVshow() {
        return vshow;
    }

    public Button getBack() {
        return back;
    }

    public Label getLdis() {
        return ldis;
    }

    public TextField getTins() {
        return tins;
    }

    public ComboBox<String> getTdel() {
        return tdel;
    }

    public ComboBox<String> getTupd1() {
        return tupd1;
    }

    public TextField getTupd2() {
        return tupd2;
    }

    public Button getUpdate() {
        return update;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getInsert() {
        return insert;
    }

    public HBox getHboxins() {
        return hboxins;
    }

    public HBox getHboxdel() {
        return hboxdel;
    }

    public VBox getvBoxupdate() {
        return vBoxupdate;
    }

    public TextField getT1() {
        return t1;
    }

    public HBox gethBox() {
        return hBox;
    }



    public Button getBtnshow() {
        return btnshow;
    }

    public Button getBtnsearch() {
        return btnsearch;
    }


    public Label getLshow() {
        return lshow;
    }

    public TextField getTname() {
        return tname;
    }

    public TextField getTtotal() {
        return ttotal;
    }

    public Button getNext() {
        return next;
    }

    public Button getPrev() {
        return prev;
    }

    public Button getLoad() {
        return load;
    }

    public Button getBtndel() {
        return btndel;
    }

    public Button getBtnins() {
        return btnins;
    }

    public Label getLres() {
        return lres;
    }

    public Button getBtnupdate() {
        return btnupdate;
    }

    public GridPane getGpane() {
        return gpane;
    }

    public GridPane getGpane2() {
        return gpane2;
    }
}
