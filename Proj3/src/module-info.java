module Proj3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Proj3 to javafx.base, javafx.fxml;

    exports Proj3;
}