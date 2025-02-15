package org.example.shapes.twodim.polygon.rectangle;

import org.example.shapes.twodim.polygon.PolygonException;

public class Square extends Rectangle {
    private final double sideLength;

    public Square(double sideLength) throws RectangleException {
        if (sideLength <= 0) {
            String message = RectangleException.RectangleExceptionType.INVALID_SIDE_LENGTH.toString();
            throw new RectangleException(message);
        }
        super(sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}
