package org.example.shapes.twodim.polygon;

import org.example.shapes.ShapeTypes;
import org.example.shapes.twodim.ITwoDimShape;
import org.example.shapes.twodim.TwoDimShapeTypes;

public interface IPolygon  extends ITwoDimShape {
    int getNumSides();
    double getLongestSideLength();
    double getShortestSideLength();
    double getPerimeter();
    double getArea();

    default TwoDimShapeTypes getType() {
        return TwoDimShapeTypes.POLYGON;
    }

    default ShapeTypes getShapeType() {
        return ShapeTypes.POLYTOPE;
    }
}
