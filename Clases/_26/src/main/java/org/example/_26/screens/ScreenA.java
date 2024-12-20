package org.example._26.screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import org.example._26.control.HelloController;
import org.example._26.model.Avatar;
import org.example._26.model.Box;
import org.example._26.model.Position;
import org.example._26.util.IDistance;

public class ScreenA extends BaseScreen{
    private Avatar avatar;
    private Box box1;

    public ScreenA(Canvas canvas){
        super(canvas);
        this.avatar = new Avatar(super.canvas);
        this.box1 = new Box(super.canvas);
    }

    @Override
    public void paint(){
        super.graphicsContext.setFill(Color.BLACK);
        super.graphicsContext.fillRect(0, 0, super.canvas.getWidth(), super.canvas.getHeight());
        avatar.paint();
        box1.paint();

        IDistance iDistance = (from, to) -> {
            return Math.sqrt(
                    Math.abs(
                            Math.pow(from.getX() - to.getX(), 2) +
                                    Math.pow(from.getY() - to.getY(),2)
                    )
            );
        };

        double distance = iDistance.distance(avatar.getPosition(), box1.getPosition());

        if(distance < 200){

            //Calculate difference with the position of both entities
            double posX = avatar.getPosition().getX() - box1.getPosition().getX();
            double posY = avatar.getPosition().getY() - box1.getPosition().getY();

            //Define difference vector
            Position diff = new Position(posX, posY);

            //Normalize to change speed to 1
            diff.normalize();

            diff.speed(4);

            box1.getPosition().setX(box1.getPosition().getX() + diff.getX());
            box1.getPosition().setY(box1.getPosition().getY() + diff.getY());
        }

        if(avatar.getPosition().getX() < 0){
            avatar.getPosition().setX(0);
        }


    }

    @Override
    public void onKeyPressed(KeyEvent event){
        avatar.setOnKeyPressed(event);
        if(event.getCode() == KeyCode.SPACE){
            HelloController.SCREEN = 1;
        }
    }

    @Override
    public void onKeyReleased(KeyEvent event){
        avatar.setOnKeyReleased(event);
    }
}
