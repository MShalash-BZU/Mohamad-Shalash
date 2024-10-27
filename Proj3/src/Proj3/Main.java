package Proj3;

import Proj1.*;
import Proj2.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
	static DistrictTree Dtree = new DistrictTree();
	private HashTable Htable = new HashTable();
	private DateFx dateFx = new DateFx();
	private VBox vbox, vser;
	private String str;
	private HBox hlist, hradio, hsize, hpicker;
	private Button upd, delete;
	private FileChooser file;
	private RadioButton empty, notempty;
	private File f;
	private Label lsize, lhight;
	private TextField tsize = new TextField(), thight = new TextField();
	private DatePicker dpicker = new DatePicker();
	private Proj2.Stack sn = new Proj2.Stack(), spM = new Proj2.Stack(), snM = new Proj2.Stack();
	private Proj2.Stack sp = new Proj2.Stack(), snL = new Proj2.Stack(), spL = new Proj2.Stack();
	private TableView<Martyr> tableView, tablemartyr = new TableView<>();
	private TableView<HNode> tableView2;
	private TableColumn<Martyr, String> name, age, gender, district, location, Name, Age, Gender, District, Location;
	private TableColumn<HNode, String> date;
	TableColumn<HNode, Character> flag;
	private Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);

	@Override
	public void start(Stage stage) throws IOException {
		lsize = new Label("Size :");
		lsize.setAlignment(Pos.CENTER_RIGHT);
		lhight = new Label("Hight :");
		hsize = new HBox(10);
		hsize.getChildren().addAll(lsize, tsize, lhight, thight);
		hsize.setAlignment(Pos.CENTER_RIGHT);
		lsize.setFont(font);
		lhight.setFont(font);
		lsize.setTextFill(Color.SPRINGGREEN);
		lhight.setTextFill(Color.SPRINGGREEN);
		hpicker = new HBox(30);
		hpicker.getChildren().addAll(dpicker, hsize);
		hpicker.setAlignment(Pos.CENTER);
		hpicker.setPadding(new Insets(20));
		if (tablemartyr.getColumns().isEmpty()) {
			Name = new TableColumn<>("Name");
			District = new TableColumn<>("District");
			Location = new TableColumn<>("Location");
			Age = new TableColumn<>("Age");
			Gender = new TableColumn<>("Gender");
			Name.setCellValueFactory(new PropertyValueFactory<>("name"));
			Age.setCellValueFactory(new PropertyValueFactory<>("age"));
			Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
			District.setCellValueFactory(new PropertyValueFactory<>("district"));
			Location.setCellValueFactory(new PropertyValueFactory<>("location"));
			Name.setMinWidth(300);
			Age.setCellFactory(TextFieldTableCell.forTableColumn());
			Location.setCellFactory(TextFieldTableCell.forTableColumn());
			District.setCellFactory(TextFieldTableCell.forTableColumn());
			Gender.setCellFactory(TextFieldTableCell.forTableColumn());
			Name.setCellFactory(TextFieldTableCell.forTableColumn());
			Location.setMinWidth(200);
			tablemartyr.getColumns().addAll(Name, District, Location, Age, Gender);
			tablemartyr.setEditable(true);

		}
		Name.setOnEditCommit(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Update a name Martyr ?");
			confirmAlert.setContentText("This will update the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						Martyr nm = e.getRowValue();
						nm.setName(e.getNewValue());
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}
			});
		});
		Age.setOnEditCommit(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to update a age Martyr ?");
			confirmAlert.setContentText("This will update the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						Martyr nm = e.getRowValue();
						nm.setAge(e.getNewValue());
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}
			});
		});
		District.setOnEditCommit(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to update a District Martyr ?");
			confirmAlert.setContentText("This will update the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						Martyr nm = e.getRowValue();
						nm.setDistrict(e.getNewValue());
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}
			});
		});
		Location.setOnEditCommit(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to update a location Martyr ?");
			confirmAlert.setContentText("This will update the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						Martyr nm = e.getRowValue();
						nm.setLocation(e.getNewValue());
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}
			});
		});
		Gender.setOnEditCommit(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to update a gender Martyr ?");
			confirmAlert.setContentText("This will update the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (e.getNewValue().equalsIgnoreCase("M") || e.getNewValue().equalsIgnoreCase("F")) {
							Martyr nm = e.getRowValue();
							nm.setGender(e.getNewValue());
						} else {
							ResAlert("Error !", "Enter the Gender 'M' or 'F'");
						}
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}
			});
		});
		dpicker.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isAfter(LocalDate.now())) {
					setDisable(true);
					setStyle("-fx-background-color: #c3c2c1;");
				}
			}
		});

		vbox = new VBox();
		TabPane tpane = new TabPane();
		Tab datetab = new Tab("        Date           ");
		Tab martyr = new Tab("         Martyr          ");
		tpane.getTabs().addAll(datetab, martyr);

		MartyrScreen marfx = new MartyrScreen();

		Interface intfx = new Interface();

		BorderPane datebord = new BorderPane();
		datebord.setLeft(dateFx.getGpane());
		datebord.setCenter(dateFx.getVshow());
		datebord.setRight(dateFx.getTnevg());
		datebord.setTop(dateFx.getBack());

		BorderPane marbord = new BorderPane();
		marbord.setLeft(marfx.getGpane());
		marbord.setCenter(tablemartyr);
		marbord.setTop(marfx.getBack());
		marbord.setBottom(hpicker);

		BorderPane proj = new BorderPane();
		proj.setCenter(intfx.getGpane());
		datetab.setContent(datebord);
		martyr.setContent(marbord);

		if (f != null) {
			intfx.getLoadFile().setDisable(true);

		}
		file = new FileChooser();
		vbox.getChildren().addAll(intfx.getMenu(), tpane);

		Scene scene = new Scene(vbox, 1000, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
		intfx.getNewScreen().setOnAction(e -> {
			stage.close();
			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		intfx.getBtnloc().setOnAction(e -> {
			tpane.getSelectionModel().select(1);
		});
		intfx.getBtndis().setOnAction(e -> {
			tpane.getSelectionModel().select(2);
		});
		marfx.getBack().setOnAction(e -> {
			tpane.getSelectionModel().select(0);
		});
		intfx.getBtnmar().setOnAction(e -> {
			tpane.getSelectionModel().select(3);
		});
		dateFx.getTname().setOnKeyTyped(e -> {
			if (dateFx.getTname().getText() != null) {
				ObservableList list = FXCollections.observableArrayList(
						((Date) Htable.searchBol(new Date(dateFx.getTname().getText()))).getMar().levelOrdermartyr());
				tablemartyr.setItems(list);
			}
		});
		intfx.getSavefiel().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Save to file?");
			confirmAlert.setContentText("This will save the Data . ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					savefile();
				}

			});
		});
		dateFx.getTnevg().setOnAction(e -> {
			String[] s = dateFx.getTnevg().getValue().toString().split("-");
			String month = s[1];
			String day = s[2];
			if (Integer.parseInt(s[1]) < 10) {
				month = s[1].replace("0", "");
			}
			if (Integer.parseInt(s[2]) < 10) {
				day = s[2].replace("0", "");
			}
			String DateStr = month + "/" + day + "/" + s[0];
			Date d = (Date) Htable.searchBol(new Date(DateStr));
			if (d != null) {
				dateFx.getTname().setText(d.getDate());
				dateFx.getTtotal().setText(String.valueOf(d.getMar().countMar()));
				dateFx.getTavg().setText(String.valueOf(d.getMar().countAge()));
				dateFx.getTloc().setText(d.getMar().Maxloc());
				dateFx.getTdis().setText(d.getMar().Maxdis());
				if (dateFx.getTname().getText() != null) {
					str = dateFx.getTname().getText();
					ObservableList list = FXCollections
							.observableArrayList(((Date) Htable.searchBol(new Date(dateFx.getTname().getText())))
									.getMar().levelOrdermartyr());
					tablemartyr.setItems(list);
					tsize.setText(String.valueOf(d.getMar().countMar()));
					thight.setText(String.valueOf(d.getMar().getHeight()));
					LocalDate l = dateFx.getTnevg().getValue();
					dpicker.setValue(l);
				}
			}
		});
		intfx.getLoadFile().setOnAction(e -> {
			file.setTitle("Open File ");
			file.setInitialDirectory(new File("C:\\"));
			f = file.showOpenDialog(stage);
			if (f != null) {
				try {
					Scanner in = new Scanner(f);
					in.nextLine();
					int c = 0;
					while (in.hasNextLine()) {
						String line = in.nextLine();
						String[] s = line.split(",");
						if (s.length < 6) {
							System.out.println(s[0]);
							c--;
							continue;
						}
						String name = s[0].trim();
						String date = s[1];
						String age = s[2].trim();
						String loc = s[3].trim();
						String dis = s[4].trim();
						String gender = s[5].trim();
						if (age.isEmpty() || age == null) {
							age = "n/a";
						}
						if (date == null || date.isEmpty()) {
							continue;
						}
						Date mardate = new Date(date);
						Martyr mar = new Martyr(name, dis, loc, age, gender);
						if (Htable.searchBol(mardate) == null) {
							Htable.insert(mardate);
							mardate.getMar().insert(mar);
						} else {
							((Date) Htable.searchBol(mardate)).getMar().insert(mar);
						}
					}
					sp = Htable.DateSt();
					while (!sp.isEmpty()) {
						sn.push(sp.pop());
					}
					if (!sn.isEmpty()) {
						Date d = (Date) sn.peek();
						dateFx.getTname().setText(d.getDate());
						dateFx.getTtotal().setText(String.valueOf(d.getMar().countMar()));
						dateFx.getTavg().setText(String.valueOf(d.getMar().countAge()));
						dateFx.getTloc().setText(d.getMar().Maxloc());
						dateFx.getTdis().setText(d.getMar().Maxdis());
						if (dateFx.getTname().getText() != null) {
							str = dateFx.getTname().getText();
							ObservableList list = FXCollections.observableArrayList(
									((Date) Htable.searchBol(new Date(dateFx.getTname().getText()))).getMar()
											.levelOrdermartyr());
							tablemartyr.setItems(list);
							tsize.setText(String.valueOf(d.getMar().countMar()));
							thight.setText(String.valueOf(d.getMar().height(d.getMar().getRoot())));
							String s[] = str.split("/");
							LocalDate l = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[0]),
									Integer.parseInt(s[1]));
							dpicker.setValue(l);
							dateFx.getTnevg().setValue(l);
						}
						sp.push(sn.pop());
					}
					intfx.getLoadFile().setDisable(true);
					System.out.println(Htable.getSize());
					System.out.println(c);

				} catch (FileNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		marfx.getBtnins().setOnAction(e -> {
			InsertMar(stage);

		});

		marfx.getBtnsort().setOnAction(e -> {
			if (str != null) {
				Date dat = (Date) Htable.searchBol(new Date(str));
				if (dat != null)
					listmartyr(stage, dat);
			}
		});

		marfx.getCloc().setOnAction(e -> {
			if (marfx.getCloc().getValue() != null) {
				while (!snM.isEmpty()) {
					snM.pop();
				}
				while (!spM.isEmpty()) {
					snM.push(spM.pop());
				}
				if (!snM.isEmpty()) {
					MartyrDate mardate = (MartyrDate) snM.peek();
					marfx.getTdate().setText(mardate.getDate());
					marfx.getTold().setText(mardate.getMar().oldest());
					marfx.getTyoung().setText(mardate.getMar().youngest());
					marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
				}
			}
		});
		dpicker.setOnAction(e -> {
			if (dpicker.getValue().toString() != null) {
				LocalDate date = dpicker.getValue();
				if (date != null && !date.toString().isEmpty()) {
					String[] s = date.toString().split("-");
					String month = s[1];
					String day = s[2];
					if (Integer.parseInt(s[1]) < 10) {
						month = s[1].replace("0", "");
					}
					if (Integer.parseInt(s[2]) < 10) {
						day = s[2].replace("0", "");
					}
					String DateStr = month + "/" + day + "/" + s[0];
					str = DateStr;
					if (((Date) Htable.searchBol(new Date(str))) != null) {
						ObservableList list = FXCollections.observableArrayList(
								((Date) Htable.searchBol(new Date(str))).getMar().levelOrdermartyr());
						tablemartyr.setItems(list);
						tsize.setText(String.valueOf(((Date) Htable.searchBol(new Date(str))).getMar().countMar()));
						thight.setText(String.valueOf(((Date) Htable.searchBol(new Date(str))).getMar().getHeight()));
					}
				}
			}
		});
		dateFx.getUp().setOnAction(e -> {
			if (!sn.isEmpty()) {
				Date d = (Date) sn.peek();
				dateFx.getTname().setText(d.getDate());
				dateFx.getTtotal().setText(String.valueOf(d.getMar().countMar()));
				dateFx.getTavg().setText(String.valueOf(d.getMar().countAge()));
				dateFx.getTloc().setText(d.getMar().Maxloc());
				dateFx.getTdis().setText(d.getMar().Maxdis());
				if (dateFx.getTname().getText() != null) {
					str = dateFx.getTname().getText();
					ObservableList list = FXCollections
							.observableArrayList(((Date) Htable.searchBol(new Date(dateFx.getTname().getText())))
									.getMar().levelOrdermartyr());
					tablemartyr.setItems(list);
					tsize.setText(String.valueOf(d.getMar().countMar()));
					thight.setText(String.valueOf(d.getMar().height(d.getMar().getRoot())));
					String s[] = str.split("/");
					LocalDate l = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
					dpicker.setValue(l);
					dateFx.getTnevg().setValue(l);
				}
				sp.push(sn.pop());
			}
		});
		dateFx.getDown().setOnAction(e -> {
			if (!sp.isEmpty()) {
				Date d = (Date) sp.peek();
				dateFx.getTname().setText(d.getDate());
				dateFx.getTtotal().setText(String.valueOf(d.getMar().countMar()));
				dateFx.getTavg().setText(String.valueOf(d.getMar().countAge()));
				dateFx.getTloc().setText(d.getMar().Maxloc());
				dateFx.getTdis().setText(d.getMar().Maxdis());
				if (dateFx.getTname().getText() != null) {
					str = dateFx.getTname().getText();
					ObservableList list = FXCollections
							.observableArrayList(((Date) Htable.searchBol(new Date(dateFx.getTname().getText())))
									.getMar().levelOrdermartyr());
					tablemartyr.setItems(list);
					tsize.setText(String.valueOf(d.getMar().countMar()));
					thight.setText(String.valueOf(d.getMar().height(d.getMar().getRoot())));
					String s[] = str.split("/");
					LocalDate l = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
					dpicker.setValue(l);
					dateFx.getTnevg().setValue(l);
				}
				sn.push(sp.pop());
			}
		});
		marfx.getBtndel().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Delete the Martyr?");
			confirmAlert.setContentText("This will Delete the Martyr . ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						Martyr marselect = tablemartyr.getSelectionModel().getSelectedItem();
						if (marselect != null) {
							Date d = (Date) Htable.searchBol(new Date(str));
							d.getMar().delete(marselect);
							ObservableList list2 = FXCollections.observableArrayList(
									((Date) Htable.searchBol(new Date(str))).getMar().levelOrdermartyr());
							tablemartyr.setItems(list2);
							tsize.setText(String.valueOf(d.getMar().countMar()));
							thight.setText(String.valueOf(d.getMar().height(d.getMar().getRoot())));
						} else {
							ResAlert("Error !", "Select The Martyr to delete");
						}
					} catch (Exception ex) {
						ResAlert("Error", "Error Delete Martyr: " + ex.getMessage());
					}
				}

			});

		});
		marfx.getBtnupd().setOnAction(e -> {
			Martyr marselect = tablemartyr.getSelectionModel().getSelectedItem();
			if (marselect != null)
				UpdateMar(stage, (Date) Htable.searchBol(new Date(str)), marselect);
			else {
				ResAlert("Error !", "Select the martyr to Update");
			}
		});
		marfx.getNext().setOnAction(e -> {
			if (!snM.isEmpty()) {
				MartyrDate mardate = (MartyrDate) snM.peek();
				marfx.getTdate().setText(mardate.getDate());
				marfx.getTold().setText(mardate.getMar().oldest());
				marfx.getTyoung().setText(mardate.getMar().youngest());
				marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
				spM.push(snM.pop());
			}
		});
		marfx.getPrev().setOnAction(e -> {
			if (!spM.isEmpty()) {
				MartyrDate mardate = (MartyrDate) spM.peek();
				marfx.getTdate().setText(mardate.getDate());
				marfx.getTold().setText(mardate.getMar().oldest());
				marfx.getTyoung().setText(mardate.getMar().youngest());
				marfx.getTavg().setText(String.valueOf(mardate.getMar().average()));
				snM.push(spM.pop());
			}
		});
		marfx.getCdis().setOnAction(e -> {
			DistrictT d = (DistrictT) Dtree.find(new DistrictT(marfx.getCdis().getValue())).getData();
			ObservableList list2 = FXCollections.observableArrayList(d.getList().cboxLoc());
			marfx.getCloc().setItems(list2);
		});
		dateFx.getBtnins().setOnAction(e -> {
			InsertDate(stage);
		});
		dateFx.getBtnupdate().setOnAction(e -> {
			UpdateDate(stage);
		});
		dateFx.getBtndel().setOnAction(e -> {
			DeleteDate(stage);
		});
		dateFx.getBtnprint().setOnAction(e -> {
			PrintTable(stage);
		});

	}

	public void listmartyr(Stage stage, Date date) {
		hlist = new HBox(70);
		upd = new Button("Update Martyr");
		delete = new Button("Delete Martyr");
		upd.setFont(font);
		delete.setFont(font);
		hlist.getChildren().addAll(delete, upd);
		hlist.setAlignment(Pos.CENTER);
		hlist.setPadding(new Insets(25));
		tableView = new TableView<>();
		name = new TableColumn<>("Name");
		age = new TableColumn<>("Age");
		gender = new TableColumn<>("Gender");
		district = new TableColumn<>("District");
		location = new TableColumn<>("Location");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		location.setCellValueFactory(new PropertyValueFactory<>("location"));
		district.setCellValueFactory(new PropertyValueFactory<>("district"));
		name.setMinWidth(350);
		location.setMinWidth(200);
		tableView.getColumns().addAll(name, district, location, age, gender);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(tableView);
		root.setBottom(hlist);
		root.setTop(back);
		ObservableList list = FXCollections.observableArrayList(date.getMar().heapSort());
		tableView.setItems(list);
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Show Location");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
//        delete.setOnAction(e -> {
//            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
//            confirmAlert.setTitle("Confirmation interface");
//            confirmAlert.setHeaderText("Are you sure you want to Delete the Martyr?");
//            confirmAlert.setContentText("This will Delete the Martyr . ");
//            confirmAlert.showAndWait().ifPresent(response -> {
//                if (response == ButtonType.OK) {
//                    try {
//                        Martyr marselect = tableView.getSelectionModel().getSelectedItem();
//                        if (marselect != null) {
//                            date.getMar().remove(marselect);
//                            ObservableList list2 = FXCollections.observableArrayList(date.getMar().listMar());
//                            tableView.setItems(list2);
//                        } else {
//                            ResAlert("Error !", "Select The Martyr to delete");
//                        }
//                    } catch (Exception ex) {
//                        ResAlert("Error", "Error Delete Martyr: " + ex.getMessage());
//                    }
//                }
//
//            });
//
//        });
	}

	public void PrintTable(Stage stage) {
//        hlist=new HBox(70);
//        hlist.getChildren().addAll(delete,upd);
//        hlist.setAlignment(Pos.CENTER);
//        hlist.setPadding(new Insets(25));
		empty = new RadioButton(" including Empty");
		notempty = new RadioButton("excluding Empty");
		empty.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
		notempty.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
		ToggleGroup tg = new ToggleGroup();
		empty.setToggleGroup(tg);
		notempty.setToggleGroup(tg);
		hradio = new HBox(20);
		hradio.getChildren().addAll(empty, notempty);
		hradio.setAlignment(Pos.TOP_CENTER);
		hradio.setPadding(new Insets(25));
		tableView2 = new TableView<>();
		date = new TableColumn<>("Date");
		flag = new TableColumn<>("flag");
		date.setMinWidth(220);
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		flag.setCellValueFactory(new PropertyValueFactory<>("flag"));
		tableView2.getColumns().addAll(date, flag);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(tableView2);
		root.setTop(back);
		root.setBottom(hradio);
		empty.setOnAction(e -> {
			ObservableList list = FXCollections.observableArrayList(print(false));
			tableView2.setItems(list);
		});
		notempty.setOnAction(e -> {
			ObservableList list = FXCollections.observableArrayList(print(true));
			tableView2.setItems(list);
		});

		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Show Location");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});

	}

	public ArrayList<HNode> print(boolean b) {
		ArrayList<HNode> arr = new ArrayList<>();
		HNode[] hash = Htable.getHash();
		for (int i = 0; i < hash.length; i++) {
			if (hash[i].isFull() && b == true) {
				arr.add(new HNode(((Date) hash[i].getData()), hash[i].getFlag()));
			} else if (b == false) {
				if (hash[i].isFull())
					arr.add(new HNode(((Date) hash[i].getData()), hash[i].getFlag()));
				else
					arr.add(new HNode());
			}
		}
		return arr;
	}

	public void Search(Stage stage) {
		ObservableList list1 = FXCollections.observableArrayList(Dtree.cboxDis());
		tableView = new TableView<>();
		name = new TableColumn<>("Name");
		age = new TableColumn<>("Age");
		gender = new TableColumn<>("Gender");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		name.setMinWidth(350);
		tableView.getColumns().addAll(name, age, gender);
		vser = new VBox(10);

		SearchFx ser = new SearchFx();
		ser.getCdis().setItems(list1);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		vser.getChildren().addAll(ser.gethBox(), tableView);
		vser.setAlignment(Pos.CENTER);
		vser.setPadding(new Insets(25));
		root.setCenter(vser);
		root.setTop(back);
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		ser.getSearch().setOnAction(e -> {
			if (ser.getCdis().getValue() != null) {
				ObservableList list = FXCollections.observableArrayList();
				tableView.setItems(list);
			} else {
				ResAlert("Error !", "The ComboBox value is empty .");
			}
		});
	}

	public void InsertMar(Stage stage) {
		OperationFx ins = new OperationFx();
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(ins.getVbox());
		root.setBottom(ins.getHres());
		root.setTop(back);

		String stt[] = str.split("/");
		LocalDate l = LocalDate.of(Integer.parseInt(stt[2]), Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
		ins.getDate().setValue(l);

		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});

		ins.getInsert().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Add a new Martyr ?");
			confirmAlert.setContentText("This will insert the Martyr ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						int age = Integer.parseInt(ins.getTage().getText().trim());

						LocalDate date = ins.getDate().getValue();
						if (date != null && !date.toString().isEmpty()) {
							String[] s = date.toString().split("-");
							String month = s[1];
							String day = s[2];
							if (Integer.parseInt(s[1]) < 10) {
								month = s[1].replace("0", "");
							}
							if (Integer.parseInt(s[2]) < 10) {
								day = s[2].replace("0", "");
							}
							String martyrDateStr = month + "/" + day + "/" + s[0];
							Martyr mar = null;
							if (ins.getMale().isSelected()) {
								mar = new Martyr(ins.getTname().getText(), ins.getTdis().getText(),
										ins.getTloc().getText(), String.valueOf(age), "M");
							}
							if (ins.getFemale().isSelected()) {
								mar = new Martyr(ins.getTname().getText(), ins.getTdis().getText(),
										ins.getTloc().getText(), String.valueOf(age), "F");
							}
							if (ins.getFemale().isSelected() || ins.getMale().isSelected()) {
								if (Htable.searchBol(new Date(martyrDateStr)) == null) {
									Htable.insert(new Date(martyrDateStr));
									((Date) Htable.searchBol(new Date(martyrDateStr))).getMar().insert(mar);
								} else {
									((Date) Htable.searchBol(new Date(martyrDateStr))).getMar().insert(mar);
								}
								ins.getLres().setText("Done added.");
								sp = Htable.DateSt();
								while (!sn.isEmpty()) {
									sn.pop();
								}
								while (!sp.isEmpty()) {
									sn.push(sp.pop());
								}
							} else {
								ResAlert("Error", "Error Insert Martyr . ");
							}
						}
						ins.getTdis().setText(null);
						ins.getTage().clear();
						ins.getTname().clear();
						ins.getTloc().setText(null);
						ins.getDate().setValue(null);
					} catch (Exception ex) {
						ResAlert("Error", "Error Insert Martyr : " + ex.getMessage());

					}
				}
				ins.getTdis().setText(null);
				ins.getTage().clear();
				ins.getTname().clear();
				ins.getTloc().setText(null);
				ins.getDate().setValue(null);

			});
		});
	}

	public void UpdateMar(Stage stage, Date mardate, Martyr mar) {
		HBox hbox = new HBox();
		OperationFx upd = new OperationFx();

		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		hbox.getChildren().addAll(back, upd.getHboxser());
		hbox.setAlignment(Pos.CENTER);
		root.setTop(back);
		root.setCenter(upd.getVboxupd());
		root.setBottom(upd.getHres());

		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Update Martyr");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}

		});

		upd.getTdis2().setText(mar.getDistrict());
		upd.getTloc2().setText(mar.getLocation());
		upd.getTname2().setText(mar.getName());
		upd.getTage2().setText(mar.getAge());
		if (mar.getGender().equalsIgnoreCase("M")) {
			upd.getMale2().setSelected(true);
		} else {
			upd.getFemale2().setSelected(true);
		}
		String s[] = mardate.getDate().split("/");
		LocalDate l = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		upd.getDate2().setValue(l);

		upd.getUpdate().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Update the Martyr?");
			confirmAlert.setContentText("This will Update the Martyr . ");
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (mar != null) {
							mardate.getMar().delete(mar);
							String[] st = upd.getDate2().getValue().toString().split("-");
							String month = st[1];
							String day = st[2];
							if (Integer.parseInt(st[1]) < 10) {
								month = st[1].replace("0", "");
							}
							if (Integer.parseInt(st[2]) < 10) {
								day = st[2].replace("0", "");
							}
							String martyrDateStr = month + "/" + day + "/" + st[0];
							if (Htable.searchBol(new Date(martyrDateStr)) != null) {
								Date mard = (Date) Htable.searchBol(new Date(martyrDateStr));
								if (upd.getFemale2().isSelected()) {
									mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTdis2().getText(),
											upd.getTloc2().getText(), upd.getTage2().getText(), "F"));
								} else if (upd.getMale2().isSelected()) {
									mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTdis2().getText(),
											upd.getTloc2().getText(), upd.getTage2().getText(), "M"));

								}
								upd.getLres().setText("done update");
							} else {
								Date mard = new Date(martyrDateStr);
								if (upd.getFemale2().isSelected()) {
									mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTdis2().getText(),
											upd.getTloc2().getText(), upd.getTage2().getText(), "F"));
								} else if (upd.getMale2().isSelected()) {
									mard.getMar().insert(new Martyr(upd.getTname2().getText(), upd.getTdis2().getText(),
											upd.getTloc2().getText(), upd.getTage2().getText(), "M"));

								}
								Htable.insert(mard);
								ResAlert("Error !", "Do not Update .");
							}
							ObservableList list2 = FXCollections.observableArrayList(
									((Date) Htable.searchBol(mardate)).getMar().levelOrdermartyr());
							tablemartyr.setItems(list2);
							sp = Htable.DateSt();
							while (!sn.isEmpty()) {
								sn.pop();
							}
							while (!sp.isEmpty()) {
								sn.push(sp.pop());
							}
						}
					} catch (Exception ex) {
						ResAlert("Error", "Error Update Martyr: " + ex.getMessage());
					}
				}

			});
		});
	}

	public void InsertDate(Stage stage) {
		DateFx datefx = new DateFx();
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(datefx.getHboxins());
		root.setBottom(datefx.gethBox());
		root.setTop(back);
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Insert District");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		datefx.getInsert().setOnAction(e -> {
			try {
				Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
				confirmAlert.setTitle("Confirmation interface");
				confirmAlert.setHeaderText("Are you sure you want to Add a new Date name?");
				confirmAlert.setContentText("This will insert the Date : " + datefx.getTins().getValue().toString());
				confirmAlert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {

						if (datefx.getTins().getValue().toString() != null) {
							LocalDate date = datefx.getTins().getValue();
							String[] s = date.toString().split("-");
							String month = s[1];
							String day = s[2];
							if (Integer.parseInt(s[1]) < 10) {
								month = s[1].replace("0", "");
							}
							if (Integer.parseInt(s[2]) < 10) {
								day = s[2].replace("0", "");
							}
							String martyrDateStr = month + "/" + day + "/" + s[0];
							Htable.insert(new Date(martyrDateStr));

							datefx.getLres().setText("Done Added");
							sp = Htable.DateSt();
							while (!sn.isEmpty()) {
								sn.pop();
							}
							while (!sp.isEmpty()) {
								sn.push(sp.pop());
							}

						} else {
							ResAlert("Error", "Not Added ");
						}
						datefx.getTins().setValue(null);

					}

				});
			} catch (Exception ex) {
				ResAlert("Error", "Error updating location: " + ex.getMessage());
			}
		});
	}

	public void DeleteDate(Stage stage) {
		DateFx dateFx = new DateFx();
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(dateFx.getHboxdel());
		root.setBottom(dateFx.gethBox());
		root.setTop(back);

		String[] arr = str.split("/");
		LocalDate ld = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		dateFx.getTdel().setValue(ld);

		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Delete District");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		dateFx.getDelete().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Delete the Date ?");
			confirmAlert.setContentText("This will Delete the Date : " + dateFx.getTdel().getValue().toString());
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (dateFx.getTdel().getValue().toString() != null) {
							LocalDate date = dateFx.getTdel().getValue();
							String[] s = date.toString().split("-");
							String month = s[1];
							String day = s[2];
							if (Integer.parseInt(s[1]) < 10) {
								month = s[1].replace("0", "");
							}
							if (Integer.parseInt(s[2]) < 10) {
								day = s[2].replace("0", "");
							}
							String martyrDateStr = month + "/" + day + "/" + s[0];
							if (Htable.searchBol(new Date(martyrDateStr)) != null) {
								Htable.delete(Htable.searchBol(new Date(martyrDateStr)));
								dateFx.getLres().setText("Done Delete");
								sp = Htable.DateSt();
								while (!sn.isEmpty()) {
									sn.pop();
								}
								while (!sp.isEmpty()) {
									sn.push(sp.pop());
								}
							} else {
								ResAlert("Error !", "Error Delete Date . ");
							}

						} else {
							ResAlert("Error !", "Error Delete Date . ");
						}
						dateFx.getTdel().setValue(null);
					} catch (Exception ex) {
						ResAlert("Error !", "Error Delete Date: " + ex.getMessage());
					}
				}

			});

		});
	}

	public void UpdateDate(Stage stage) {
		DateFx dateFx = new DateFx();
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(dateFx.getvBoxupdate());
		root.setBottom(dateFx.gethBox());
		root.setTop(back);

		String[] arr = str.split("/");
		LocalDate ld = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		dateFx.getTupd1().setValue(ld);

		stage.show();
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Update District");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		dateFx.getUpdate().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Update the District name?");
			confirmAlert.setContentText("This will Update the District : " + dateFx.getTupd1().getValue().toString()
					+ " To " + dateFx.getTupd2().getValue().toString());
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (dateFx.getTupd1().getValue().toString() != null
								&& dateFx.getTupd2().getValue().toString() != null) {
							LocalDate date = dateFx.getTupd1().getValue();
							String[] s = date.toString().split("-");
							String month = s[1];
							String day = s[2];
							if (Integer.parseInt(s[1]) < 10) {
								month = s[1].replace("0", "");
							}
							if (Integer.parseInt(s[2]) < 10) {
								day = s[2].replace("0", "");
							}
							String martyrDateStr = month + "/" + day + "/" + s[0];
							if (Htable.searchBol(new Date(martyrDateStr)) != null) {
								LocalDate date2 = dateFx.getTupd2().getValue();
								String[] s2 = date2.toString().split("-");
								String month2 = s2[1];
								String day2 = s2[2];
								if (Integer.parseInt(s2[1]) < 10) {
									month2 = s2[1].replace("0", "");
								}
								if (Integer.parseInt(s2[2]) < 10) {
									day2 = s2[2].replace("0", "");
								}
								String martyrDateStr2 = month2 + "/" + day2 + "/" + s2[0];

								Date oldD = ((Date) Htable.searchBol(new Date(martyrDateStr)));
								Date newD = new Date(martyrDateStr2);
								newD.setMar(oldD.getMar());
								Htable.delete(oldD);
								Htable.insert(newD);
								dateFx.getLres().setText("Done Update .");
								sp = Htable.DateSt();
								while (!sn.isEmpty()) {
									sn.pop();
								}
								while (!sp.isEmpty()) {
									sn.push(sp.pop());
								}
							} else {
								ResAlert("Error !", "Do not update .");
							}
						} else {
							ResAlert("Error !", "Do not update .");
						}
						dateFx.getTupd1().setValue(null);
						dateFx.getTupd2().setValue(null);
					} catch (Exception ex) {
						ResAlert("Error !", "Error Update District: " + ex.getMessage());
					}
				}

			});
		});
	}

	public void insertLoc(Stage stage) {
		LocationFx locfx = new LocationFx();
		ObservableList list = FXCollections.observableArrayList(Dtree.cboxDis());
		locfx.getTdis().setItems(list);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(locfx.getVboxins());
		root.setBottom(locfx.getHres());
		root.setTop(back);
		stage.show();
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Insert Location");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		locfx.getInsert().setOnAction(e -> {

			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to insert the Location name?");
			confirmAlert.setContentText("This will insert the Location : " + locfx.getTloc().getText());
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (Dtree.find(new DistrictT(locfx.getTdis().getValue())) != null) {
							DistrictT dis = (DistrictT) Dtree.find(new DistrictT(locfx.getTdis().getValue())).getData();
							if (dis.getList().find(new LocationT(locfx.getTloc().getText())) == null) {
								dis.getList().insert(new LocationT(locfx.getTloc().getText()));
								locfx.getLres().setText("Done Insert .");
							} else {
								ResAlert("Error !", "the location already exists .");
							}
						} else {
							ResAlert("Error !", "i did not find the district . ");
						}
						locfx.getTdis().setValue(null);
						locfx.getTloc().clear();
					} catch (Exception ex) {
						ResAlert("Error !", "Error Insert location: " + ex.getMessage());
					}
				}

			});
		});
	}

	public void updateLoc(Stage stage) {
		LocationFx locfx = new LocationFx();
		ObservableList list = FXCollections.observableArrayList(Dtree.cboxDis());
		locfx.getUpddis().setItems(list);
		ObservableList list1 = null;
		locfx.getTupd1().setItems(list1);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(locfx.getvBoxupdate());
		root.setBottom(locfx.getHres());
		root.setTop(back);
		stage.show();
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Update Location");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		locfx.getUpddis().setOnAction(e -> {
			ObservableList list2 = FXCollections
					.observableArrayList(((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
							.getList().cboxLoc());
			locfx.getTupd1().setItems(list2);
		});

		locfx.getUpdate().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Update the Location name?");
			confirmAlert.setContentText("This will Update the Location : " + locfx.getTupd1().getValue() + " To "
					+ locfx.getTupd2().getText());
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (locfx.getUpddis().getValue() != null) {
							if (((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
									.getList().find(new LocationT(locfx.getTupd1().getValue())) != null
									&& ((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
											.getList().find(new LocationT(locfx.getTupd2().getText())) == null
									&& locfx.getTupd1().getValue() != null && !locfx.getTupd2().getText().isEmpty()) {
								LocationT loc = (LocationT) ((DistrictT) Dtree
										.find(new DistrictT(locfx.getUpddis().getValue())).getData()).getList()
										.find(new LocationT(locfx.getTupd1().getValue())).getData();
								LocationT l = new LocationT(locfx.getTupd2().getText());
								l.setList(loc.getList());
								((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
										.getList().insert(l);
								((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
										.getList().delete(loc);
								ObservableList list3 = FXCollections.observableArrayList(
										((DistrictT) Dtree.find(new DistrictT(locfx.getUpddis().getValue())).getData())
												.getList().cboxLoc());
								locfx.getTupd1().setItems(list3);
								locfx.getLres().setText("Done Update .");
							} else {
								ResAlert("Error !", "Do not update . ");
							}
						} else {
							ResAlert("Error !", "Do not update . ");
						}
						locfx.getTupd1().setValue(null);
						locfx.getTupd2().clear();
					} catch (Exception ex) {
						ResAlert("Error !", "Error Update location: " + ex.getMessage());
					}
				}

			});
		});
	}

	public void deleteLoc(Stage stage) {
		LocationFx locfx = new LocationFx();
		ObservableList list = FXCollections.observableArrayList(Dtree.cboxDis());
		locfx.getTdisdel().setItems(list);
		ObservableList list1 = null;
		locfx.getTdel().setItems(list1);
		Button back = new Button(null,
				new ImageView(new Image("file:///C:/Users/Asus/IdeaProjects/ProjectD/src/back.png")));
		back.setStyle("-fx-background-color: transparent;");
		back.setAlignment(Pos.CENTER_LEFT);
		back.setPadding(new Insets(25));
		BorderPane root = new BorderPane();
		root.setCenter(locfx.getVboxdel());
		root.setBottom(locfx.getHres());
		root.setTop(back);
		stage.show();
		Scene scene = new Scene(root, 800, 700);
		scene.getRoot().setStyle(
				"-fx-background-image: url('file:///C:/Users/Asus/IdeaProjects/ProjectD/src/palistine.png');");
		stage.setTitle("Delete Location");
		stage.setScene(scene);
		stage.show();
		back.setOnAction(e -> {

			try {
				start(stage);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		locfx.getTdisdel().setOnAction(e -> {
			ObservableList list2 = FXCollections.observableArrayList(
					((DistrictT) Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList()
							.cboxLoc());
			locfx.getTdel().setItems(list2);
		});
		locfx.getDelete().setOnAction(e -> {
			Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmAlert.setTitle("Confirmation interface");
			confirmAlert.setHeaderText("Are you sure you want to Delete the Location name?");
			confirmAlert.setContentText("This will Delete the Location : " + locfx.getTdel().getValue());
			confirmAlert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					try {
						if (((DistrictT) Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList()
								.find(new LocationT(locfx.getTdel().getValue())) != null) {
							((DistrictT) Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData()).getList()
									.delete(((DistrictT) Dtree.find(new DistrictT(locfx.getTdisdel().getValue()))
											.getData()).getList().find(new LocationT(locfx.getTdel().getValue()))
											.getData());
							ObservableList list3 = FXCollections.observableArrayList(
									((DistrictT) Dtree.find(new DistrictT(locfx.getTdisdel().getValue())).getData())
											.getList().cboxLoc());
							locfx.getTdel().setItems(list3);
							locfx.getLres().setText("Done delete");
						} else {
							ResAlert("Error !", "Error Update location . ");
						}
						locfx.getTdel().setValue(null);
					} catch (Exception ex) {
						ResAlert("Error !", "Error Delete location: " + ex.getMessage());
					}
				}

			});
		});
	}

	private void ResAlert(String st, String discribtion) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(st);
		alert.setContentText(discribtion);
		alert.setHeaderText(null);

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.setPrefSize(350, 110);
		dialogPane.setStyle("-fx-border-color: red; " + "-fx-border-width: 3; " + "-fx-padding: 13; "
				+ "-fx-font-size: 12px; " + "-fx-font-family: 'Arial';");

		alert.showAndWait();
	}

	private void savefile() {
		try (PrintWriter w = new PrintWriter("Data.csv")) {
			HNode[] hash = Htable.getHash();

			for (int i = 0; i < hash.length; i++) {
				if (hash[i].isFull()) {
					Date date = (Date) hash[i].getData();

					Queue q = new Queue();

					q.enQueue(date.getMar().getRoot());

					while (!q.isEmpty()) {

						TNode curr = q.deQueue();
						w.append(curr.getKey().getName() + "," + date.getDate() + "," + curr.getKey().getAge() + ","
								+ curr.getKey().getLocation() + "," + curr.getKey().getDistrict() + ","
								+ curr.getKey().getGender() + "\n");
						if (curr.getRight() != null)
							q.enQueue(curr.getRight());

						if (curr.getLeft() != null)
							q.enQueue(curr.getLeft());
					}
				}
			}

		} catch (Exception e) {
			ResAlert("Error !", "Do not Save to file : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch();

//        System.out.println("nnnn");
//        DoubleList llist= new DoubleList();
//        llist.insert(new District("crami"));
//        llist.insert(new District("mami"));
//        llist.insert(new District("aaaami"));
//        System.out.println(llist.printList()+"hhh");
//        System.out.println(llist.getSize());
//        System.out.println(llist.printList()+"hhh");
	}
}
