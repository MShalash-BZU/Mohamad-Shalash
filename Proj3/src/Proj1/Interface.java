package Proj1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Interface {
    private GridPane gpane;
    private Label ldis,lloc,lfile,lmar;
    private Button btndis,btnloc,btnfile, btnmar;
    private MenuBar menu;
    private Menu m1;
    private MenuItem loadFile,savefiel,newScreen;
    private Font font;
    public Interface(){
        menu=new MenuBar();
        m1=new Menu("File");
        loadFile=new MenuItem("Load File");
        savefiel=new MenuItem("Save File");
        newScreen=new MenuItem("New Screen");
        font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20);
        gpane=new GridPane();
        ldis=new Label("District Screen: ");
        lloc=new Label("Location Screen: ");
        lfile=new Label("Load file: ");
        lmar=new Label("Martyr Screen: ");
        lfile.setFont(font);
        lloc.setFont(font);
        ldis.setFont(font);
        lmar.setFont(font);

        btndis=new Button("District screen");
        btnfile=new Button("Load File");
        btnloc=new Button("Location screen");
        btnmar=new Button("Martyr screen");

        double buttonWidth = 180;
        btndis.setMinWidth(buttonWidth);
        btnfile.setMinWidth(buttonWidth);
        btnloc.setMinWidth(buttonWidth);
        btnmar.setMinWidth(buttonWidth);



        double buttonHeight = 35;
        btndis.setMinHeight(buttonHeight);
        btnfile.setMinHeight(buttonHeight);
        btnloc.setMinHeight(buttonHeight);
        btnmar.setMinHeight(buttonHeight);

        btnfile.setFont(font);
        btndis.setFont(font);
        btnloc.setFont(font);
        btnmar.setFont(font);

//        gpane.add(lfile,0,0);
        gpane.add(ldis,0,1);
        gpane.add(lloc,0,2);
//        gpane.add(btnfile,1,0);
        gpane.add(btndis,1,1);
        gpane.add(btnloc,1,2);
        gpane.add(lmar,0,3);
        gpane.add(btnmar,1,3);
        gpane.setHgap(20);
        gpane.setVgap(30);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(25));

        m1.getItems().addAll(loadFile,savefiel,newScreen);
        menu.getMenus().add( m1);



    }

    public MenuBar getMenu() {
        return menu;
    }

    public Menu getM1() {
        return m1;
    }

    public MenuItem getLoadFile() {
        return loadFile;
    }

    public MenuItem getSavefiel() {
        return savefiel;
    }

    public MenuItem getNewScreen() {
        return newScreen;
    }

    public Button getBtnmar() {
        return btnmar;
    }

    public GridPane getGpane() {
        return gpane;
    }

    public Button getBtndis() {
        return btndis;
    }

    public Button getBtnloc() {
        return btnloc;
    }

    public Button getBtnfile() {
        return btnfile;
    }
}
