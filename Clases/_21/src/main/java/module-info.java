module org.example._21 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example._21 to javafx.fxml;
    exports org.example._21;
    exports org.example._21.control;
    opens org.example._21.control to javafx.fxml;
}