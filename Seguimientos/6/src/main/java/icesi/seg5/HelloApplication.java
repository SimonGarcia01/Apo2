package icesi.seg5;

import icesi.seg5.controller.HelloController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("hello-view.fxml");

    }

    public static void openWindow(String fxml){

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 450, 400);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

            Object controller = fxmlLoader.getController();

            stage.setOnCloseRequest(event -> {
                if (controller instanceof HelloController) {
                    ((HelloController) controller).save();
                }
                Platform.exit();
            });

            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}