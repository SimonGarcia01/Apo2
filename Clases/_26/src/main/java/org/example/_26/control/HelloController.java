package org.example._26.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import org.example._26.screens.ScreenA;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ScreenA screen;
    private boolean isRunning;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initActions();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screen = new ScreenA(canvas);
        isRunning = true;

        new Thread(() -> { //Runnable using a lambda
           while(isRunning){
               Platform.runLater( () -> {
                   screen.paint();
               });
               try{ //Making a delay for the animation
                   Thread.sleep(100);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
           }
        }).start();
    }

    public void initActions(){
        canvas.setOnKeyPressed(event -> {
            screen.onKeyPressed(event);
        });

        canvas.setOnKeyReleased(event -> {
            screen.onKeyReleased(event);
        });
    }

    public void setRunning(){
        isRunning = false;
    }
}