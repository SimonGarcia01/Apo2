package controller;

import model.IFigure;
import model.Pentagon;
import model.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigureControllerTest {
    //attributes
    public FigureController controller;

    //Setups
    private void setUp1(){
        this.controller = new FigureController();
    }

    private IFigure setUp2(){
        this.controller = new FigureController();

        int[] sides = {6,6,6};

        return controller.createFigure(sides);
    }

    private IFigure setUp3(){
        this.controller = new FigureController();

        int[] sides = {4,4,4,4,4};

        return controller.createFigure(sides);
    }

    //Tests
    @Test
    public void testGetTypeNotTriangle(){
        //Init
        setUp1();

        //Act
        int[] sides = {1,4,2};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("NOT TRIANGLE", type);

    }

    @Test
    public void testGetTypeEquilateralTriangle(){
        //Init
        setUp1();

        //Act
        int[] sides = {6,6,6};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("EQUILATERAL", type);

    }

    @Test
    public void testGetTypeScaleneTriangle(){
        //Init
        setUp1();

        //Act
        int[] sides = {8,7,9};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("SCALENE", type);

    }

    @Test
    public void testGetTypeIsoscelesTriangle(){
        //Init
        setUp1();

        //Act
        int[] sides = {6,7,7};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("ISOSCELES", type);

    }

    @Test
    public void testGetTypeRegularPentagon(){
        //Init
        setUp1();

        //Act
        int[] sides = {4,4,4,4,4};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("REGULAR PENTAGON", type);

    }

    @Test
    public void testGetTypeNotRegularPentagon(){
        //Init
        setUp1();

        //Act
        int[] sides = {5,4,5,4,5};
        String type = controller.getType(controller.createFigure(sides));

        //Assert
        assertEquals("NOT REGULAR PENTAGON", type);

    }

    @Test
    public void testCreateFigureTriangle(){
        //Init
        IFigure triangle = setUp2();

        //Act
            //None

        //Assert
        assertTrue(triangle instanceof Triangle);

    }

    @Test
    public void testCreateFigurePentagon(){
        //Init
        IFigure pentagon = setUp3();

        //Act
        //None

        //Assert
        assertTrue(pentagon instanceof Pentagon);

    }


}
