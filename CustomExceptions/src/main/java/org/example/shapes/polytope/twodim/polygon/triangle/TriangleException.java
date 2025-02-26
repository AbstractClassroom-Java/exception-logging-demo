package org.example.shapes.polytope.twodim.polygon.triangle;

import org.example.shapes.polytope.twodim.polygon.PolygonException;

public class TriangleException extends PolygonException {

    public static enum TriangleExceptionType {
        INVALID_SIDE_LENGTH("Side length must be greater than 0"),
        INVALID_ANGLE("Angle must be greater than 0 and less than 180"),
        INVALID_TRIANGLE_SSS("Invalid triangle with given side lengths"),
        INVALID_TRIANGLE_SAS("Invalid triangle with given side and angle"),
        INVALID_TRIANGLE_AAS("Invalid triangle with given angles and side"),
        INVALID_TRIANGLE_SSA("Invalid triangle with given side, side, and angle"),
        INVALID_TRIANGLE_ASA("Invalid triangle with given angle, side, and angle");

        private final String message;
        TriangleExceptionType(String message) {
            this.message = message;
        }

    }

    private static final String loggingUnit = "TRIANGLE";
    public TriangleException(TriangleExceptionType type) {
        super(type.toString(), TriangleException.loggingUnit);
    }

}

