package controller;

import exceptions.NegativeSiteException;
import model.*;


public class FigureController {

    public IFigure createFigure(int[] sides){
        IFigure figure = null;

        if(validateInput(sides)){
            throw new NegativeSiteException("The given sides are not valid");
        }
        else {
            if(sides.length == 3){
                figure = new Triangle(sides[0], sides[1], sides[2]);
            }
            else if(sides.length == 4){
                figure = new Quadrilateral(sides[0], sides[1], sides[2], sides[3]);
            }
            else if(sides.length == 5){
                figure = new Pentagon(sides[0], sides[1], sides[2], sides[3], sides[4]);
            }
            else if(sides.length == 6){
                figure = new Hexagon(sides[0], sides[1], sides[2], sides[3], sides[5], sides[5]);
            }
        }
        return figure;
    }

    public String getType(IFigure figure){
        return figure.getType();
    }

    public boolean validateInput(int[] sides){
        boolean isNegative = false;
        for (int i = 0; i < sides.length && !isNegative; i++) {
            if(sides[i] < 0){
                isNegative = true;
            }
        }
        return isNegative;
    }

}
