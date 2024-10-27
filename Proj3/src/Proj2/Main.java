package Proj2;//package Proj2;
//
//
//import Proj1.*;
//import Proj3.Martyr;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
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
//    static DistrictTree Dtree=new DistrictTree();
//    private VBox vbox,vser;
//    private HBox hlist;
//    private Button upd,delete;
//    private FileChooser file;
//    private File f;
//    private Stack sn=new Stack(),spM=new Stack(),snM=new Stack();
//    private Stack sp=new Stack(),snL=new Stack(),spL=new Stack();
//    private TableView<Martyr> tableView;
//    private TableColumn<Martyr, String> name, age, gender;
//    private Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
//    @Override
//    public void start(Stage stage) throws IOException {
//
//        vbox=new VBox();
//        TabPane tpane=new TabPane();
//        Tab location=new Tab(" Location ");
//        Tab district=new Tab(" District ");
//        Tab martyr=new Tab(" Martyr ");
//        Tab load=new Tab("load");
//        tpane.getTabs().addAll(load,location,district,martyr);
//
//        DistrictFx disfx=new DistrictFx();
//        LocationFx locfx=new LocationFx();
//        MartyrScreen marfx=new MartyrScreen();
//
//        Interface intfx = new Interface();
//
//        BorderPane disbord =new BorderPane();
//        disbord.setLeft(disfx.getGpane());
//        disbord.setCenter(disfx.getVshow());
//        disbord.setTop(disfx.getBack());
//
//        BorderPane locbord =new BorderPane();
//        locbord.setRight(locfx.getCdis());
//        locbord.setLeft(locfx.getGpane());
//        locbord.setCenter(locfx.getVshow());
//        locbord.setTop(locfx.getBack());
//
//        BorderPane marbord =new BorderPane();
//        marbord.setRight(marfx.getCvbox());
//        marbord.setLeft(marfx.getGpane());
//        marbord.setCenter(marfx.getVshow());
//        marbord.setTop(marfx.getBack());
//
//        BorderPane proj =new BorderPane();
//        proj.setCenter(intfx.getGpane());
//        load.setContent(proj);
//        location.setContent(locbord);
//        district.setContent(disbord);
//        martyr.setContent(marbord);
//        if(f!=null){
//            intfx.getLoadFile().setDisable(true);
//            ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
//            sp=DisStack();
//            while (!sn.isEmpty()){
//                sn.pop();
//            }
//            while(!sp.isEmpty()){
//                sn.push(sp.pop());
//            }
//            locfx.getCdis().setItems(list);
//            marfx.getCdis().setItems(list);
//        }
//        file=new FileChooser();
//        vbox.getChildren().addAll(intfx.getMenu(),tpane);
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
//        locfx.getCdis().setItems(list);
//        marfx.getCdis().setItems(list);
//
//        Scene scene = new Scene(vbox, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        intfx.getNewScreen().setOnAction(e->{
//            stage.close();
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
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
//        intfx.getSavefiel().setOnAction(e->{
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Save to file?");
//            confirmAlert.setContentText("This will save the Data . ");
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    SaveToFile();
//                }
//
//            });
//        });
//        intfx.getLoadFile().setOnAction(e->{
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
//                        if(s.length<6) {
//                            System.out.println(s[0]);
//                            c--;
//                            continue;
//                        }
//                        String name = s[0].trim();
//                        String date = s[1];
//                        String age = s[2].trim();
//                        String loc = s[3].trim();
//                        String dis = s[4].trim();
//                        String gender = s[5].trim();
//                        if (age.isEmpty()||age==null) {
//                            age = "n/a";
//                        }
//                        if (date==null||date.isEmpty()){
//                            continue;
//                        }
//                        LocationT LOC=new LocationT(loc);
//                        DistrictT DIS=new DistrictT(dis);
//                        MartyrDate mardate=new MartyrDate(date);
//                        Martyr mar= new Martyr(name, age, gender);
//                        TNode node=Dtree.find(DIS);
//                        DistrictT D;
//                        if(node!=null) {
//                            D = (DistrictT) node.getData();
//                        }else{
//                            D=null;
//                        }
//                        if (D != null) {
//                            TNode node3=D.getList().find(LOC);
//                            LocationT L;
//                            if(node3!=null){
//                                L=(LocationT) node3.getData();
//                            }else{
//                                L=null;
//                            }
//                            if (L != null) {
//                                TNode node2=L.getList().find(mardate);
//                                MartyrDate M;
//                                if(node2!=null) {
//                                    M = (MartyrDate) node2.getData();
//                                }else {
//                                    M=null;
//                                }
//                                if(M!=null){
//                                    M.getMar().insert(mar);
//                                }else {
//                                    L.getList().insert(mardate);
//                                    mardate.getMar().insert(mar);
//                                }
//                                c++;
//                            } else {
//
//                                LOC.getList().insert(mardate);
//                                ((MartyrDate)LOC.getList().find(mardate).getData()).getMar().insert(mar);
//                                D.getList().insert(LOC);
//                                c++;
//                            }
//
//                        }else {
//                            mardate.getMar().insert(mar);
//                            LOC.getList().insert(mardate);
//                            DIS.getList().insert(LOC);
//                            Dtree.insert(DIS);
//                            c++;
//
//
//                        }
//
//                    }
//                    intfx.getLoadFile().setDisable(true);
//                    System.out.println(Dtree.size());
//                    System.out.println(countMartyr("Gaza"));
//                    System.out.println(c);
//                    sp=DisStack();
//                    while(!sp.isEmpty()){
//                        sn.push(sp.pop());
//                    }
//                    ObservableList list2= FXCollections.observableArrayList(Dtree.cboxDis());
//                    locfx.getCdis().setItems(list2);
//                    marfx.getCdis().setItems(list2);
//
//
//                } catch (FileNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//
//        });
//
//        marfx.getBtnins().setOnAction(e->{
//            InsertMar(stage);
//        });
//        marfx.getBtnser().setOnAction(e->{
//            Search(stage);
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
//        marfx.getShow().setOnAction(e->{
//            if(!marfx.getTdate().getText().isEmpty()) {
//                DistrictT D = (DistrictT) Dtree.find(new DistrictT(marfx.getCdis().getValue())).getData();
//                LocationT L = (LocationT) D.getList().find(new LocationT(marfx.getCloc().getValue())).getData();
//                if(L.getList().find(new MartyrDate(marfx.getTdate().getText()))!=null)
//                   listmartyr(stage, (MartyrDate) L.getList().find(new MartyrDate(marfx.getTdate().getText())).getData(),D,L);
//            }
//        });
//
//        disfx.getNext().setOnAction(e->{
//
//            if(!sn.isEmpty()){
//                DistrictT dis=(DistrictT)sn.peek();
//                disfx.getTname().setText(dis.getNamedis());
//                disfx.getTtotal().setText(String.valueOf(countMartyr(dis.getNamedis())));
//                if(!disfx.getTname().getText().isEmpty() || locfx.getCdis().getValue()!=disfx.getTname().getText()) {
//                    locfx.getCdis().setValue(disfx.getTname().getText());
//                }
//                sp.push(sn.pop());
//            }
//
//        });
//        disfx.getPrev().setOnAction(e->{
//            if(!sp.isEmpty()){
//                DistrictT dis=(DistrictT)sp.peek();
//                disfx.getTname().setText(dis.getNamedis());
//                disfx.getTtotal().setText(String.valueOf(countMartyr(dis.getNamedis())));
//                if(!disfx.getTname().getText().isEmpty() || locfx.getCdis().getValue()!=disfx.getTname().getText()) {
//                    locfx.getCdis().setValue(disfx.getTname().getText());
//                }
//                sn.push(sp.pop());
//            }
//
//        });
//        disfx.getLoad().setOnAction(e->{
//            if(!disfx.getTname().getText().isEmpty() || locfx.getCdis().getValue()!=disfx.getTname().getText()) {
//                locfx.getCdis().setValue(disfx.getTname().getText());
//            }
//        });
//        locfx.getNext().setOnAction(e->{
//            if(!snL.isEmpty()){
//                LocationT loc=(LocationT) snL.peek();
//                locfx.getTname().setText(loc.getName());
//                if(loc.getList().getMin(loc.getList().getRoot())==null) {
//                    locfx.getTold().setText("");
//                }else{
//                    locfx.getTold().setText(((MartyrDate) loc.getList().getMin(loc.getList().getRoot()).getData()).getDate());
//                }
//                locfx.getTlate().setText(loc.getList().LatestDate());
//                locfx.getTmax().setText(loc.getList().MaxDateMartyr());
//                if(locfx.getCdis().getValue()!=null && !locfx.getTname().getText().isEmpty()) {
//                    marfx.getCdis().setValue(locfx.getCdis().getValue());
//                    marfx.getCloc().setValue(locfx.getTname().getText());
//                }
//                spL.push(snL.pop());
//            }
//        });
//        locfx.getPrev().setOnAction(e->{
//            if(!spL.isEmpty()){
//                LocationT loc=(LocationT) spL.peek();
//                locfx.getTname().setText(loc.getName());
//                if(loc.getList().getMin(loc.getList().getRoot())==null) {
//                    locfx.getTold().setText("");
//                }else{
//                    locfx.getTold().setText(((MartyrDate) loc.getList().getMin(loc.getList().getRoot()).getData()).getDate());
//                }
//                locfx.getTlate().setText(loc.getList().LatestDate());
//                locfx.getTmax().setText(loc.getList().MaxDateMartyr());
//                if(locfx.getCdis().getValue()!=null && !locfx.getTname().getText().isEmpty()) {
//                    marfx.getCdis().setValue(locfx.getCdis().getValue());
//                    marfx.getCloc().setValue(locfx.getTname().getText());
//                }
//                snL.push(spL.pop());
//            }
//        });
//        locfx.getCdis().setOnAction(e->{
//            if(locfx.getCdis().getValue()!=null) {
//                spL = LocStack(locfx.getCdis().getValue());
//                while (!snL.isEmpty()){
//                    snL.pop();
//                }
//                while (!spL.isEmpty()) {
//                    snL.push(spL.pop());
//                }
//                if (!snL.isEmpty()) {
//                    LocationT loc = (LocationT) snL.peek();
//                    locfx.getTname().setText(loc.getName());
//                    if((loc.getList().getMin(loc.getList().getRoot()))==null) {
//                        locfx.getTold().setText("");
//                    }else{
//                        locfx.getTold().setText(((MartyrDate) loc.getList().getMin(loc.getList().getRoot()).getData()).getDate());
//                    }
//                    locfx.getTlate().setText(loc.getList().LatestDate());
//                    locfx.getTmax().setText(loc.getList().MaxDateMartyr());
//                }
//            }
//        });
//        marfx.getCloc().setOnAction(e->{
//            if(marfx.getCloc().getValue()!=null) {
//                spM = MarStack(marfx.getCdis().getValue(), marfx.getCloc().getValue());
//                while (!snM.isEmpty()){
//                    snM.pop();
//                }
//                while (!spM.isEmpty()) {
//                    snM.push(spM.pop());
//                }
//                if (!snM.isEmpty()) {
//                    MartyrDate mardate = (MartyrDate) snM.peek();
//                    marfx.getTdate().setText(mardate.getDate());
//                    marfx.getTold().setText(mardate.getMar().oldest());
//                    marfx.getTyoung().setText(mardate.getMar().youngest());
//                    marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
//                }
//            }
//        });
//        marfx.getNext().setOnAction(e->{
//            if(!snM.isEmpty()){
//                MartyrDate mardate=(MartyrDate) snM.peek();
//                marfx.getTdate().setText(mardate.getDate());
//                marfx.getTold().setText(mardate.getMar().oldest());
//                marfx.getTyoung().setText(mardate.getMar().youngest());
//                marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
//                spM.push(snM.pop());
//            }
//        });
//        marfx.getPrev().setOnAction(e->{
//            if(!spM.isEmpty()){
//                MartyrDate mardate=(MartyrDate) spM.peek();
//                marfx.getTdate().setText(mardate.getDate());
//                marfx.getTold().setText(mardate.getMar().oldest());
//                marfx.getTyoung().setText(mardate.getMar().youngest());
//                marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
//                snM.push(spM.pop());
//            }
//        });
//        marfx.getCdis().setOnAction(e->{
//            DistrictT d=(DistrictT) Dtree.find(new DistrictT(marfx.getCdis().getValue())).getData();
//            ObservableList list2= FXCollections.observableArrayList(d.getList().cboxLoc());
//            marfx.getCloc().setItems(list2);
//        });
//        locfx.getLoad().setOnAction(e->{
//            if(locfx.getCdis().getValue()!=null && !locfx.getTname().getText().isEmpty()) {
//                marfx.getCdis().setValue(locfx.getCdis().getValue());
//                marfx.getCloc().setValue(locfx.getTname().getText());
//            }
//        });
//
//    }
//    public void listmartyr(Stage stage,MartyrDate date,DistrictT dis,LocationT loc){
//        hlist=new HBox(70);
//        upd=new Button("Update Martyr");
//        delete=new Button("Delete Martyr");
//        upd.setFont(font);
//        delete.setFont(font);
//        hlist.getChildren().addAll(delete,upd);
//        hlist.setAlignment(Pos.CENTER);
//        hlist.setPadding(new Insets(25));
//        tableView = new TableView<>();
//        name = new TableColumn<>("Name");
//        age = new TableColumn<>("Age");
//        gender = new TableColumn<>("Gender");
//        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        age.setCellValueFactory(new PropertyValueFactory<>("age"));
//        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        name.setMinWidth(350);
//        tableView.getColumns().addAll(name, age, gender);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        root.setCenter(tableView);
//        root.setBottom(hlist);
//        root.setTop(back);
//        ObservableList list= FXCollections.observableArrayList(date.getMar().listMar());
//        tableView.setItems(list);
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
//        delete.setOnAction(e->{
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Delete the Martyr?");
//            confirmAlert.setContentText("This will Delete the Martyr . ");
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        Martyr marselect=tableView.getSelectionModel().getSelectedItem();
//                        if(marselect!=null){
//                            date.getMar().remove(marselect);
//                            ObservableList list2= FXCollections.observableArrayList(date.getMar().listMar());
//                            tableView.setItems(list2);
//                        }else {
//                            ResAlert("Error !","Select The Martyr to delete");
//                        }
//                    } catch (Exception ex) {
//                        ResAlert("Error", "Error Delete Martyr: " + ex.getMessage());
//                    }
//                }
//
//            });
//
//        });
//        upd.setOnAction(e->{
//            Martyr marselect=tableView.getSelectionModel().getSelectedItem();
//            UpdateMar(stage,date,dis,loc,marselect);
//        });
//    }
//    public void Search(Stage stage){
//        ObservableList list1= FXCollections.observableArrayList(Dtree.cboxDis());
//        tableView = new TableView<>();
//        name = new TableColumn<>("Name");
//        age = new TableColumn<>("Age");
//        gender = new TableColumn<>("Gender");
//        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        age.setCellValueFactory(new PropertyValueFactory<>("age"));
//        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        name.setMinWidth(350);
//        tableView.getColumns().addAll(name, age, gender);
//        vser=new VBox(10);
//
//        SearchFx ser=new SearchFx();
//        ser.getCdis().setItems(list1);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        vser.getChildren().addAll(ser.gethBox(),tableView);
//        vser.setAlignment(Pos.CENTER);
//        vser.setPadding(new Insets(25));
//        root.setCenter(vser);
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
//            if(ser.getCdis().getValue()!=null) {
//                ObservableList list = FXCollections.observableArrayList(searchMartyr(ser.getTseaarch().getText(), ser.getCdis().getValue()));
//                tableView.setItems(list);
//            }else {
//                ResAlert("Error !","The ComboBox value is empty .");
//            }
//        });
//    }
//    public void InsertMar(Stage stage) {
//        OperationFx ins = new OperationFx();
//        ObservableList list = FXCollections.observableArrayList(Dtree.cboxDis());
//        ins.getTdis().setItems(list);
//        ObservableList list1 = null;
//        ins.getTloc().setItems(list1);
//        Button back = new Button(null, new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root = new BorderPane();
//        root.setCenter(ins.getVbox());
//        root.setBottom(ins.getHres());
//        root.setTop(back);
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e -> {
//
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        ins.getTdis().setOnAction(e -> {
//            if (ins.getTdis().getValue() != null) {
//                ObservableList list2 = FXCollections.observableArrayList(((DistrictT) Dtree.find(new DistrictT(ins.getTdis().getValue())).getData()).getList().cboxLoc());
//                ins.getTloc().setItems(list2);
//            }
//        });
//        ins.getInsert().setOnAction(e -> {
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Add a new Martyr ?");
//            confirmAlert.setContentText("This will insert the Martyr ");
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        int age = Integer.parseInt(ins.getTage().getText().trim());
//
//                        LocalDate date = ins.getDate().getValue();
//                        if (date != null && !date.toString().isEmpty()) {
//                            String[] s = date.toString().split("-");
//                            String month = s[1];
//                            String day = s[2];
//                            if (Integer.parseInt(s[1]) < 10) {
//                                month = s[1].replace("0", "");
//                            }
//                            if (Integer.parseInt(s[2]) < 10) {
//                                day = s[2].replace("0", "");
//                            }
//                            String martyrDateStr = month + "/" + day + "/" + s[0];
//
//                            DistrictT district = (DistrictT) Dtree.find(new DistrictT(ins.getTdis().getValue())).getData();
//                            if (district != null) {
//                                LocationT location = (LocationT) district.getList().find(new LocationT(ins.getTloc().getValue())).getData();
//                                if (location != null) {
//                                    TNode node = location.getList().find(new MartyrDate(martyrDateStr));
//                                    if (node != null) {
//                                        MartyrDate martyrDate = (MartyrDate) location.getList().find(new MartyrDate(martyrDateStr)).getData();
//                                        if (martyrDate != null) {
//                                            martyrDate.getMar().insert(new Martyr(ins.getTname().getText(), String.valueOf(age), ins.getTgen().getValue()));
//                                        }
//                                    } else {
//                                        MartyrDate martyrDate = new MartyrDate(martyrDateStr);
//                                        martyrDate.getMar().insert(new Martyr(ins.getTname().getText(), String.valueOf(age), ins.getTgen().getValue()));
//                                        location.getList().insert(martyrDate);
//                                    }
//
//                                }
//                            }
//                        }
//                        ins.getTgen().setValue(null);
//                        ins.getTdis().setValue(null);
//                        ins.getTage().clear();
//                        ins.getTname().clear();
//                        ins.getTloc().setValue(null);
//                        ins.getDate().setValue(null);
//                    } catch (Exception ex) {
//                        ResAlert("Error", "Error updating location: " + ex.getMessage());
//
//                    }
//                }
//                ins.getTgen().setValue(null);
//                ins.getTdis().setValue(null);
//                ins.getTage().clear();
//                ins.getTname().clear();
//                ins.getTloc().setValue(null);
//                ins.getDate().setValue(null);
//
//            });
//        });
//    }
//    public void UpdateMar(Stage stage,MartyrDate mardate,DistrictT dis,LocationT loc,Martyr mar){
//        ObservableList list = FXCollections.observableArrayList(Dtree.cboxDis());
//        ObservableList list1 = null;
//        HBox hbox=new HBox();
//        OperationFx upd=new OperationFx();
//        upd.getTdis2().setItems(list);
//        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
//        back.setStyle("-fx-background-color: transparent;");
//        back.setAlignment(Pos.CENTER_LEFT);
//        back.setPadding(new Insets(25));
//        BorderPane root =new BorderPane();
//        hbox.getChildren().addAll(back,upd.getHboxser());
//        hbox.setAlignment(Pos.CENTER);
//        root.setTop(back);
//        root.setCenter(upd.getVboxupd());
//        root.setBottom(upd.getHres());
//
//        Scene scene = new Scene(root, 800, 700);
//        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
//        stage.setTitle("Update Martyr");
//        stage.setScene(scene);
//        stage.show();
//        back.setOnAction(e->{
//
//            try {
//                listmartyr(stage, mardate,dis,loc);
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//        upd.getTdis2().setOnAction(e -> {
//            if (upd.getTdis2().getValue() != null) {
//                ObservableList list2 = FXCollections.observableArrayList(((DistrictT) Dtree.find(new DistrictT(upd.getTdis2().getValue())).getData()).getList().cboxLoc());
//                upd.getTloc2().setItems(list2);
//            }
//        });
////        upd.getBtnser().setOnAction(e->{
////            if(upd.getTser().getText().isEmpty()){
////                upd.getLres().setText("text filed of search is empty");
////            }
////            Martyr mar= Searchmar(upd.getTser().getText());
////            if (mar!=null){
////                upd.getTname2().setText(mar.getName());
////                upd.getTage2().setText(mar.getAge());
////                upd.getTgen2().setText(mar.getGender());
//////                upd.getTdis2().setText(mar.getDistrict());
//////                upd.getTloc2().setText(mar.getLocation());
////////                String s[]=mar.getDate().split("/");
//////                LocalDate l=LocalDate.of(Integer.parseInt(s[2]),Integer.parseInt(s[0]),Integer.parseInt(s[1]));
//////                upd.getDate2().setValue(l);
////
////            }
////
////        });
//        upd.getTdis2().setValue(dis.getNamedis());
//        upd.getTloc2().setValue(loc.getName());
//        upd.getTname2().setText(mar.getName());
//        upd.getTage2().setText(mar.getAge());
//        upd.getTgen2().setValue(mar.getGender());
//        String s[]=mardate.getDate().split("/");
//        LocalDate l=LocalDate.of(Integer.parseInt(s[2]),Integer.parseInt(s[0]),Integer.parseInt(s[1]));
//        upd.getDate2().setValue(l);
//
//        upd.getUpdate().setOnAction(e->{
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Update the Martyr?");
//            confirmAlert.setContentText("This will Update the Martyr . ");
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if(mar!=null) {
//                            mardate.getMar().remove(mar);
//                            String[] st=upd.getDate2().getValue().toString().split("-");
//                            String month = st[1];
//                            String day = st[2];
//                            if (Integer.parseInt(st[1]) < 10) {
//                                month = st[1].replace("0", "");
//                            }
//                            if (Integer.parseInt(st[2]) < 10) {
//                                day = st[2].replace("0", "");
//                            }
//                            String martyrDateStr = month + "/" + day + "/" + st[0];
//                            DistrictT D=(DistrictT) Dtree.find(new DistrictT(upd.getTdis2().getValue())).getData();
//                            LocationT L=(LocationT) D.getList().find(new LocationT(upd.getTloc2().getValue())).getData();
//                            if (L.getList().find(new MartyrDate(martyrDateStr))!=null) {
//                                MartyrDate mard=(MartyrDate) L.getList().find(new MartyrDate(martyrDateStr)).getData();
//                                mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTage2().getText(), upd.getTgen2().getValue()));
//                                upd.getLres().setText("done update");
//                            } else {
//                                MartyrDate mard=new MartyrDate(martyrDateStr);
//                                mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTage2().getText(), upd.getTgen2().getValue()));
//                                L.getList().insert(mard);
//                                ResAlert("Error !","Do not Update .");
//                            }
//                        }
//                    } catch (Exception ex) {
//                        ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
//                    }
//                }
//
//            });
//        });
//    }
////    public void Deletemar(Stage stage){
////        OperationFx del=new OperationFx();
////        Button back = new Button(null,new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
////        back.setStyle("-fx-background-color: transparent;");
////        back.setAlignment(Pos.CENTER_LEFT);
////        back.setPadding(new Insets(25));
////        BorderPane root =new BorderPane();
////        root.setCenter(del.gethBox());
////        root.setBottom(del.getHres());
////        root.setTop(back);
////        Scene scene = new Scene(root, 800, 700);
////        scene.getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
////        stage.setTitle("Delete Martyr");
////        stage.setScene(scene);
////        stage.show();
////        back.setOnAction(e->{
////
////            try {
////                start(stage);
////            } catch (IOException ex) {
////                throw new RuntimeException(ex);
////            }
////
////        });
////        del.getDelete().setOnAction(e->{
////            if(del.getTdel().getText()!=null) {
////                Martyr mar = Searchmar(del.getTdel().getText());
////                if (mar!=null) {
//////                    District dis = Dlist.Find(mar.getDistrict());
//////                    Location loc = dis.getList().Find(mar.getLocation());
////
//////                    del.getLres().setText("Done remove ."+loc.getList().remove(mar));
////                }
////            }else{
////                del.getLres().setText("did not remove .");
////            }
////            del.getTdel().clear();
////        });
////    }
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
//
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Add a new District name?");
//            confirmAlert.setContentText("This will insert the District : "+disfx.getTins().getText());
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if(!disfx.getTins().getText().isEmpty() && Dtree.find(new DistrictT(disfx.getTins().getText().trim()))==null){
//                            Dtree.insert(new DistrictT(disfx.getTins().getText().trim()));
//                            disfx.getLres().setText("Done Added");
//                            sp=DisStack();
//                            while (!sn.isEmpty()){
//                                sn.pop();
//                            }
//                            while(!sp.isEmpty()){
//                                sn.push(sp.pop());
//                            }
//                        }else{
//                            ResAlert("Error", "Not Added " );
//                        }
//                        disfx.getTins().clear();
//                    } catch (Exception ex) {
//                        ResAlert("Error", "Error updating location: " + ex.getMessage());
//                    }
//                }
//
//            });
//        });
//    }
//    public void Deletedis(Stage stage){
//        DistrictFx disfx=new DistrictFx();
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
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
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Delete the Location name?");
//            confirmAlert.setContentText("This will Delete the District : "+disfx.getTdel().getValue());
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if (Dtree.find(new DistrictT(disfx.getTdel().getValue()))!=null){
//                            Dtree.delete(Dtree.find(new DistrictT(disfx.getTdel().getValue())).getData());
//                            disfx.getLres().setText("Done remove .");
//                            ObservableList list2= FXCollections.observableArrayList(Dtree.cboxDis());
//                            disfx.getTdel().setItems(list2);
//                            sp=DisStack();
//                            while (!sn.isEmpty()){
//                                sn.pop();
//                            }
//                            while(!sp.isEmpty()){
//                                sn.push(sp.pop());
//                            }
//                        }else{
//                            ResAlert("Error !", "Error Delete District . " );
//                        }
//                        disfx.getTdel().setValue(null);
//                    } catch (Exception ex) {
//                        ResAlert("Error !", "Error Delete District: " + ex.getMessage());
//                    }
//                }
//
//            });
//
//        });
//    }
//    public void Updatedis(Stage stage){
//        DistrictFx disfx=new DistrictFx();
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
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
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Update the District name?");
//            confirmAlert.setContentText("This will Update the District : "+disfx.getTupd1().getValue()+" To "+disfx.getTupd2().getText());
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if(Dtree.find(new DistrictT(disfx.getTupd1().getValue()))!=null && Dtree.find(new DistrictT(disfx.getTupd2().getText().trim()))==null && disfx.getTupd1().getValue()!=null && !disfx.getTupd2().getText().isEmpty()){
//                            DistrictT dis=(DistrictT) Dtree.find(new DistrictT(disfx.getTupd1().getValue())).getData();
//                            DistrictT d=new DistrictT(disfx.getTupd2().getText());
//                            d.setList(dis.getList());
//                            Dtree.delete(dis);
//                            Dtree.insert(d);
//                            sp=DisStack();
//                            while (!sn.isEmpty()){
//                                sn.pop();
//                            }
//                            while(!sp.isEmpty()){
//                                sn.push(sp.pop());
//                            }
//                            ObservableList list2= FXCollections.observableArrayList(Dtree.cboxDis());
//                            disfx.getTupd1().setItems(list2);
//                            disfx.getLres().setText("Done Update .");
//                        }else {
//                            ResAlert("Error !", "Do not update .");
//                        }
//                        disfx.getTupd1().setValue(null);
//                        disfx.getTupd2().clear();
//                    } catch (Exception ex) {
//                        ResAlert("Error !", "Error Update District: " + ex.getMessage());
//                    }
//                }
//
//            });
//        });
//    }
//    public void insertLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
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
//
//                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//                confirmAlert.setTitle("Confirmation interface");
//                confirmAlert.setHeaderText("Are you sure you want to insert the Location name?");
//                confirmAlert.setContentText("This will insert the Location : "+locfx.getTloc().getText());
//                confirmAlert.showAndWait().ifPresent(response -> {
//                    if (response == ButtonType.OK) {
//                        try {
//                            if (Dtree.find(new DistrictT(locfx.getTdis().getValue()))!=null){
//                                DistrictT dis=(DistrictT) Dtree.find(new DistrictT(locfx.getTdis().getValue())).getData();
//                                if (dis.getList().find(new LocationT(locfx.getTloc().getText()))==null) {
//                                    dis.getList().insert(new LocationT(locfx.getTloc().getText()));
//                                    locfx.getLres().setText("Done Insert .");
//                                }else {
//                                    ResAlert("Error !", "the location already exists ." );
//                                }
//                            }else{
//                                ResAlert("Error !", "i did not find the district . " );
//                            }
//                            locfx.getTdis().setValue(null);
//                            locfx.getTloc().clear();
//                        } catch (Exception ex) {
//                            ResAlert("Error !", "Error Insert location: " + ex.getMessage());
//                        }
//                    }
//
//                });
//        });
//    }
//    public void updateLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
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
//            ObservableList list2= FXCollections.observableArrayList(((DistrictT)Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().cboxLoc());
//            locfx.getTupd1().setItems(list2);
//        });
//
//        locfx.getUpdate().setOnAction(e->{
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Update the Location name?");
//            confirmAlert.setContentText("This will Update the Location : "+locfx.getTupd1().getValue()+" To "+locfx.getTupd2().getText());
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if(locfx.getUpddis().getValue()!=null) {
//                            if (((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().find(new LocationT(locfx.getTupd1().getValue())) != null
//                                    && ((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().find(new LocationT(locfx.getTupd2().getText())) == null && locfx.getTupd1().getValue()!=null && !locfx.getTupd2().getText().isEmpty()) {
//                                LocationT loc = (LocationT) ((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().find(new LocationT(locfx.getTupd1().getValue())).getData();
//                                LocationT l = new LocationT(locfx.getTupd2().getText());
//                                l.setList(loc.getList());
//                                ((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().insert(l);
//                                ((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().delete(loc);
//                                ObservableList list3 = FXCollections.observableArrayList(((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList().cboxLoc());
//                                locfx.getTupd1().setItems(list3);
//                                locfx.getLres().setText("Done Update .");
//                            } else {
//                                ResAlert("Error !", "Do not update . ");
//                            }
//                        }else {
//                            ResAlert("Error !", "Do not update . ");
//                        }
//                        locfx.getTupd1().setValue(null);
//                        locfx.getTupd2().clear();
//                    } catch (Exception ex) {
//                        ResAlert("Error !", "Error Update location: " + ex.getMessage());
//                    }
//                }
//
//            });
//        });
//    }
//    public void deleteLoc(Stage stage){
//        LocationFx locfx=new LocationFx();
//        ObservableList list= FXCollections.observableArrayList(Dtree.cboxDis());
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
//            ObservableList list2= FXCollections.observableArrayList(((DistrictT)Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList().cboxLoc());
//            locfx.getTdel().setItems(list2);
//        });
//        locfx.getDelete().setOnAction(e->{
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Delete the Location name?");
//            confirmAlert.setContentText("This will Delete the Location : "+locfx.getTdel().getValue());
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        if (((DistrictT)Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList().find(new LocationT(locfx.getTdel().getValue()))!=null ){
//                            ((DistrictT)Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList().delete(((DistrictT)Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList().find(new LocationT(locfx.getTdel().getValue())).getData());
//                            ObservableList list3= FXCollections.observableArrayList(((DistrictT)Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList().cboxLoc());
//                            locfx.getTdel().setItems(list3);
//                            locfx.getLres().setText("Done delete");
//                        }else {
//                            ResAlert("Error !", "Error Update location . " );
//                        }
//                        locfx.getTdel().setValue(null);
//                    } catch (Exception ex) {
//                        ResAlert("Error !", "Error Delete location: " + ex.getMessage());
//                    }
//                }
//
//            });
//        });
//    }
//    public Stack DisStack() {
//        Stack sDis = new Stack();
//        Stackdis(Dtree.getRoot(), sDis);
//        return sDis;
//    }
//    private void Stackdis(TNode node, Stack sDis) {
//        if (node == null) {
//            return;
//        }
//        Stackdis(node.getLeft(), sDis);
//        sDis.push(node.getData());
//        Stackdis(node.getRight(), sDis);
//    }
//    public Stack LocStack(String Dis) {
//        Stack sDis = new Stack();
//        TNode node=Dtree.find(new DistrictT(Dis));
//        if(node!=null) {
//            DistrictT d = (DistrictT) node.getData();
//            levelOrderLoc(d.getList().getRoot(), sDis);
//        }
//
//        return sDis;
//    }
//    static Stack levelOrderLoc(TNode root,Stack sloc) {
//        if (root == null)
//            return sloc;
//
//        Queue q = new Queue();
//
//        q.enQueue(root);
//
//        while (!q.isEmpty()) {
//
//            TNode curr = q.deQueue();
//                if (curr.getLeft() != null)
//                    q.enQueue(curr.getLeft());
//
//                if (curr.getRight() != null)
//                    q.enQueue(curr.getRight());
//
//                sloc.push((LocationT)curr.getData());
//        }
//        return sloc;
//    }
////    public Stack LocStack(String Dis) {
////        Stack sDis = new Stack();
////        DistrictT d=(DistrictT) Dtree.find(new DistrictT(Dis)).getData();
////        Stackloc(d.getList().getRoot(), sDis);
////        return sDis;
////    }
////    private void Stackloc(TNode node, Stack sDis) {
////        if (node == null) {
////            return;
////        }
////        Stackdis(node.getLeft(), sDis);
////        sDis.push(node.getData());
////        Stackdis(node.getRight(), sDis);
////    }
//    public Stack MarStack(String Dis,String Loc) {
//        Stack sMar = new Stack();
//        DistrictT d=(DistrictT) Dtree.find(new DistrictT(Dis)).getData();
//        TNode node= d.getList().find(new LocationT(Loc));
//        if(node!=null) {
//            LocationT loc = (LocationT) node.getData();
//            StackMar(loc.getList().getRoot(), sMar);
//        }
//        return sMar;
//    }
//    private void StackMar(TNode node, Stack sMar) {
//        if (node == null) {
//            return;
//        }
//        Stackdis(node.getLeft(), sMar);
//        sMar.push(node.getData());
//        Stackdis(node.getRight(), sMar);
//    }
//    public String MaxDateMartyr(String Dis,String Loc) {
//        String s="";
//        int count=0;
//        DistrictT d=(DistrictT) Dtree.find(new DistrictT(Dis)).getData();
//        LocationT loc=(LocationT) d.getList().find(new LocationT(Loc)).getData();
//        s= MaxDateMar(loc.getList().getRoot(), s ,count);
//        return s;
//
//    }
//    private String MaxDateMar(TNode node, String max,int count) {
//        if (node == null) {
//            return max;
//        }
//        max= MaxDateMar(node.getLeft(), max,count);
//        if(((MartyrDate)node.getData()).getMar().getSize()>count){
//            count=((MartyrDate)node.getData()).getMar().getSize();
//            max=((MartyrDate)node.getData()).getDate();
//        }
//        max= MaxDateMar(node.getRight(), max,count);
//        return max;
//    }
//    public ArrayList<Martyr> searchMartyr(String partialName,String Dis) {
//        ArrayList<Martyr> matchingMartyrs = new ArrayList<>();
//        DistrictT d=(DistrictT) Dtree.find(new DistrictT(Dis)).getData();
//        traverseLoc(d.getList().getRoot(), partialName, matchingMartyrs);
//        return matchingMartyrs;
//    }
//    private void traverseDis(TNode node, String partialName, List<Martyr> matchingMartyrs) {
//        if (node == null) {
//            return;
//        }
//        traverseDis(node.getLeft(), partialName, matchingMartyrs);
//        traverseLoc(((DistrictT)node.getData()).getList().getRoot(), partialName, matchingMartyrs);
//        traverseDis(node.getRight(), partialName, matchingMartyrs);
//    }
//    public void traverseLoc(TNode node, String partialName, List<Martyr> matchingMartyrs) {
//        if (node == null) {
//            return;
//        }
//        traverseLoc(node.getLeft(), partialName, matchingMartyrs);
//        traverseMar(((LocationT)node.getData()).getList().getRoot(), partialName, matchingMartyrs);
//        traverseLoc(node.getRight(), partialName, matchingMartyrs);
//    }
//    public void traverseMar(TNode node, String partialName, List<Martyr> matchingMartyrs) {
//        if (node == null) {
//            return;
//        }
//        traverseMar(node.getLeft(), partialName, matchingMartyrs);
//           SNode temp=((MartyrDate)node.getData()).getMar().getFirst();
//
//            for (int i=0;i<((MartyrDate)node.getData()).getMar().getSize();i++) {
//                Martyr mar=(Martyr)temp.getData();
//                if (mar.getName().toLowerCase().contains(partialName.toLowerCase())) {
//                    matchingMartyrs.add(mar);
//                }
//                temp=temp.getNext();
//            }
//        traverseMar(node.getRight(), partialName, matchingMartyrs);
//    }
//    public int countMartyr(String dis){
//
//        return traverseloc(((DistrictT)Dtree.find(new DistrictT(dis)).getData()).getList().getRoot());
//
//    }
//    public int traverseloc(TNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int c=traverseloc(node.getLeft());
//        c+=traversemar(((LocationT)node.getData()).getList().getRoot());
//        c+=traverseloc(node.getRight());
//        return c;
//    }
//    public int traversemar(TNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int c=traversemar(node.getLeft());
//        c+=((MartyrDate)node.getData()).getMar().getSize();
//        c+=traversemar(node.getRight());
//        return c;
//    }
//    private void ResAlert(String st, String discribtion) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(st);
//        alert.setContentText(discribtion);
//        alert.setHeaderText(null);
//
//        DialogPane dialogPane = alert.getDialogPane();
//        dialogPane.setPrefSize(350, 200);
//        dialogPane.setStyle("-fx-border-color: red; " + "-fx-border-width: 3; " + "-fx-padding: 13; "
//                + "-fx-font-size: 12px; " + "-fx-font-family: 'Arial';");
//
//        alert.showAndWait();
//    }
//    public void SaveToFile(){
//        try(PrintWriter w=new PrintWriter("Data.csv")){
//            w.append("Name,event,Age,location,District,Gender\n");
//            Queue qdis = new Queue();
//
//            qdis.enQueue(Dtree.getRoot());
//
//            while (!qdis.isEmpty()) {
//                TNode ndis = qdis.deQueue();
//                if(ndis!=null){
//                    Queue qloc=new Queue();
//                    qloc.enQueue(((DistrictT)ndis.getData()).getList().getRoot());
//                    while (!qloc.isEmpty()) {
//                        TNode nloc = qloc.deQueue();
//                        if(nloc!=null){
//                            Queue qdate=new Queue();
//                            qdate.enQueue(((LocationT)nloc.getData()).getList().getRoot());
//                            while (!qdate.isEmpty()){
//                                TNode ndate=qdate.deQueue();
//                                if (ndate!=null){
//                                    SNode nmar=((MartyrDate)ndate.getData()).getMar().getFirst();
//                                    do {
//                                        Martyr martyr=(Martyr)nmar.getData();
//                                        w.append(martyr.getName()+","+((MartyrDate)ndate.getData()).getDate()+","+martyr.getAge()+","+((LocationT)nloc.getData()).getName()+","+((DistrictT)ndis.getData()).getNamedis()+","+martyr.getGender()+"\n");
//                                        nmar=nmar.getNext();
//                                    }while (nmar!=((MartyrDate)ndate.getData()).getMar().getFirst());
//                                }
//                                if (ndate.getLeft() != null)
//                                    qdate.enQueue(ndate.getLeft());
//
//                                if (ndate.getRight() != null)
//                                    qdate.enQueue(ndate.getRight());
//                            }
//                        }
//                        if (nloc.getLeft() != null)
//                            qloc.enQueue(nloc.getLeft());
//
//                        if (nloc.getRight() != null)
//                            qloc.enQueue(nloc.getRight());
//                    }
//                }
//                if (ndis.getLeft() != null)
//                    qdis.enQueue(ndis.getLeft());
//
//                if (ndis.getRight() != null)
//                    qdis.enQueue(ndis.getRight());
//
//
//            }
//
//        }catch(Exception e){
//            ResAlert("Error !","Do not Save to file : "+e.getMessage());
//        }
//    }
//
//
//
//
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
