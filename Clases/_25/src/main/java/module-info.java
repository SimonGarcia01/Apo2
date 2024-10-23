module org.example._25 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example._25 to javafx.fxml;
    exports org.example._25;
}