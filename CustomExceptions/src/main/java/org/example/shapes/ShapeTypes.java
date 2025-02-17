package org.example.shapes;
/**
 * Enum representing different types of shapes: Polytope and Non-Polytope.
 * This enum provides a way to categorize shapes as either polytope or non-polytope.
 *
 * Each constant in this enum has a string representation of the shape type.
 *
 * Example usage:
 * <pre>
 *     ShapeTypes shape = ShapeTypes.POLYTOPE;
 *     System.out.println("Shape type: " + shape.getShapeType());
 * </pre>
 */
public enum ShapeTypes {

    /**
     * Represents a Polytope shape.
     * A polytope is a geometric object with flat sides, such as a polygon or polyhedron.
     */
    POLYTOPE("Polytope"),

    /**
     * Represents a Non-Polytope shape.
     * A non-polytope is a shape that is not a polytope, such as curved shapes like spheres.
     */
    NONPOLYTOPE("Non-Polytope");

    /**
     * The string representation of the shape type.
     * This field stores the name or category of the shape type (e.g., "Polytope").
     */
    private final String shapeType;

    /**
     * Constructor for the ShapeTypes enum.
     * Initializes the shape type with the provided string representation.
     *
     * @param shapeType The string representation of the shape type (e.g., "Polytope").
     */
    ShapeTypes(String shapeType) {
        this.shapeType = shapeType;
    }

    /**
     * Retrieves the string representation of the shape type.
     *
     * @return The shape type as a string (e.g., "Polytope" or "Non-Polytope").
     */
    public String getShapeType() {
        return shapeType;
    }
}
