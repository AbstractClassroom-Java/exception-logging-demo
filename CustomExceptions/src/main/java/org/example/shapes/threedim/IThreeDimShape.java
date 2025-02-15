package org.example.shapes.threedim;

public interface IThreeDimShape {
    default int getDimension() {
        return 3;
    }

    double getVolume();
    double getSurfaceArea();
}
