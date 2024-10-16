module org.example.video {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.video to javafx.fxml;
    exports org.example.video;
    exports org.example.video.control;
    exports org.example.video.model;
    opens org.example.video.control to javafx.fxml;
}