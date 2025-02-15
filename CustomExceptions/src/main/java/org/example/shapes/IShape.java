package org.example.shapes;

public interface IShape {
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
