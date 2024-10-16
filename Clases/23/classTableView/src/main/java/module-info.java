module org.example.classtableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.classtableview to javafx.fxml;
    opens org.example.classtableview.model to javafx.fxml;
    exports org.example.classtableview;
    exports org.example.classtableview.controller;
    exports org.example.classtableview.model;
    opens org.example.classtableview.controller to javafx.fxml;
}