package org.example._26.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Avatar {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Position position;

    //State helps to define if the hero is idle (0) or running (1)
    private int state;

    //Auxiliary variable to define in what frame of the animation the hero is in
    private int frame;

    //Variables to have access to the list of sprites
    private ArrayList<Image> idles;
    private ArrayList<Image> runs;

    //Variables for actions
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;

    public Avatar(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.position = new Position(100, 100);
        this.idles = new ArrayList<>();
        this.runs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Image idle = new Image(getClass().getResourceAsStream("/animation/hero/idle/adventurer-idle-2-0" + i + ".png"));
            idles.add(idle);
        }

        for (int i = 0; i < 5; i++) {
            Image run = new Image(getClass().getResourceAsStream("/animation/hero/run/adventurer-run-0" + i + ".png"));
            runs.add(run);
        }
    }

    public void paint(){
        onMove();
        if(state == 0){
            graphicsContext.drawImage(idles.get(frame%3), position.getX(), position.getY());
            frame ++;
        } else if(state == 1){
            graphicsContext.drawImage(runs.get(frame%5), position.getX(), position.getY());
            frame ++;
        }
    }

    public void onMove(){
        if(up){
            position.setY(position.getY() - 10);
        }

        if(down){
            position.setY(position.getY() + 10);
        }

        if(right){
            position.setX(position.getX() + 10);
        }

        if(left){
            position.setX(position.getX() - 10);
        }
    }

    public void setOnKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case UP -> {state = 1; up = true;}
            case DOWN -> {state = 1; down = true;}
            case RIGHT -> {state = 1;right = true;}
            case LEFT -> {state = 1;left = true;}
        }
    }

    public void setOnKeyReleased(KeyEvent event){
        switch (event.getCode()){
            case UP -> {state = 0; up =false;}
            case DOWN -> {state = 0; down =false;}
            case RIGHT -> {state = 0; right =false;}
            case LEFT -> {state = 0; left = false;}
        }
    }

    public Position getPosition() {
        return position;
    }
}
