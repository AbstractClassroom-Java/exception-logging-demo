package org.example.shapes.polytope.twodim.polygon.rectangle;

public class Square extends Rectangle {
    private final double sideLength;

    public Square(double sideLength) throws RectangleException {
        if (sideLength <= 0) {
            throw new RectangleException("hey");
        }
        super(sideLength, sideLength);
        if (sideLength <= 0) {
            String message = RectangleException.RectangleExceptionType.INVALID_SIDE_LENGTH.toString();
            throw new RectangleException(message);
        }
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}
