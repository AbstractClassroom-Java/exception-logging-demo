package org.example.shapes;

public enum ShapeTypes {
    POLYTOPE("Polytope"),
    NONPOLYTOPE("Non-Polytope");

    private final String shapeType;

    ShapeTypes(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }
}
