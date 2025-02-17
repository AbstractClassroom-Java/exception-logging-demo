package org.example.shapes.polytope.twodim.polygon;

import org.example.shapes.ShapeExceptions;
import org.example.shapes.polytope.twodim.TwoDimException;

public class PolygonException extends TwoDimException {

    private static final String loggingUnit = "POLYGON";
    public PolygonException(String fullMessage, String loggingUnit) {
        super(
                "Invalid Polygon. " + fullMessage,
                updateErrorCode(PolygonException.loggingUnit, loggingUnit)
        );
    }
}
