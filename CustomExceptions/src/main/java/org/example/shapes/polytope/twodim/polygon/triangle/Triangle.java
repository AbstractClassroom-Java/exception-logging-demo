package org.example.shapes.polytope.twodim.polygon.triangle;

import org.example.shapes.polytope.twodim.polygon.IPolygon;


public class Triangle implements IPolygon  {
    private double side1;
    private double side2;
    private double side3;
    private double angle1;
    private double angle2;
    private double angle3;

    private static final double TOLERANCE = 0.0001;

    public Triangle(double a, double b, double c, TriangleSpecification spec) throws TriangleException {
        switch(spec) {
            case SSS:
                verifySSSTriangle(a, b, c);
                break;
            case SAS:
                verifySASTriangle(a, b, c);
                break;
            case AAS:
                verifyAASTriangle(a, b, c);
                break;
            case SSA:
                verifySSATriangle(a, b, c);
                break;
            case ASA:
                verifyASATriangle(a, b, c);
                break;
            default:
                throw new IllegalArgumentException("Invalid Triangle Specification");
        }
    }

    private void verifyASATriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || c <= 0) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_ANGLE.toString());
        }
        if (b <= 0 || b >= 180) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_SIDE_LENGTH.toString());
        }
        this.angle1 = a;
        this.angle2 = c;
        this.angle3 = 180 - a - c;
        this.side1 = b * Math.sin(Math.toRadians(a)) / Math.sin(Math.toRadians(angle3));
        this.side2 = b * Math.sin(Math.toRadians(c)) / Math.sin(Math.toRadians(angle3));
        this.side3 = b;
        if (!isTriangle()) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_TRIANGLE_ASA.toString());
        }
    }


    private void verifySSATriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 ) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_SIDE_LENGTH.toString());
        }
        if (c <= 0 || c >= 180) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_ANGLE.toString());
        }
        this.side1 = a;
        this.side2 = b;
        this.angle3 = c;
        this.angle1 = Math.asin(a * Math.sin(Math.toRadians(c)) / b);
        this.angle2 = 180 - c - angle1;
        this.side3 = b * Math.sin(Math.toRadians(c)) / Math.sin(Math.toRadians(angle1));
        if (!isTriangle()) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_TRIANGLE_SSA.toString());
        }
    }


    private void verifyAASTriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || a >= 180 || b >= 180) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_ANGLE.toString());
        }
        if (c <= 0) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_SIDE_LENGTH.toString());
        }

        this.angle1 = a;
        this.angle2 = b;
        this.angle3 = 180 - a - b;
        this.side1 = c * Math.sin(Math.toRadians(a)) / Math.sin(Math.toRadians(angle3));
        this.side2 = c * Math.sin(Math.toRadians(b)) / Math.sin(Math.toRadians(angle3));
        this.side3 = c;
        if (!isTriangle()) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_TRIANGLE_AAS.toString());
        }
    }

    private void verifySASTriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || c <= 0) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_SIDE_LENGTH.toString());
        }
        if (b <= 0 || b >= 180) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_ANGLE.toString());
        }
        this.side1 = a;
        this.side2 = c;
        this.angle3 = b;
        // angles are in degrees
        this.angle1 = Math.toDegrees(Math.asin(a * Math.sin(Math.toRadians(b)) / c));
        this.angle2 = 180 - b - angle1;
        this.side3 = c * Math.sin(Math.toRadians(angle1)) / Math.sin(Math.toRadians(b));
        if (!isTriangle()) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_TRIANGLE_SAS.toString());
        }
    }

    private void verifySSSTriangle(double a, double b, double c) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_SIDE_LENGTH.toString());
        }

        this.side1 = a;
        this.side2 = b;
        this.side3 = c;
        this.angle1 = Math.acos((side2 * side2 + side3 * side3 - side1 * side1) / (2 * side2 * side3));
        this.angle2 = Math.acos((side1 * side1 + side3 * side3 - side2 * side2) / (2 * side1 * side3));
        this.angle3 = Math.acos((side1 * side1 + side2 * side2 - side3 * side3) / (2 * side1 * side2));
        if (!isTriangle()) {
            throw new TriangleException(TriangleException.TriangleExceptionType.INVALID_TRIANGLE_SSS.toString());
        }
    }

    private boolean isTriangle() {
        if (side1<=TOLERANCE || side2<=TOLERANCE || side3<=TOLERANCE) {
            return false;
        }
        if (side1 + side2 - side3 < TOLERANCE || side1 + side3 - side2 < TOLERANCE || side2 + side3 - side1 < TOLERANCE) {
            return false;
        }
        if (angle1<=TOLERANCE || angle2<=TOLERANCE || angle3<=TOLERANCE) {
            return false;
        }
        if (angle1 + angle2 + angle3 - 180 > TOLERANCE) {
            return false;
        }
        //check law of sines
        if (Math.abs(side1 / Math.sin(Math.toRadians(angle1)) - side2 / Math.sin(Math.toRadians(angle2))) > TOLERANCE) {
            return false;
        }
        if (Math.abs(side1 / Math.sin(Math.toRadians(angle1)) - side3 / Math.sin(Math.toRadians(angle3))) > TOLERANCE) {
            return false;
        }
        if (Math.abs(side2 / Math.sin(Math.toRadians(angle2)) - side3 / Math.sin(Math.toRadians(angle3))) > TOLERANCE) {
            return false;
        }
        return true;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getAngle1() {
        return angle1;
    }

    public double getAngle2() {
        return angle2;
    }

    public double getAngle3() {
        return angle3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public int getNumSides() {
        return 3;
    }

    public boolean isEquilateral() {
        return Math.abs(side1 - side2) < TOLERANCE && Math.abs(side2 - side3) < TOLERANCE;
    }

    public boolean isIsosceles() {
        return Math.abs(side1 - side2) < TOLERANCE || Math.abs(side2 - side3) < TOLERANCE || Math.abs(side1 - side3) < TOLERANCE;
    }

    public boolean isScalene() {
        return !isIsosceles();
    }

    public boolean isRight() {
        return Math.abs(angle1 - 90) < TOLERANCE || Math.abs(angle2 - 90) < TOLERANCE || Math.abs(angle3 - 90) < TOLERANCE;
    }

    public boolean isObtuse() {
        return angle1 > 90 || angle2 > 90 || angle3 > 90;
    }

    public boolean isAcute() {
        return angle1 < 90 && angle2 < 90 && angle3 < 90;
    }

    public boolean isEquiangular() {
        return Math.abs(angle1 - 60) < TOLERANCE && Math.abs(angle2 - 60) < TOLERANCE && Math.abs(angle3 - 60) < TOLERANCE;
    }

    public double getLongestSideLength() {
        return Math.max(side1, Math.max(side2, side3));
    }

    public double getShortestSideLength() {
        return Math.min(side1, Math.min(side2, side3));
    }

}
