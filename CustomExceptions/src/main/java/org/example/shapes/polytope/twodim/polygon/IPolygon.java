package org.example.shapes.polytope.twodim.polygon;

import org.example.shapes.polytope.twodim.ITwoDimShape;
import org.example.shapes.polytope.twodim.TwoDimShapeTypes;

public interface IPolygon extends ITwoDimShape {
    int getNumSides();
    double getLongestSideLength();
    double getShortestSideLength();

    default ShapeTypes getShapeType() {
        return ShapeTypes.POLYTOPE;
    }
}
