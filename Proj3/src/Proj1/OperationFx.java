package Proj1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.text.NumberFormat;
import java.time.LocalDate;

public class OperationFx {
    private Label name,age,location,District,ldate,gender,ldel,lres,lser,name2,age2,location2,District2,ldate2,gender2,ldatepicker;
    private TextField tname,tage, tdel,tser,tname2,tage2,tdis,tloc,tloc2,tdis2;
    private Button delete,insert,update,btnser,datepicker;
    private GridPane gpane,gpane2;
    private HBox hBox,hres,hboxser,hdate;
    private RadioButton male,female,male2,female2;
    private VBox vbox,vboxupd;
    private DatePicker date,date2,datepic;
    private String  style="-fx-font-color:blue";
    private Font font;
    public OperationFx(){
        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        hres=new HBox(10);
        gpane =new GridPane();
        hBox=new HBox(7);
        hdate=new HBox(8);
        gpane2=new GridPane();
        vbox=new VBox(30);
        vboxupd=new VBox(30);
        hboxser=new HBox(10);

        male=new RadioButton("Male");
        female=new RadioButton("Female");
        ToggleGroup tg=new ToggleGroup();
        male.setToggleGroup(tg);
        female.setToggleGroup(tg);
        male2=new RadioButton("Male");
        female2=new RadioButton("Female");
        ToggleGroup tg2=new ToggleGroup();
        male2.setToggleGroup(tg2);
        female2.setToggleGroup(tg2);
        male.setFont(font);
        male2.setFont(font);
        female.setFont(font);
        female2.setFont(font);
        male.setTextFill(Color.SKYBLUE);
        male2.setTextFill(Color.SKYBLUE);
        female2.setTextFill(Color.PINK);
        female.setTextFill(Color.PINK);


        date=new DatePicker();
        date2=new DatePicker();
        datepic=new DatePicker();
        name=new Label("Name :");
        age=new Label("Age :");
        location=new Label("Location :");
        District=new Label("District :");
        gender=new Label("Gender :");
        name2=new Label("Name :");
        age2=new Label("Age :");
        location2=new Label("Location :");
        District2=new Label("District :");
        gender2=new Label("Gender :");
        ldel=new Label("Enter the name :");
        lres=new Label("");
        lser=new Label("Enter the name to update");
        ldate=new Label("Date :");
        ldate2=new Label("Date :");
        ldatepicker = new Label("Enter the Date :");

        name.setFont(font);
        age.setFont(font);
        location.setFont(font);
        District.setFont(font);
        gender.setFont(font);
        name2.setFont(font);
        age2.setFont(font);
        location2.setFont(font);
        District2.setFont(font);
        gender2.setFont(font);
        ldel.setFont(font);
        lres.setFont(font);
        lser.setFont(font);
        ldate.setFont(font);
        ldate2.setFont(font);
        ldatepicker.setFont(font);

        tname=new TextField();
        tage=new TextField();
        tser=new TextField();
        tdis=new TextField();
//        String []gen= {"M","F"};
//        ObservableList list= FXCollections.observableArrayList(gen);
//        tgen=new ComboBox<>(list);
        tloc=new TextField();
        tname2=new TextField();
        tage2=new TextField();
        tdis2=new TextField();
        tloc2=new TextField();
        tdel =new TextField();
        delete =new Button("Delete");
        insert=new Button("Insert");
        update=new Button("Update");
        btnser=new Button("Search");
        datepicker=new Button("Count");

        delete.setFont(font);
        insert.setFont(font);
        update.setFont(font);
        btnser.setFont(font);
        datepicker.setFont(font);
        date.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        date2.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        datepic.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });

        hBox.getChildren().addAll(ldel, tdel, delete);
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
        gpane.add(male,1,4);
        gpane.add(female,1,5);
        gpane.add(ldate,0,6);
        gpane.add(date,1,6);
        gpane.setHgap(20);
        gpane.setVgap(30);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));
        vbox.getChildren().addAll(gpane,insert);
        vbox.setPadding(new Insets(25));
        vbox.setAlignment(Pos.CENTER);
        gpane2.add(name2,0,0);
        gpane2.add(tname2,1,0);
        gpane2.add(age2,0,1);
        gpane2.add(tage2,1,1);
        gpane2.add(location2,0,2);
        gpane2.add(tloc2,1,2);
        gpane2.add(District2,0,3);
        gpane2.add(tdis2,1,3);
        gpane2.add(gender2,0,4);
        gpane2.add(male2,1,4);
        gpane2.add(female2,1,5);
        gpane2.add(ldate2,0,6);
        gpane2.add(date2,1,6);
        gpane2.setHgap(20);
        gpane2.setVgap(30);
        gpane2.setAlignment(Pos.CENTER);
        gpane2.setPadding(new Insets(25));
        vboxupd.getChildren().addAll(gpane2,update);
        vboxupd.setPadding(new Insets(25));
        vboxupd.setAlignment(Pos.CENTER);
        hboxser.getChildren().addAll(lser,tser,btnser);
        hboxser.setAlignment(Pos.CENTER);
        hboxser.setPadding(new Insets(25));

        hres.getChildren().add(lres);
        hres.setAlignment(Pos.CENTER);
        hres.setPadding(new Insets(25));

        hdate.getChildren().addAll(ldatepicker,datepic,datepicker);
        hdate.setPadding(new Insets(25));
        hdate.setAlignment(Pos.CENTER);



    }

    public Label getName() {
        return name;
    }

    public TextField getTname2() {
        return tname2;
    }

    public TextField getTage2() {
        return tage2;
    }

    public RadioButton getMale() {
        return male;
    }

    public RadioButton getFemale() {
        return female;
    }

    public RadioButton getMale2() {
        return male2;
    }

    public RadioButton getFemale2() {
        return female2;
    }

    public TextField getTloc2() {
        return tloc2;
    }

    public TextField getTdis2() {
        return tdis2;
    }

    public HBox getHdate() {
        return hdate;
    }

    public DatePicker getDatepic() {
        return datepic;
    }

    public Button getDatepicker() {
        return datepicker;
    }



    public DatePicker getDate2() {
        return date2;
    }

    public DatePicker getDate() {
        return date;
    }

    public TextField getTser() {
        return tser;
    }

    public Button getUpdate() {
        return update;
    }

    public Button getBtnser() {
        return btnser;
    }

    public HBox getHboxser() {
        return hboxser;
    }

    public Label getLres() {
        return lres;
    }

    public TextField getTname() {
        return tname;
    }

    public VBox getVboxupd() {
        return vboxupd;
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

    public TextField getTdel() {
        return tdel;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getInsert() {
        return insert;
    }

    public HBox gethBox() {
        return hBox;
    }

    public HBox getHres() {
        return hres;
    }

    public VBox getVbox() {
        return vbox;
    }
}
