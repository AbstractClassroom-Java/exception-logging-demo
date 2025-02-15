package org.example.shapes.twodim.polygon.triangle;

public enum TriangleSpecification {
    SSS("Side-Side-Side"),
    SAS("Side-Angle-Side"),
    AAS("Angle-Angle-Side"),
    SSA("Side-Side-Angle"),
    ASA("Angle-Side-Angle");

    private final String parameterSpecification;

    TriangleSpecification(String parameterSpecification) {
        this.parameterSpecification = parameterSpecification;
    }

    public String getTriangleSpecification() {
        return parameterSpecification;
    }
}
