package org.example._25;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    private Rectangle rectangle1;
    private Rectangle rectangle2;

    private double posX;
    private double posY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = canvas.getGraphicsContext2D();

        rectangle1 = new Rectangle(0, 50, 50, 50);
        rectangle2 = new Rectangle(100, 50, 50, 50);

        new Thread(
                //Runnable --> lambda
                () -> {
                    while(true){
                        Platform.runLater(() -> {
                            //Runnable

                            //Clear canvas
                            graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

                            //Paint over it
                            graphicsContext.setFill(Color.BLUE);
                            graphicsContext.fillRect(rectangle1.getX(), rectangle1.getY(), rectangle1.getWidth(), rectangle1.getHeight());

                            graphicsContext.setFill(Color.RED);
                            graphicsContext.fillRect(rectangle2.getX(), rectangle2.getY(), rectangle2.getWidth(), rectangle2.getHeight());
                        });

                        IDistance cal = (x1, x2, y1, y2) -> {
                            return Math.sqrt(
                                    Math.abs(Math.pow(x1, 2) + Math.pow(y1,2) - (Math.pow(x2, 2)) + Math.pow(y2, 2)));
                        };

                        double distance = cal.calculateDistance(rectangle1.getX(), rectangle2.getX(), rectangle1.getY(), rectangle2.getY());
                        System.out.println("Distance: " + distance);

                        if(distance < 20){
                            posY = rectangle1.getY() + 5;
                            rectangle1.setY(posY);
                        } else {
                            posX = rectangle1.getX() + 1;
                            rectangle1.setX(posX);
                        }

                        try{
                            Thread.sleep(100);
                        } catch (InterruptedException e){
                            throw new RuntimeException();
                        }
                    }
                }
        ).start();
    }
}