package Proj1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class SearchFx {
    private Label name,age,location,District,gender,date,lser,lrespone;
    private TextField tname,tage,tloc,tdis,tgen,tseaarch,tdate;
    private Button search;
    private GridPane gpane;
    private HBox hBox,hres;
    private VBox vbox;
    private Font font;
    private ComboBox<String> cdis;
    private TextArea tarea;
    public SearchFx(){
        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        gpane =new GridPane();
        hres=new HBox();
        hBox=new HBox(7);
        vbox=new VBox(30);
        name=new Label("Name :");
        age=new Label("Age :");
        location=new Label("Location :");
        District=new Label("District :");
        gender=new Label("Gender :");
        date=new Label("Date :");
        lser=new Label("Enter the name :");
        name.setFont(font);
        age.setFont(font);
        location.setFont(font);
        District.setFont(font);
        gender.setFont(font);
        date.setFont(font);
        lser.setFont(font);
        lrespone=new Label("");
        lrespone.setFont(font);
        tname=new TextField();
        tage=new TextField();
        tdis=new TextField();
        tgen=new TextField();
        tloc=new TextField();
        tarea=new TextArea();
        cdis=new ComboBox<>();
        tarea.setMaxHeight(400);
        tarea.setMaxWidth(200);
        tseaarch=new TextField();
        tdate=new TextField();
        search=new Button("Search");
        hBox.getChildren().addAll(lser,tseaarch,search,cdis);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(25));
        gpane.add(name,0,0);
        gpane.add(tname,1,0);
        gpane.add(age,0,1);
        gpane.add(tage,1,1);
        gpane.add(location,0,2);
        gpane.add(tloc,1,2);
        gpane.add(District,0,3);
        gpane.add(tdis,1,3);
        gpane.add(gender,0,4);
        gpane.add(tgen,1,4);
        gpane.add(date,0,5);
        gpane.add(tdate,1,5);
        gpane.setHgap(20);
        gpane.setVgap(30);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));
        vbox.getChildren().addAll(hBox,gpane);
        vbox.setPadding(new Insets(25));
        vbox.setAlignment(Pos.CENTER);
        hres.getChildren().addAll(lrespone);
        hres.setAlignment(Pos.CENTER);



    }

    public TextArea getTarea() {
        return tarea;
    }

    public Label getName() {
        return name;
    }

    public TextField getTname() {
        return tname;
    }

    public TextField getTage() {
        return tage;
    }

    public TextField getTloc() {
        return tloc;
    }

    public TextField getTdis() {
        return tdis;
    }

    public ComboBox<String> getCdis() {
        return cdis;
    }

    public TextField getTgen() {
        return tgen;
    }

    public TextField getTdate() {
        return tdate;
    }

    public TextField getTseaarch() {
        return tseaarch;
    }

    public Button getSearch() {
        return search;
    }

    public VBox getVbox() {
        return vbox;
    }

    public HBox gethBox() {
        return hBox;
    }
}
