package org.example.shapes.polytope.twodim;

public enum TwoDimShapeTypes {
    POLYGON("Polygon"),
    NONPOLYGON("NonPolygon");

    private final String name;

    TwoDimShapeTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
