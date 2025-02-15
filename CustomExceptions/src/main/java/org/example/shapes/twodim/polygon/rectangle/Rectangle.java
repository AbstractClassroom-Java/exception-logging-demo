package org.example.shapes.twodim.polygon.rectangle;

import org.example.shapes.twodim.polygon.PolygonException;

public class Rectangle {

    private final double width;
    private final double length;

    public Rectangle(double width, double length) throws RectangleException {
        if (width <= 0) {
            String message = RectangleException.RectangleExceptionType.INVALID_WIDTH.toString();
            throw new RectangleException(message);
        }
        if (length <= 0) {
            String message = RectangleException.RectangleExceptionType.INVALID_LENGTH.toString();
            throw new RectangleException(message);
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

    public double getLongestSideLength() {
        return Math.max(width, length);
    }

    public double getShortestSideLength() {
        return Math.min(width, length);
    }

    public int getNumSides() {
        return 4;
    }
}
