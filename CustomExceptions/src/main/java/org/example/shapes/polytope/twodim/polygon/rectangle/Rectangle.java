package org.example.shapes.polytope.twodim.polygon.rectangle;



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

}
