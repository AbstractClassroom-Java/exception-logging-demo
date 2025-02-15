package org.example.shapes.polytope.twodim.polygon.rectangle;

import org.example.shapes.polytope.twodim.ITwoDimShape;

public interface IRectangle extends ITwoDimShape {
    double getLength();
    double getWidth();

    default double getArea() {
        return getLength() * getWidth();
    }

    default double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    default double getLongestSideLength() {
        return Math.max(getLength(), getWidth());
    }

    default double getShortestSideLength() {
        return Math.min(getLength(), getWidth());
    }

    default int getNumSides() {
        return 4;
    }

}
