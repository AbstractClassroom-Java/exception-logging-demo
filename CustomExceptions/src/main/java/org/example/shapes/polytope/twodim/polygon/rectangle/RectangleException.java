package org.example.shapes.polytope.twodim.polygon.rectangle;

import org.example.shapes.polytope.twodim.polygon.PolygonException;

public class RectangleException extends PolygonException {

    public static enum RectangleExceptionType {
        INVALID_LENGTH("Length must be greater than 0"),
        INVALID_WIDTH("Width must be greater than 0"),
        INVALID_SIDE_LENGTH("Side length must be greater than 0");

        private final String message;

        RectangleExceptionType(String message) {
            this.message = message;
        }

        public String toString() {
            return message;
        }
    }

    public RectangleException(String message) {
        super(message);
    }
}
