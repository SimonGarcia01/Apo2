module org.example._26 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example._26 to javafx.fxml;
    exports org.example._26;

    opens org.example._26.model to javafx.fxml;
    exports org.example._26.model;

    opens org.example._26.screens to javafx.fxml;
    exports org.example._26.screens;

    opens org.example._26.control to javafx.fxml;
    exports org.example._26.control;


}