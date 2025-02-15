package org.example.shapes.twodim.nonpolygon;

import org.example.shapes.twodim.ITwoDimShape;
import org.example.shapes.twodim.TwoDimShapeTypes;

public interface INonPolygon extends ITwoDimShape {
    double getPerimeter();
    double getArea();

    default TwoDimShapeTypes getShapeType() {
        return TwoDimShapeTypes.NONPOLYGON;
    }
}
