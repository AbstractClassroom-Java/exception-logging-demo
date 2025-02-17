package org.example.shapes.polytope.twodim.polygon.rectangle;

public class Square extends Rectangle {
    private final double sideLength;

    public Square(double sideLength) throws RectangleException {
        super(sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public String toString() {
        String result = "Square with side length " + sideLength +"\n";
        result += "Area: " + getArea() + "\n";
        result += "Perimeter: " + getPerimeter() + "\n";
        return result;

    }
}
