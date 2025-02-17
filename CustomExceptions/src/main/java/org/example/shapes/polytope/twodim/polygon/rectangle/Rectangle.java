package org.example.shapes.polytope.twodim.polygon.rectangle;

public class Rectangle implements IRectangle {

    private final double width;
    private final double length;

    public Rectangle(double width, double length) throws RectangleException {
        if (width == length && width <= 0) {
            throw new RectangleException(RectangleException.RectangleExceptionType.INVALID_SIDE_LENGTH);
        }
        if (width <= 0) {
            throw new RectangleException(RectangleException.RectangleExceptionType.INVALID_WIDTH);
        }
        if (length <= 0) {
            throw new RectangleException(RectangleException.RectangleExceptionType.INVALID_LENGTH);
        }
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public String toString() {
        String result = "Rectangle with width " + width + " and length " + length + "\n";
        result += "Area: " + getArea() + "\n";
        result += "Perimeter: " + getPerimeter() + "\n";
        return result;
    }

}
