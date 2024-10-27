package Proj1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LocationFx {
    private Label lloc,lshow,larea,lmar,lres,lins,ldel,lupd,ldis,ldelloc,lupdloc1,lupdloc2,lupdis,ldisdel,lname,loldest,llates,lmax;
    private TextField t1,t2,tloc,tupd2,tname,told,tlate,tmax;
    private Button btnins,btnshow,btndel,btninsloc,btnupdate,btndelloc,btnupdloc,insert,delete,update,back,next,prev,load;
    private GridPane gpane,gpane2,gpane3;
    private HBox hboxdel,hres,hnext;
    private VBox vBoxupdate,vboxins,vboxdel,vshow;
    private ComboBox<String > tdis,tdel,tupd1,upddis,tdisdel,cdis;
    private Font font;
    private String[] arr;
    public LocationFx(){
        back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
        back.setStyle("-fx-background-color: transparent;");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setPadding(new Insets(25));
        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        gpane=new GridPane();
        gpane2=new GridPane();
        vboxdel=new VBox(10);
        gpane3=new GridPane();
        hboxdel=new HBox(8);
        vBoxupdate=new VBox(15);
        vboxins=new VBox(15);
        hres=new HBox();
        hnext=new HBox(80);
        vshow=new VBox(10);

        t1=new TextField();
        tname=new TextField();
        tmax=new TextField();
        told=new TextField();
        tlate=new TextField();
        arr= new String[0];
        tdis=new ComboBox<>();
        upddis=new ComboBox<>();
        tdisdel=new ComboBox<>();
        cdis=new ComboBox<>();
        tloc=new TextField();
        tdel=new ComboBox<>();
        tupd1=new ComboBox<>();
        tupd2=new TextField();
        tname.setMaxWidth(220);
        tlate.setMaxWidth(220);
        tmax.setMaxWidth(220);
        told.setMaxWidth(220);
        tdis.setMaxWidth(200);
        tloc.setMaxWidth(200);
        tupd2.setMaxWidth(200);
        tupd1.setMaxWidth(200);
        lloc =new Label("Enter the location name :");
        larea=new Label("District :");
        lupdis=new Label("Enter the District :");
        lmar=new Label("enter martyr :");
        lres=new Label("res");
        ldis=new Label("Enter the District name :");
        ldisdel=new Label("Enter the District :");
        lins=new Label("Insert Location :");
        ldel=new Label("Delete location :");
        lupd=new Label("Update Location :");
        ldelloc=new Label("Enter the name location :");
        lupdloc1=new Label("Enter the old name :");
        lupdloc2=new Label("Enter the new name :");
        lname=new Label("Location Name :");
        lmax=new Label("Max Date :");
        loldest=new Label("Earliest Date :");
        llates=new Label("latest Date :");
        lname.setFont(font);
        llates.setFont(font);
        lmax.setFont(font);
        loldest.setFont(font);
        lupd.setFont(font);
        lins.setFont(font);
        ldel.setFont(font);
        lres.setFont(font);
        lshow=new Label("show the statistics of districts :");
        larea.setFont(font);
        lshow.setFont(font);
        lupdis.setFont(font);
        ldisdel.setFont(font);
        lmar.setFont(font);
        ldelloc.setFont(font);
        lupdloc1.setFont(font);
        lupdloc2.setFont(font);




        btndel=new Button("Delete");
        btninsloc=new Button("Insert Location");
        btnins=new Button("Insert");
        btnshow=new Button("Show");
        btnupdate=new Button("Update");
        btndelloc=new Button("Delete");
        btnupdloc=new Button("Update");
        insert=new Button("Insert");
        delete=new Button("Delete");
        update=new Button("Update");
        next=new Button("Next");
        prev=new Button("Prev");
        load=new Button("Load Location");


        btndel.setFont(font);
        btninsloc.setFont(font);
        btnins.setFont(font);
        btnshow.setFont(font);
        btnupdate.setFont(font);
        btndelloc.setFont(font);
        btnupdloc.setFont(font);
        insert.setFont(font);
        delete.setFont(font);
        update.setFont(font);
        next.setFont(font);
        prev.setFont(font);
        load.setFont(font);

        double buttonWidth = 180;
        btndel.setMinWidth(buttonWidth);
        btninsloc.setMinWidth(buttonWidth);
        btnins.setMinWidth(buttonWidth);
        btnshow.setMinWidth(buttonWidth);
        btnupdate.setMinWidth(buttonWidth);
        btndelloc.setMinWidth(buttonWidth);
        btnupdloc.setMinWidth(buttonWidth);
        insert.setMinWidth(buttonWidth);
        delete.setMinWidth(buttonWidth);
        update.setMinWidth(buttonWidth);
        next.setMinHeight(25);
        prev.setMinHeight(25);
        load.setMinWidth(120);
        load.setMinHeight(25);



        double buttonHeight = 35;
        btndel.setMinHeight(buttonHeight);
        btninsloc.setMinHeight(buttonHeight);
        btnins.setMinHeight(buttonHeight);
        btnshow.setMinHeight(buttonHeight);
        btnupdate.setMinHeight(buttonHeight);
        btndelloc.setMinHeight(buttonHeight);
        btnupdloc.setMinHeight(buttonHeight);
        insert.setMinHeight(buttonHeight);
        delete.setMinHeight(buttonHeight);
        update.setMinHeight(buttonHeight);
        next.setMinWidth(120);
        prev.setMinWidth(120);




        gpane.add(lins,0,0);
        gpane.add(btninsloc,0,1);
        gpane.add(lupd,0,2);
        gpane.add(btnupdloc,0,3);
        gpane.add(ldel,0,4);
        gpane.add(btndelloc,0,5);
//        gpane.add(lshow,0,3);
//        gpane.add(btnshow,1,3);
        gpane.setHgap(20);
        gpane.setVgap(10);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));

        vboxdel.getChildren().addAll(ldisdel,tdisdel,ldelloc,tdel,delete);
        vboxdel.setAlignment(Pos.CENTER);
        vboxdel.setPadding(new Insets(25));

        vboxins.getChildren().addAll(ldis,tdis,lloc,tloc,insert);
        vboxins.setPadding(new Insets(25));
        vboxins.setAlignment(Pos.CENTER);

        vBoxupdate.getChildren().addAll(lupdis,upddis,lupdloc1,tupd1,lupdloc2,tupd2,update);
        vBoxupdate.setAlignment(Pos.CENTER);
        vBoxupdate.setPadding(new Insets(25));

        hres.getChildren().add(lres);
        hres.setAlignment(Pos.CENTER);
        hres.setPadding(new Insets(25));

        hnext.getChildren().addAll(prev,next);
        hnext.setAlignment(Pos.CENTER);

        vshow.getChildren().addAll(lname,tname,loldest,told,llates,tlate,lmax,tmax,hnext,load);
        vshow.setAlignment(Pos.CENTER);
        vshow.setPadding(new Insets(25));





    }

    public TextField getTname() {
        return tname;
    }

    public ComboBox<String> getCdis() {
        return cdis;
    }

    public TextField getTold() {
        return told;
    }

    public TextField getTlate() {
        return tlate;
    }

    public TextField getTmax() {
        return tmax;
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

    public VBox getVshow() {
        return vshow;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public VBox getVboxdel() {
        return vboxdel;
    }

    public ComboBox<String> getTdisdel() {
        return tdisdel;
    }

    public Button getBack() {
        return back;
    }

    public TextField getT1() {
        return t1;
    }

    public ComboBox<String> getTdis() {
        return tdis;
    }

    public TextField getTloc() {
        return tloc;
    }

    public Label getLres() {
        return lres;
    }

    public HBox getHres() {
        return hres;
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

    public Button getBtninsloc() {
        return btninsloc;
    }

    public Button getBtndelloc() {
        return btndelloc;
    }

    public Button getBtnupdloc() {
        return btnupdloc;
    }

    public Button getInsert() {
        return insert;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getUpdate() {
        return update;
    }

    public HBox getHboxdel() {
        return hboxdel;
    }

    public VBox getvBoxupdate() {
        return vBoxupdate;
    }

    public VBox getVboxins() {
        return vboxins;
    }

    public Button getBtnshow() {
        return btnshow;
    }

    public Button getBtndel() {
        return btndel;
    }

    public Button getBtnins() {
        return btnins;
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

    public ComboBox<String> getUpddis() {
        return upddis;
    }
}
