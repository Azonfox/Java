module mypack {
    requires javafx.controls;
    requires javafx.fxml;

    opens mypack to javafx.fxml;
    exports mypack;
}
