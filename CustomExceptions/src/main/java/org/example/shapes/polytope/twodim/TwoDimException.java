package org.example.shapes.polytope.twodim;

import org.example.shapes.ShapeExceptions;

public class TwoDimException extends ShapeExceptions {
    private static final String loggingUnit = "TWODIM";
    public TwoDimException(String fullMessage, String loggingUnit) {
        super(
                "Invalid Two Dimensional Shape. " + fullMessage,
                updateErrorCode(TwoDimException.loggingUnit, loggingUnit)
        );
    }
}
