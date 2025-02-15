package org.example.shapes.twodim;

import org.example.shapes.IShape;

public interface ITwoDimShape extends IShape {
    default int getDimension() {
        return 2;
    }

    double getArea();
    double getPerimeter();
}
