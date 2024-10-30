package org.example._26.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import org.example._26.screens.BaseScreen;
import org.example._26.screens.ScreenA;
import org.example._26.screens.ScreenB;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<BaseScreen> screens;
    private ScreenA screen;
    private boolean isRunning;

    public static int SCREEN = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.screens = new ArrayList<>(2);
        screens.add(new ScreenA(canvas));
        screens.add(new ScreenB(canvas));
        isRunning = true;

        new Thread(() -> { //Runnable using a lambda
           while(isRunning){
               Platform.runLater( () -> {
                   screens.get(SCREEN).paint();
               });
               try{ //Making a delay for the animation
                   Thread.sleep(100);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
           }
        }).start();

        initActions();
    }

    public void initActions(){
        canvas.setOnKeyPressed(event -> {
            screens.get(SCREEN).onKeyPressed(event);
        });

        canvas.setOnKeyReleased(event -> {
            screens.get(SCREEN).onKeyReleased(event);
        });
    }

    public void setRunning(){
        isRunning = false;
    }
}