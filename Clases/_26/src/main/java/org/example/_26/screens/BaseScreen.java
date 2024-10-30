package org.example._26.screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public abstract class BaseScreen {

    protected Canvas canvas;
    protected GraphicsContext graphicsContext;

    public BaseScreen(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    public abstract void paint();

    public abstract void onKeyPressed(KeyEvent event);

    public abstract void onKeyReleased(KeyEvent event);

}
