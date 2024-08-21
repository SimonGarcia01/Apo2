package model;

public class Triangle implements IFigure {

    public static String NOT_TRIANGLE = "NOT TRIANGLE";
    public static String EQUILATERAL = "EQUILATERAL";
    public static String ISOSCELES = "ISOSCELES";
    public static String SCALENE = "SCALENE";

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String getType() {
        String type = NOT_TRIANGLE;
        if(side1==side2 && side2==side3) {
            type = EQUILATERAL;
        }else if(side1==side2 || side2==side3 || side1==side3) {
            type = ISOSCELES;
        }else if(side1+side2>side3 && side1+side3>side2 && side2+side3>side1){
            type = SCALENE;
        }
        return type;
    }
}