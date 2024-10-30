package org.example._26.screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import org.example._26.control.HelloController;
import org.example._26.model.Avatar;
import org.example._26.model.Position;
import org.example._26.util.IDistance;

public class ScreenB extends BaseScreen{

    private Avatar avatar;

    public ScreenB(Canvas canvas) {
        super(canvas);
        this.avatar = new Avatar(super.canvas);
    }

    @Override
    public void paint() {
        super.graphicsContext.setFill(Color.GRAY);
        super.graphicsContext.fillRect(0,0, super.canvas.getWidth(), super.canvas.getHeight());
        avatar.paint();

        IDistance iDistance = (from, to) -> {
          return Math.sqrt(
               Math.abs(
                       Math.pow(from.getX() - to.getX(), 2) +
                               Math.pow(from.getY() - to.getY(),2)
               )
          );
        };

        double distance = iDistance.distance(avatar.getPosition(),
                new Position(0, 0));
                //With respect to upper left edge but it can be done to lower right edge (max size of canvas)

        if(distance < 40){
            HelloController.SCREEN = 0;
        }
    }

    @Override
    public void onKeyPressed(KeyEvent event) {
        avatar.setOnKeyPressed(event);
    }

    @Override
    public void onKeyReleased(KeyEvent event) {
        avatar.setOnKeyReleased(event);
    }
}
