package Proj2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
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

public class MartyrScreen {
    private Label lshow,lins,ldel,lAgesort,lupd,ldate,lavg,lyoung,lold;
    private TextField tdate,tyoung,told,tavg;
    private Button btnins,btndel,btnsort,btnshow,btnupd,back,next,prev,show;
    private GridPane gpane ;
    private HBox hnext;
    private VBox vshow,cvbox;
    private ComboBox<String> cloc , cdis;
    private Font font;

    public MartyrScreen(){
        back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
        back.setStyle("-fx-background-color: transparent;");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setPadding(new Insets(25));
        gpane=new GridPane();
        vshow=new VBox(10);
        hnext=new HBox(80);
        cvbox=new VBox(30);
        lAgesort=new Label("Sort By Age Martyr :");
        lshow=new Label("Navigate throw dates :");
        ldel=new Label("Delete Martyr :");
        lins=new Label("Insert Martyr :");
        lupd=new Label("Update Martyr :");
        ldate=new Label("Martyr Date :");
        lavg=new Label("Average Martyr :");
        lyoung=new Label("Youngest Martyr :");
        lold=new Label("Oldest Martyr :");

        tdate=new TextField();
        told=new TextField();
        tavg=new TextField();
        tyoung=new TextField();
        tdate.setMaxWidth(220);
        tavg.setMaxWidth(220);
        tyoung.setMaxWidth(220);
        told.setMaxWidth(220);
        cloc=new ComboBox<>();
        cdis=new ComboBox<>();

        btndel=new Button("Delete");
        btnins=new Button("Insert");
        btnsort=new Button("View");
        btnshow=new Button("Show");
        btnupd=new Button("Update");
        next=new Button("Next");
        prev=new Button("Prev");
        show=new Button("Show Martyr List");

        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        lAgesort.setFont(font);
        lshow.setFont(font);
        ldel.setFont(font);
        lins.setFont(font);
        btndel.setFont(font);
        btnins.setFont(font);
        btnsort.setFont(font);
        btnshow.setFont(font);
        lupd.setFont(font);
        btnupd.setFont(font);
        next.setFont(font);
        prev.setFont(font);
        show.setFont(font);
        ldate.setFont(font);
        lavg.setFont(font);
        lyoung.setFont(font);
        lold.setFont(font);

        double buttonWidth = 180;
        btndel.setMinWidth(buttonWidth);
        btnins.setMinWidth(buttonWidth);
        btnshow.setMinWidth(buttonWidth);
        btnsort.setMinWidth(buttonWidth);
        btnupd.setMinWidth(buttonWidth);
        next.setMinHeight(25);
        next.setMinWidth(120);
        prev.setMinWidth(120);
        prev.setMinHeight(25);
        show.setMinHeight(25);
        show.setMinWidth(120);

        double buttonHeight = 35;
        btndel.setMinHeight(buttonHeight);
        btnins.setMinHeight(buttonHeight);
        btnshow.setMinHeight(buttonHeight);
        btnsort.setMinHeight(buttonHeight);
        btnupd.setMinHeight(buttonHeight);

        gpane.add(lins,0,0);
        gpane.add(btnins,0,1);
        gpane.add(ldel,0,2);
        gpane.add(btndel,0,3);
        gpane.add(lupd,0,4);
        gpane.add(btnupd,0,5);
//        gpane.add(lshow,0,3);
//        gpane.add(btnshow,1,3);
        gpane.add(lAgesort,0,6);
        gpane.add(btnsort,0,7);
        gpane.setHgap(20);
        gpane.setVgap(10);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));
        hnext.getChildren().addAll(prev,next);
        hnext.setAlignment(Pos.CENTER);

        vshow.getChildren().addAll(ldate,tdate,lavg,tavg,lold,told,lyoung,tyoung,hnext,show);
        vshow.setAlignment(Pos.CENTER);
        vshow.setPadding(new Insets(25));

        cvbox.getChildren().addAll(cdis,cloc);
        cvbox.setAlignment(Pos.TOP_CENTER);
        cvbox.setPadding(new Insets(25));



    }

    public VBox getCvbox() {
        return cvbox;
    }

    public ComboBox<String> getCdis() {
        return cdis;
    }

    public TextField getTold() {
        return told;
    }

    public Label getLshow() {
        return lshow;
    }

    public ComboBox<String> getCloc() {
        return cloc;
    }

    public TextField getTdate() {
        return tdate;
    }

    public TextField getTyoung() {
        return tyoung;
    }

    public TextField getTavg() {
        return tavg;
    }

    public Button getNext() {
        return next;
    }

    public Button getPrev() {
        return prev;
    }

    public Button getShow() {
        return show;
    }

    public VBox getVshow() {
        return vshow;
    }

    public Button getBtnins() {
        return btnins;
    }

    public Button getBtndel() {
        return btndel;
    }

    public Button getBtnsort() {
        return btnsort;
    }

    public Button getBtnshow() {
        return btnshow;
    }

    public Button getBtnupd() {
        return btnupd;
    }

    public Button getBack() {
        return back;
    }

    public GridPane getGpane() {
        return gpane;
    }
}
