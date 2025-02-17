package org.example.shapes.polytope.twodim.polygon;

public enum PolygonTypes {
    TRIANGLE("Triangle",3),
    RECTANGLE("Rectangle",4),
    SQUARE("Square",4);

    private final String name;
    private final int sides;

    PolygonTypes(String name, int sides) {
        this.name = name;
        this.sides = sides;
    }

    public String getName() {
        return name;
    }

    public int getSides() {
        return sides;
    }

    public String toString() {
        return name;
    }

}
