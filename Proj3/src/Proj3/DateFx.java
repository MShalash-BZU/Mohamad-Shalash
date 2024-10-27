package Proj3;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class DateFx {
    private Label lprint,lins,ldel,lupd,linsert,lupdate1,lupdate2,ldelete,DMAR,lres,DATE,dismax,locmax,maravg;
    private TextField t1,tname,ttotal,tavg,tdis,tloc;
    private Button btnprint,btndel,btnins,btnupdate,update,delete,insert,back,up,down,load;
    private GridPane gpane,gpane2;
    private HBox hBox,hboxins,hboxdel,hnext;
    private VBox vBoxupdate,vshow,vshow2;
    private Font font;
    private ComboBox<String> tdate;
    private DatePicker tins,tupd2,tdel,tupd1,tnevg;
    public DateFx(){
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
        lupd=new Label("Update Date :");
        lins=new Label("Insert Date :");
        ldel=new Label("Delete Date :");
        linsert=new Label("Enter the Date :");
        lupdate1=new Label("Enter the old Date :");
        lupdate2=new Label("Enter the new Date :");
        ldelete=new Label("Enter the name :");
        lprint=new Label("Print the Hash table :");
        lres=new Label("");
        DMAR=new Label("Total Martyr :");
        DATE=new Label("Date :");
        DATE.setTextFill(Color.LIGHTGREEN);
        dismax=new Label("District that has the maximum martyrs :");
        locmax=new Label("Location that has the maximum martyrs :");
        maravg=new Label("Average Martyrs :");
        dismax.setTextFill(Color.LIGHTGREEN);
        locmax.setTextFill(Color.LIGHTGREEN);
        maravg.setTextFill(Color.LIGHTGREEN);
        DMAR.setTextFill(Color.LIGHTGREEN);
        maravg.setFont(font);
        locmax.setFont(font);
        dismax.setFont(font);
        DMAR.setFont(font);
        lprint.setFont(font);
        ldel.setFont(font);
        lres.setFont(font);
        lins.setFont(font);
        lupd.setFont(font);
        DATE.setFont(font);
        linsert.setFont(font);
        lupdate1.setFont(font);
        lupdate2.setFont(font);
        ldelete.setFont(font);

        tins=new DatePicker();
        tdel=new DatePicker();
        tupd1=new DatePicker();
        tdate=new ComboBox<>();
        tupd2=new DatePicker();
        tnevg=new DatePicker();
        tname=new TextField();
        ttotal=new TextField();
        tavg=new TextField();
        tdis=new TextField();
        tloc=new TextField();
        tloc.setMaxWidth(220);
        tdis.setMaxWidth(220);
        tavg.setMaxWidth(220);
        ttotal.setMaxWidth(220);
        tname.setMaxWidth(220);
        tupd1.setMaxWidth(200);
        tupd2.setMaxWidth(200);
        tupd1.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        tupd2.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        tdel.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        tins.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });
        tnevg.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #c3c2c1;");
                }
            }
        });


        btndel=new Button("Delete");
        btnins=new Button("Insert");
        btnprint=new Button("Print Table");
        btnupdate=new Button("Update");
        update=new Button("Update");
        delete=new Button("Delete");
        insert=new Button("Insert");
        up=new Button("Up");
        down=new Button("Down");
        load=new Button("Load District");

        double buttonWidth = 180;
        btndel.setMinWidth(buttonWidth);
        btnins.setMinWidth(buttonWidth);
        btnprint.setMinWidth(buttonWidth);
        btnupdate.setMinWidth(buttonWidth);
        update.setMinWidth(buttonWidth);
        delete.setMinWidth(buttonWidth);
        insert.setMinWidth(buttonWidth);
        up.setMinWidth(120);
        down.setMinWidth(120);



        double buttonHeight = 35;
        btndel.setMinHeight(buttonHeight);
        btnins.setMinHeight(buttonHeight);
        btnprint.setMinHeight(buttonHeight);
        btnupdate.setMinHeight(buttonHeight);
        update.setMinHeight(buttonHeight);
        delete.setMinHeight(buttonHeight);
        insert.setMinHeight(buttonHeight);
        up.setMinHeight(25);
        down.setMinHeight(25);
        load.setMinWidth(120);
        load.setMinHeight(25);

        btndel.setFont(font);
        btnins.setFont(font);
        btnprint.setFont(font);
        btnupdate.setFont(font);
        update.setFont(font);
        delete.setFont(font);
        insert.setFont(font);
        up.setFont(font);
        down.setFont(font);
        load.setFont(font);


        gpane.add(lins,0,0);
        gpane.add(btnins,0,1);
        gpane.add(lupd,0,2);
        gpane.add(btnupdate,0,3);
        gpane.add(btndel,0,5);
        gpane.add(ldel,0,4);
        gpane.add(lprint,0,6);
        gpane.add(btnprint,0,7);
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

        hnext.getChildren().addAll(down,up);
        hnext.setAlignment(Pos.CENTER);

        vshow.getChildren().addAll(DATE,tname,DMAR,ttotal,maravg,tavg,dismax,tdis,locmax,tloc,hnext);
        vshow.setAlignment(Pos.CENTER);
        vshow.setPadding(new Insets(25));


    }

    public VBox getVshow() {
        return vshow;
    }

    public Button getBack() {
        return back;
    }

    public TextField getTavg() {
        return tavg;
    }

    public TextField getTdis() {
        return tdis;
    }

    public TextField getTloc() {
        return tloc;
    }

    public DatePicker getTins() {
        return tins;
    }

    public DatePicker getTdel() {
        return tdel;
    }

    public DatePicker getTnevg() {
		return tnevg;
	}

	public DatePicker getTupd1() {
        return tupd1;
    }

    public DatePicker getTupd2() {
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

    public Button getBtnprint() {
        return btnprint;
    }

    public ComboBox<String> getTdate() {
        return tdate;
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



    public TextField getTname() {
        return tname;
    }

    public TextField getTtotal() {
        return ttotal;
    }

    public Button getUp() {
        return up;
    }

    public Button getDown() {
        return down;
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
