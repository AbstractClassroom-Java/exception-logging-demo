package org.example.shapes;

public interface IShape {

    /**
     * Enum to represent the type of shape
     * POLYTOPE: A shape that is a polytope (a shape with flat sides)
     * NONPOLYTOPE: A shape that is not a polytope (a shape with curved sides)
     */
    public static enum ShapeTypes {
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
    ShapeTypes getShapeType();
    int getDimension();

}
