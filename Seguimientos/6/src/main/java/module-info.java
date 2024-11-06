module icesi.seg5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens icesi.seg5 to javafx.fxml;
    exports icesi.seg5;

    opens icesi.seg5.controller to javafx.fxml;
    exports icesi.seg5.controller;

    opens icesi.seg5.model to com.google.gson, javafx.fxml;
    exports icesi.seg5.model;


}