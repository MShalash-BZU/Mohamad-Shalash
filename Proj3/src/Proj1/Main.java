package Proj1;//package Proj1;
//
//
//import Proj2.DistrictTree;
//import Proj2.MartyrDate;
//import Proj2.MartyrScreen;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.time.LocalDate;
//import java.util.*;
//
//public class Main extends Application {
//    DoubleList Dlist=new DoubleList();
//    DistrictTree Dtree=new DistrictTree();
//    SNode temp;
//    DNode cur;
//    private FileChooser file;
//    private File f;
//    @Override
//    public void start(Stage stage) throws IOException {
//
//        TabPane tpane=new TabPane();
//        Tab location=new Tab(" Location ");
//        Tab district=new Tab(" District ");
//        Tab martyr=new Tab(" Martyr ");
//        Tab load=new Tab("load");
//        tpane.getTabs().addAll(load,location,district,martyr);
//
//
//
//        Interface intfx = new Interface();
//
//        DistrictFx disfx=new DistrictFx();
//        BorderPane disbord =new BorderPane();
//        disbord.setLeft(disfx.getGpane());
//        disbord.setCenter(disfx.getVshow());
//        disbord.setTop(disfx.getBack());
//
//        LocationFx locfx=new LocationFx();
//        BorderPane locbord =new BorderPane();
//        locbord.setRight(locfx.getCdis());
//        locbord.setCenter(locfx.getGpane());
//        locbord.setTop(locfx.getBack());
//
//        MartyrScreen marfx=new MartyrScreen();
//        BorderPane marbord =new BorderPane();
//        marbord.setCenter(marfx.getGpane());
//        marbord.setTop(marfx.getBack());
//
//        BorderPane proj =new BorderPane();
//        proj.setCenter(intfx.getGpane());
//        load.setContent(proj);
//        location.setContent(locbord);
//        district.setContent(disbord);
//        martyr.setContent(marbord);
//        if(f!=null){
//            intfx.getBtnfile().setDisable(true);
//        }
//        file=new FileChooser();
//
//        Scene scene = new Scene(tpane, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        intfx.getBtnloc().setOnAction(e->{
//            tpane.getSelectionModel().select(1);
//        });
//        intfx.getBtndis().setOnAction(e->{
//            tpane.getSelectionModel().select(2);
//        });
//        disfx.getBack().setOnAction(e->{
//            tpane.getSelectionModel().select(0);
//        });
//        locfx.getBack().setOnAction(e->{
//            tpane.getSelectionModel().select(0);
//        });
//        marfx.getBack().setOnAction(e->{
//            tpane.getSelectionModel().select(0);
//        });
//        intfx.getBtnmar().setOnAction(e->{
//            tpane.getSelectionModel().select(3);
//        });
//        intfx.getBtnfile().setOnAction(e->{
//            file.setTitle("Open File ");
//            file.setInitialDirectory(new File("C:\\"));
//            f=file.showOpenDialog(stage);
//            if (f!=null) {
//                try {
//                    Scanner in = new Scanner(f);
//                    in.nextLine();
//                    int c = 0;
//                    while (in.hasNextLine()) {
//                        String line = in.nextLine();
//                        String[] s = line.split(",");
//                       if(s.length<6) {
//                           System.out.println(s[0]);
//                           c--;
//                           continue;
//                       }
//                        String name = s[0].trim();
//                        String date = s[1];
//                        String age = s[2].trim();
//                        String loc = s[3].trim();
//                        String dis = s[4].trim();
//                        String gender = s[5].trim();
//                        if (age.isEmpty()||age==null) {
//                            age = "n/a";
//                        }
//                        Location LOC=new Location(loc);
//                        District DIS=new District(dis);
//                        MartyrDate mardate=new MartyrDate(date);
//                       Martyr mar= new Martyr(name, age, gender);
//                        District D = Dlist.Find(dis);
//                        if (D != null) {
//                            Location L=D.getList().Find(loc);
//                            if (L != null) {
//                                L.getList().insert(mar);
//                                c++;
//                            } else {
//
//                                LOC.getList().insert(mar);
//                                D.getList().insert(LOC);
//                                c++;
//                            }
//
//                        }else {
//                            LOC.getList().insert(mar);
//                            DIS.getList().insert(LOC);
//                            Dlist.insert(DIS);
//                            c++;
//
//                        }
//
//                    }
//                    intfx.getBtnfile().setDisable(true);
//                    System.out.println(Dlist.totalmartyr());
//                    System.out.println(countmar());
//                    System.out.println(c);
//
//                } catch (FileNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//
//        });
//
//        disfx.getBtnshow().setOnAction(e->{
//            showdistrictfx(stage);
//        });
//        locfx.getBtnshow().setOnAction(e->{
//            showlocation(stage);
//        });
//        disfx.getBtnins().setOnAction(e->{
//            Insertdis(stage);
//        });
//        disfx.getBtndel().setOnAction(e->{
//            Deletedis(stage);
//        });
//        disfx.getBtnupdate().setOnAction(e->{
//            Updatedis(stage);
//        });
//        locfx.getBtndelloc().setOnAction(e->{
//            deleteLoc(stage);
//        });
//        locfx.getBtnupdloc().setOnAction(e->{
//            updateLoc(stage);
//        });
//        locfx.getBtninsloc().setOnAction(e->{
//            insertLoc(stage);
//        });
//        disfx.getBtnsearch().setOnAction(e->{
//            CalculateDate(stage);
//        });
//    }
//
//
//    public void showdistrictfx(Stage stage){
//        ShowFx show=new ShowFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(show.getGpane());
//        root.setTop(back);
//        root.setBottom(show.getHbox());
//        cur=Dlist.getFirst();
//       Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        if(cur!=null) {
//            show.getTdis().setText(((District) cur.getData()).getNamedis());
//            show.getTmartyr().setText(String.valueOf(((District) cur.getData()).getList().totalMartyr()));
//            show.getTmale().setText(String.valueOf(((District) cur.getData()).getList().totalMale()));
//            show.getTfemale().setText(String.valueOf(((District) cur.getData()).getList().totalFemale()));
//            show.getTavg().setText(String.valueOf(((District) cur.getData()).getList().averageAge()));
//            show.getTmax().setText(String.valueOf(Dlist.maxMartyrDate((District) cur.getData())));
//
//        }
//        show.getNext().setOnAction(e->{
//            if(cur!=null) {
//                cur=cur.next;
//               show.getTdis().setText(((District) cur.getData()).getNamedis());
//            show.getTmartyr().setText(String.valueOf(((District) cur.getData()).getList().totalMartyr()));
//                    show.getTmale().setText(String.valueOf(((District) cur.getData()).getList().totalMale()));
//                    show.getTfemale().setText(String.valueOf(((District) cur.getData()).getList().totalFemale()));
//                    show.getTavg().setText(String.valueOf(((District) cur.getData()).getList().averageAge()));
//                     show.getTmax().setText(String.valueOf(Dlist.maxMartyrDate((District) cur.getData())));
//
//            }
//
//        });
//        show.getPrev().setOnAction(e->{
//            if(cur!=null) {
//                cur=cur.prev;
//                    show.getTdis().setText(((District) cur.getData()).getNamedis());
//                    show.getTmartyr().setText(String.valueOf(((District) cur.getData()).getList().totalMartyr()));
//                    show.getTmale().setText(String.valueOf(((District) cur.getData()).getList().totalMale()));
//                    show.getTfemale().setText(String.valueOf(((District) cur.getData()).getList().totalFemale()));
//                    show.getTavg().setText(String.valueOf(((District) cur.getData()).getList().averageAge()));
//                    show.getTmax().setText(String.valueOf(Dlist.maxMartyrDate((District) cur.getData())));
//
//
//            }
//        });
//        show.getLoad().setOnAction(e->{
//            District d=Dlist.Find(show.getTdis().getText());
//            showlocation(stage ,d);
//        });
//    }
//    public void showlocation(Stage stage,District dis){
//        ShowLoc show =new ShowLoc();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(show.getGpane());
//        root.setTop(back);
//        root.setBottom(show.getHbox());
//
//        if (dis!=null) {
//            temp = dis.getList().getFirst();
//        }
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Show Location");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//
//                showdistrictfx(stage);
//
//
//        });
//        if(temp!=null) {
//            show.getTloc().setText(((Location) temp.getData()).getName());
//            show.getTmartyr().setText(String.valueOf(((Location) temp.getData()).getList().getSize()));
//            show.getTmale().setText(String.valueOf(((Location) temp.getData()).getList().countmale()));
//            show.getTfemale().setText(String.valueOf(((Location) temp.getData()).getList().countfemale()));
//            show.getTavg().setText(String.valueOf(((Location) temp.getData()).getList().average()));
//            show.getTold().setText(String.valueOf(((Location) temp.getData()).getList().oldest()));
//            show.getTyoung().setText(String.valueOf(((Location) temp.getData()).getList().youngest()));
//        }
//        show.getNext().setOnAction(e->{
//            if(temp==null){
//                System.out.println("enter the file.");
//            }
//            if(temp!=null) {
//
//                temp = temp.next;
//                show.getTloc().setText(((Location) temp.getData()).getName());
//                show.getTmartyr().setText(String.valueOf(((Location) temp.getData()).getList().getSize()));
//                show.getTmale().setText(String.valueOf(((Location) temp.getData()).getList().countmale()));
//                show.getTfemale().setText(String.valueOf(((Location) temp.getData()).getList().countfemale()));
//                show.getTavg().setText(String.valueOf(((Location) temp.getData()).getList().average()));
//                show.getTold().setText(String.valueOf(((Location) temp.getData()).getList().oldest()));
//                show.getTyoung().setText(String.valueOf(((Location) temp.getData()).getList().youngest()));
//
//
//            }
//        });
//    }
//
//    public void showlocation(Stage stage){
//        ShowLoc show =new ShowLoc();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(show.getGpane());
//        root.setTop(back);
//        root.setBottom(show.getHbox());
//        cur=Dlist.getFirst();
//        if (cur!=null) {
//            temp = ((District) cur.getData()).getList().getFirst();
//        }
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Show Location");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        if(temp!=null) {
//            show.getTloc().setText(((Location) temp.getData()).getName());
//            show.getTmartyr().setText(String.valueOf(((Location) temp.getData()).getList().getSize()));
//            show.getTmale().setText(String.valueOf(((Location) temp.getData()).getList().countmale()));
//            show.getTfemale().setText(String.valueOf(((Location) temp.getData()).getList().countfemale()));
//            show.getTavg().setText(String.valueOf(((Location) temp.getData()).getList().average()));
//            show.getTold().setText(String.valueOf(((Location) temp.getData()).getList().oldest()));
//            show.getTyoung().setText(String.valueOf(((Location) temp.getData()).getList().youngest()));
//        }
//        show.getNext().setOnAction(e->{
//            if(temp==null){
//                System.out.println("enter the file.");
//            }
//           if(temp!=null) {
//
//
//               show.getTloc().setText(((Location) temp.getData()).getName());
//               show.getTmartyr().setText(String.valueOf(((Location) temp.getData()).getList().getSize()));
//               show.getTmale().setText(String.valueOf(((Location) temp.getData()).getList().countmale()));
//               show.getTfemale().setText(String.valueOf(((Location) temp.getData()).getList().countfemale()));
//               show.getTavg().setText(String.valueOf(((Location) temp.getData()).getList().average()));
//               show.getTold().setText(String.valueOf(((Location) temp.getData()).getList().oldest()));
//               show.getTyoung().setText(String.valueOf(((Location) temp.getData()).getList().youngest()));
//               temp = temp.next;
//               if (temp == ((District) cur.getData()).getList().getFirst()) {
//                   cur = cur.next;
//                   temp = ((District) cur.getData()).getList().getFirst();
//               }
//           }
//        });
//    }
//    public void Search(Stage stage){
//        SearchFx ser=new SearchFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(ser.getVbox());
//        root.setLeft(ser.getTarea());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        ser.getSearch().setOnAction(e->{
//            Martyr mar=Searchmar(ser.getTseaarch().getText());
//            if(mar!=null) {
//                ser.getTarea().setText(Searchmarall(ser.getTseaarch().getText()));
//                ser.getTname().setText(mar.getName());
//                ser.getTage().setText(mar.getAge());
////                ser.getTdis().setText(mar.getDistrict());
////                ser.getTloc().setText(mar.getLocation());
//                ser.getTgen().setText(mar.getGender());
////                ser.getTdate().setText(mar.getDate());
//            }
//        });
//    }
//    public void InsertMar(Stage stage){
//        OperationFx ins=new OperationFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        ins.getTdis().setItems(list);
//        ObservableList list1=null;
//        ins.getTloc().setItems(list1);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(ins.getVbox());
//        root.setBottom(ins.getHres());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        ins.getTdis().setOnAction(e->{
//            ObservableList list2= FXCollections.observableArrayList(cboxLoc(ins.getTdis().getValue()));
//            ins.getTloc().setItems(list2);
//        });
//        ins.getInsert().setOnAction(e->{
//            try {
//                int age=Integer.parseInt(ins.getTage().getText().trim());
//
//
//                if (!ins.getDate().getValue().toString().isEmpty()) {
//                    LocalDate date = ins.getDate().getValue();
//
//                    String[] s = date.toString().split("-");
//                    if (containDis(ins.getTdis().getValue())) {
//                        District D = Dlist.Find(ins.getTdis().getValue());
//                        if (containLoc(ins.getTloc().getValue())) {
//                            Location l = D.getList().Find(ins.getTloc().getValue());
//                            l.getList().insert(new Martyr(ins.getTname().getText(), String.valueOf(age), ins.getTgen().getValue()));
//                        } else {
//                            addLocation(ins.getTdis().getValue(), ins.getTloc().getValue());
//                            Location l = D.getList().Find(ins.getTloc().getValue());
//                            l.getList().insert(new Martyr(ins.getTname().getText(), String.valueOf(age), ins.getTgen().getValue()));
//                        }
//                    }
//                }
//                ins.getTgen().setValue(null);
//                ins.getTdis().setValue(null);
//                ins.getTage().clear();
//                ins.getTname().clear();
//                ins.getTloc().setValue(null);
//                ins.getDate().setValue(null);
//            }catch (Exception ex){
//                ins.getLres().setText("one of text feild is empty");
//                ins.getTgen().setValue(null);
//                ins.getTdis().setValue(null);
//                ins.getTage().clear();
//                ins.getTname().clear();
//                ins.getTloc().setValue(null);
//                ins.getDate().setValue(null);
//            }
//
//        });
//    }
//    public void UpdateMar(Stage stage){
//        HBox hbox=new HBox();
//        OperationFx upd=new OperationFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        hbox.getChildren().addAll(back,upd.getHboxser());
//        hbox.setAlignment(Pos.CENTER);
//        root.setTop(hbox);
//        root.setCenter(upd.getVboxupd());
//        root.setBottom(upd.getHres());
//
//       Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Update Martyr");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        upd.getBtnser().setOnAction(e->{
//            if(upd.getTser().getText().isEmpty()){
//                upd.getLres().setText("text filed of search is empty");
//            }
//               Martyr mar= Searchmar(upd.getTser().getText());
//                if (mar!=null){
//                    upd.getTname2().setText(mar.getName());
//                    upd.getTage2().setText(mar.getAge());
////                    upd.getTgen2().setText(mar.getGender());
////                    upd.getTdis2().setText(mar.getDistrict());
////                    upd.getTloc2().setText(mar.getLocation());
////                    String s[]=mar.getDate().split("/");
////                    LocalDate l=LocalDate.of(Integer.parseInt(s[2]),Integer.parseInt(s[0]),Integer.parseInt(s[1]));
////                    upd.getDate2().setValue(l);
//
//            }
//
//        });
//        upd.getUpdate().setOnAction(e->{
//
//            Martyr mar= Searchmar(upd.getTser().getText());
//            if(mar!=null) {
////                Location loc = Searchloc(mar.getLocation());
////                loc.getList().remove(mar);
////                if (containDis(upd.getTdis2().getText())) {
////                    String[] s=upd.getDate2().getValue().toString().split("-");
////                    District D = Dlist.Find(upd.getTdis2().getText());
////                    if (containLoc(upd.getTloc2().getText())) {
////                        Location l = D.getList().Find(upd.getTloc2().getText());
////                        l.getList().insert(new Martyr(upd.getTname2().getText(), upd.getTage2().getText(), upd.getTgen2().getText()));
////                        upd.getLres().setText("done update");
////                    } else {
////                        upd.getLres().setText("do not update");
////                    }
////                } else {
////                    upd.getLres().setText("do not update");
////                }
////                upd.getTgen2().clear();
////                upd.getTdis2().clear();
////                upd.getTage2().clear();
////                upd.getTname2().clear();
////                upd.getTloc2().clear();
////                upd.getDate2().setValue(null);
//            }
////            loc.get2List().Update(upd.getTname2().getText(),new Martyr(upd.getTname2().getText(),upd.getTage2().getText(),upd.getTloc2().getText(),upd.getTdis2().getText(),upd.getTgen2().getText(),new GregorianCalendar()));
//        });
//    }
//    public void Deletemar(Stage stage){
//        OperationFx del=new OperationFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(del.gethBox());
//        root.setBottom(del.getHres());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Delete Martyr");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        del.getDelete().setOnAction(e->{
//            if(del.getTdel().getText()!=null) {
//                Martyr mar = Searchmar(del.getTdel().getText());
//                if (mar!=null) {
////                    District dis = Dlist.Find(mar.getDistrict());
////                    Location loc = dis.getList().Find(mar.getLocation());
//
////                    del.getLres().setText("Done remove ."+loc.getList().remove(mar));
//                }
//            }else{
//                del.getLres().setText("did not remove .");
//            }
//            del.getTdel().clear();
//        });
//    }
//    public void Insertdis(Stage stage){
//        DistrictFx disfx=new DistrictFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(disfx.getHboxins());
//        root.setBottom(disfx.gethBox());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Insert District");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        disfx.getInsert().setOnAction(e->{
//            addDistrict(disfx.getTins().getText());
//            disfx.getTins().clear();
//        });
//    }
//    public void Deletedis(Stage stage){
//        DistrictFx disfx=new DistrictFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        disfx.getTdel().setItems(list);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(disfx.getHboxdel());
//        root.setBottom(disfx.gethBox());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Delete District");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        disfx.getDelete().setOnAction(e->{
//            if (containDis(disfx.getTdel().getValue())){
//                disfx.getLres().setText("Done remove ."+Dlist.removeD(Dlist.Find(disfx.getTdel().getValue())));
//                ObservableList list2= FXCollections.observableArrayList(cboxDis());
//                disfx.getTdel().setItems(list2);
//            }else{
//                disfx.getLres().setText("Not remove .");
//            }
//            disfx.getTdel().setValue(null);
//        });
//    }
//    public void Updatedis(Stage stage){
//        DistrictFx disfx=new DistrictFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        disfx.getTupd1().setItems(list);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(disfx.getvBoxupdate());
//        root.setBottom(disfx.gethBox());
//        root.setTop(back);
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Update District");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        disfx.getUpdate().setOnAction(e->{
//            if(containDis(disfx.getTupd1().getValue()) && !disfx.getTupd1().getValue().isEmpty() && !disfx.getTupd2().getText().isEmpty()){
//                District dis=Dlist.Find(disfx.getTupd1().getValue());
//                District d=new District(disfx.getTupd2().getText());
//                updatedis(disfx.getTupd1().getValue(),disfx.getTupd2().getText());
//                Dlist.insert(d);
//                SNode temp=dis.getList().getFirst();
//                if(temp!=null){
//                do{
//                    d.getList().insert((Location)temp.getData());
//                    temp=temp.next;
//
//                }while (temp!=dis.getList().getFirst());
//                }
//                Dlist.removeD(dis);
//                ObservableList list2= FXCollections.observableArrayList(cboxDis());
//                disfx.getTupd1().setItems(list2);
//
//                disfx.getLres().setText("Done update .");
//            }else {
//                disfx.getLres().setText("Do not update .");
//            }
//            disfx.getTupd1().setValue(null);
//            disfx.getTupd2().clear();
//        });
//    }
//    public void insertLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        locfx.getTdis().setItems(list);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(locfx.getVboxins());
//        root.setBottom(locfx.getHres());
//        root.setTop(back);
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Insert Location");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        locfx.getInsert().setOnAction(e->{
//            if (containDis(locfx.getTdis().getValue())){
//                District dis=Dlist.Find(locfx.getTdis().getValue());
//                if (!containLoc(locfx.getTloc().getText())) {
//                    dis.getList().insert(new Location(locfx.getTloc().getText()));
//                    locfx.getLres().setText("Done Insert .");
//                }else {
//                    locfx.getLres().setText("the location already exists .");
//                }
//            }else{
//                locfx.getLres().setText("i did not find the district .");
//            }
//            locfx.getTdis().setValue("");
//            locfx.getTloc().clear();
//        });
//    }
//    public void updateLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        locfx.getUpddis().setItems(list);
//        ObservableList list1=null;
//        locfx.getTupd1().setItems(list1);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(locfx.getvBoxupdate());
//        root.setBottom(locfx.getHres());
//        root.setTop(back);
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Update Location");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        locfx.getUpddis().setOnAction(e->{
//            ObservableList list2= FXCollections.observableArrayList(cboxLoc(locfx.getUpddis().getValue()));
//            locfx.getTupd1().setItems(list2);
//        });
//        locfx.getUpdate().setOnAction(e->{
//            if (Searchloc(locfx.getTupd1().getValue())!=null && !locfx.getTupd1().getValue().isEmpty() && !locfx.getTupd2().getText().isEmpty()){
//                Location loc=Searchloc(locfx.getTupd1().getValue());
//                Location l=new Location(locfx.getTupd2().getText());
//                updateloc(locfx.getTupd1().getValue(),locfx.getTupd2().getText());
//                listloc(locfx.getTupd1().getValue()).insert(l);
//                SNode temp=loc.getList().getFirst();
//                if (temp!=null) {
//                    do {
//                        l.getList().insert((Martyr) temp.getData());
//                        temp=temp.next;
//                    } while (temp != loc.getList().getFirst());
//                }
//                listloc(locfx.getTupd1().getValue()).remove(loc);
//                ObservableList list3= FXCollections.observableArrayList(cboxLoc(locfx.getUpddis().getValue()));
//                locfx.getTupd1().setItems(list3);
//                locfx.getLres().setText("Done update .");
//            }else {
//                locfx.getLres().setText("Do not update .");
//            }
//            locfx.getTupd1().setValue(null);
//            locfx.getTupd2().clear();
//        });
//    }
//    public void deleteLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(cboxDis());
//        locfx.getTdisdel().setItems(list);
//        ObservableList list1=null;
//        locfx.getTdel().setItems(list1);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(locfx.getVboxdel());
//        root.setBottom(locfx.getHres());
//        root.setTop(back);
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Delete Location");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        locfx.getTdisdel().setOnAction(e->{
//            ObservableList list2= FXCollections.observableArrayList(cboxLoc(locfx.getTdisdel().getValue()));
//            locfx.getTdel().setItems(list2);
//        });
//        locfx.getDelete().setOnAction(e->{
//            if (Searchloc(locfx.getTdel().getValue())!=null ){
//
//                listloc(locfx.getTdel().getValue()).remove(Searchloc(locfx.getTdel().getValue()));
//                ObservableList list3= FXCollections.observableArrayList(cboxLoc(locfx.getTdisdel().getValue()));
//                locfx.getTdel().setItems(list3);
//                locfx.getLres().setText("Done delete");
//            }else {
//                locfx.getLres().setText("Did not delete");
//            }
//        });
//    }
//
//    public boolean addDistrict(String disName){
//        if(!containDis(disName)) {
//            District Dis = new District(disName);
//            Dlist.insert(Dis);
//            return true;
//        }
//        return false;
//    }
//    public boolean addLocation(String District,String location){
//        if(containDis(District)){
//            if(!containLoc(location)) {
//                District dis=Dlist.Find(District);
//                Location Loc = new Location(location);
//                dis.getList().insert(Loc);
//                return true;
//            }
//        }else {
//            addDistrict(District);
//        }
//        return false;
//    }
//    public boolean addMartyr(String dis,String loc,Martyr mar){
//        if (containDis(dis)){
//            if(containLoc(loc)){
//                District d=Dlist.Find(dis);
//                Location l=d.getList().Find(loc);
//                l.getList().insert(mar);
//               return true;
//
//            }
//        }
//
//        return false;
//    }
//    public void CalculateDate(Stage stage){
//        OperationFx calc=new OperationFx();
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(calc.getHdate());
//        root.setBottom(calc.getHres());
//        root.setTop(back);
//        stage.show();Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Calculate Date");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        calc.getDatepicker().setOnAction(e->{
//            if(calc.getDatepic().getValue()!=null) {
//                if (calc.getDatepic().getValue()!=null||!calc.getDatepic().getValue().toString().isEmpty()) {
//                    String[] s = calc.getDatepic().getValue().toString().split("-");
//                    String month=s[1];
//                    String day= s[2];
//                    if (Integer.parseInt(s[1])<10){
//                        month=s[1].replace("0","");
//                    }
//                    if (Integer.parseInt(s[2])<10){
//                        day= s[2].replace("0","");
//                    }
//                    calc.getLres().setText("THE total martyr of this date :" + String.valueOf(countMartyrDate(month +"/"+day+"/"+s[0])));
//                    System.out.println(month +"/"+day+"/"+s[0]);
//                } else {
//                    calc.getLres().setText("the Date picker is empty");
//                }
//            }
//        });
//    }
//
//
//    public boolean containDis(String name){
//        DNode temp=Dlist.getFirst();
//        if (Dlist.getFirst()==null){
//            return false;
//        }
//        do{
//            if (((District)temp.getData()).getNamedis().equals(name)){
//                return true;
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return false;
//    }
//    public boolean containLoc(String name){
//        DNode temp=Dlist.getFirst();
//        if(temp==null){
//            return false;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if (ptr==null){
//                return false;
//            }
//            do {
//                if (((Location) ptr.getData()).getName().equals(name)) {
//                    return true;
//                }
//                ptr=ptr.next;
//            }while (ptr!=((District)temp.getData()).getList().getFirst());
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return false;
//    }
//    public Martyr Searchmar(String name){
//        DNode temp=Dlist.getFirst();
//        if (temp==null){
//            return null;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if(ptr!=null) {
//                do {
//                    SNode cur = ((Location) ptr.getData()).getList().getFirst();
//                    if (cur != null) {
//                        do {
//                            if (((Martyr) cur.getData()).getName().toLowerCase().contains(name.toLowerCase())) {
//                                return (Martyr) cur.getData();
//                            }
//                            cur = cur.next;
//                        } while (cur != ((Location) ptr.getData()).getList().getFirst());
//                    }
//                    ptr = ptr.next;
//                } while (ptr != ((District) temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return null;
//    }
//    public String Searchmarall(String name){
//        DNode temp=Dlist.getFirst();
//        String s="";
//        if (temp==null){
//            return null;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if(ptr!=null) {
//                do {
//                    SNode cur = ((Location) ptr.getData()).getList().getFirst();
//                    if (cur != null) {
//                        do {
//                            if (((Martyr) cur.getData()).getName().toLowerCase().contains(name.toLowerCase())) {
//                                s+= ((Martyr) cur.getData()).getName();
//                                s+="\n";
//                            }
//                            cur = cur.next;
//                        } while (cur != ((Location) ptr.getData()).getList().getFirst());
//                    }
//                    ptr = ptr.next;
//                } while (ptr != ((District) temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return s;
//    }
//    public int countmar(){
//        int count=0;
//        DNode temp=Dlist.getFirst();
//        if (temp==null){
//            return 0;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if(ptr!=null) {
//                do {
//                    SNode cur = ((Location) ptr.getData()).getList().getFirst();
//                    if (cur != null) {
//                        do {
//                            count++;
//                            cur = cur.next;
//                        } while (cur != ((Location) ptr.getData()).getList().getFirst());
//                    }
//                    ptr = ptr.next;
//                } while (ptr != ((District) temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return count;
//    }
//    public void updatedis(String oldname,String name){
//        DNode temp=Dlist.getFirst();
//        if (temp==null){
//            return;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if (ptr!=null) {
//                do {
//                    SNode cur = ((Location) ptr.getData()).getList().getFirst();
//                    if (cur != null) {
//                        do {
////                            if (((Martyr) cur.getData()).getDistrict().equalsIgnoreCase(oldname)) {
////                                ((Martyr) cur.getData()).setDistrict(name);
////                            }
//                            cur = cur.next;
//                        } while (cur != ((Location) ptr.getData()).getList().getFirst());
//                    }
//                    ptr = ptr.next;
//                } while (ptr != ((District) temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//    }
//    public void updateloc(String oldname,String name){
//        DNode temp=Dlist.getFirst();
//        if (temp==null){
//            return;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            if(ptr!=null) {
//                do {
//                    SNode cur = ((Location) ptr.getData()).getList().getFirst();
//                    if(cur!=null) {
//                        do {
////                            if (((Martyr) cur.getData()).getLocation().equalsIgnoreCase(oldname)) {
////                                ((Martyr) cur.getData()).setLocation(name);
////                            }
//                            cur = cur.next;
//                        } while (cur != ((Location) ptr.getData()).getList().getFirst());
//                    }
//                    ptr = ptr.next;
//                } while (ptr != ((District) temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//    }
//    public Location Searchloc(String name){
//        DNode temp=Dlist.getFirst();
//        if(temp==null){
//            return null;
//        }
//        do {
//            if (((District)temp.getData()).getList().Find(name)!=null){
//                return ((District)temp.getData()).getList().Find(name);
//            }
//            temp=temp.next;
//        }while (temp!=Dlist.getFirst());
//        return null;
//    }
//    public int countMartyrDate(String date){
//        int size=0;
//        DNode temp=Dlist.getFirst();
//        if (temp==null){
//            return 0;
//        }
//        do{
//            SNode ptr=((District)temp.getData()).getList().getFirst();
//            do {
//                SNode cur=((Location)ptr.getData()).getList().getFirst();
//                do {
////                    if (((Martyr) cur.getData()).getDate().trim().equalsIgnoreCase(date.trim())) {
////                        size++;
////                    }
//                    cur=cur.next;
//                }while (cur!=((Location)ptr.getData()).getList().getFirst());
//                ptr=ptr.next;
//            }while (ptr!=((District)temp.getData()).getList().getFirst());
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return size;
//    }
//    public LocationLinkedList listloc(String name){
//        DNode temp=Dlist.getFirst();
//        do {
//            if (((District)temp.getData()).getList().Find(name)!=null){
//                return ((District)temp.getData()).getList();
//            }
//            temp=temp.next;
//        }while (temp!=Dlist.getFirst());
//        return null;
//    }
//    public String[] cboxDis(){
//        DNode temp=Dlist.getFirst();
//        String [] s=new String[Dlist.getSize()];
//        for(int i=0;i<Dlist.getSize();i++){
//            s[i]=((District)temp.getData()).getNamedis();
//            temp=temp.next;
//        }
//        return s;
//    }
//    public String[] cboxLoc(String dis){
//
//        District temp=Dlist.Find(dis);
//        if(temp==null){
//            return null;
//        }
//        String [] s=new String[temp.getList().getSize()];
//            SNode ptr=temp.getList().getFirst();
//            if (ptr==null){
//                return null;
//            }
//            for (int i = 0; i < temp.getList().getSize(); i++) {
//                s[i] = ((Location) ptr.getData()).getName();
//                ptr = ptr.next;
//            }
//
//        return s;
//    }
//    public String[] cboxAllLoc(){
//
//        DNode temp=Dlist.getFirst();
//        if(temp==null){
//            return null;
//        }
//        String [] s=new String[countloc()];
//        int i=0;
//        do {
//            SNode ptr = ((District)temp.getData()).getList().getFirst();
//            if (ptr != null) {
//
//                do{
//                    s[i] = ((Location) ptr.getData()).getName();
//                    i++;
//                    ptr = ptr.next;
//                }while (ptr!=((District)temp.getData()).getList().getFirst());
//            }
//            temp=temp.next;
//        }while (temp!=Dlist.getFirst());
//
//        return s;
//    }
//    public int countloc(){
//        DNode temp=Dlist.getFirst();
//        int size=0;
//        if (temp==null){
//            return 0;
//        }
//        do{
//            size+=((District)temp.getData()).getList().getSize();
//            temp=temp.next;
//        } while (temp!=Dlist.getFirst());
//        return size;
//    }
//    public void save(File f) {
//        PrintWriter pw = null;
//
//        try {
//            pw=new PrintWriter(f);
//            DNode temp=Dlist.getFirst();
//            pw.print("Name,event,Age,location,District,Gender\n");
//            do {
//                SNode ptr=((District)temp.getData()).getList().getFirst();
//                do{
//                    SNode cur=((Location)ptr.getData()).getList().getFirst();
//                    do {
//                        pw.print(((Martyr)cur.data).toString() +"\n");
//                        cur=cur.next;
//                    }while (cur!=((Location)ptr.getData()).getList().getFirst());
//                    ptr=ptr.next;
//                }while (ptr!=((District)temp.getData()).getList().getFirst());
//                temp=temp.next;
//            }while (temp!=Dlist.getFirst());
//        } catch (Exception e) {
//
//        }
//    }
//
//
//    public static void main(String[] args) {
//        launch();
//
////        System.out.println("nnnn");
////        DoubleList llist= new DoubleList();
////        llist.insert(new District("crami"));
////        llist.insert(new District("mami"));
////        llist.insert(new District("aaaami"));
////        System.out.println(llist.printList()+"hhh");
////        System.out.println(llist.getSize());
////        System.out.println(llist.printList()+"hhh");
//    }
//}
