package org.example;

import org.example.shapes.IShape;
import org.example.shapes.ShapeTypes;
import org.example.shapes.polytope.twodim.polygon.PolygonTypes;
import org.example.shapes.polytope.twodim.polygon.rectangle.Rectangle;
import org.example.shapes.polytope.twodim.polygon.rectangle.RectangleException;
import org.example.shapes.polytope.twodim.polygon.rectangle.Square;
import org.example.shapes.polytope.twodim.polygon.triangle.Triangle;
import org.example.shapes.polytope.twodim.polygon.triangle.TriangleException;
import org.example.shapes.polytope.twodim.polygon.triangle.TriangleSpecification;

import java.util.Scanner;
public class Main {

    private static void createSSSTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Side of the Triangle: ");
        double side1 = scanner.nextDouble();
        System.out.println("Enter the Second Side of the Triangle: ");
        double side2 = scanner.nextDouble();
        System.out.println("Enter the Third Side of the Triangle: ");
        double side3 = scanner.nextDouble();
        try {
            Triangle triangle = new Triangle(side1, side2, side3, TriangleSpecification.SSS);
            System.out.println(triangle);
        } catch (TriangleException e) {
            System.out.println("Error Creating Triangle: " + e.getMessage());
        }
    }

    private static void createSASTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Side of the Triangle: ");
        double side1 = scanner.nextDouble();
        System.out.println("Enter the Second Side of the Triangle: ");
        double side2 = scanner.nextDouble();
        System.out.println("Enter the Angle of the Triangle: ");
        double angle = scanner.nextDouble();
        try {
            Triangle triangle = new Triangle(side1, angle,side2, TriangleSpecification.SAS);
            System.out.println(triangle);
        } catch (TriangleException e) {
            System.out.println("Error Creating Triangle: " + e.getMessage());
        }
    }

    private static void createAASTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Angle of the Triangle: ");
        double angle1 = scanner.nextDouble();
        System.out.println("Enter the Second Angle of the Triangle: ");
        double angle2 = scanner.nextDouble();
        System.out.println("Enter the Side of the Triangle: ");
        double side = scanner.nextDouble();
        try {
            Triangle triangle = new Triangle(angle1, angle2, side, TriangleSpecification.AAS);
            System.out.println(triangle);
        } catch (TriangleException e) {
            System.out.println("Error Creating Triangle: " + e.getMessage());
        }
    }

    private static void createSSATriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Side of the Triangle: ");
        double side1 = scanner.nextDouble();
        System.out.println("Enter the Second Side of the Triangle: ");
        double side2 = scanner.nextDouble();
        System.out.println("Enter the First Angle of the Triangle: ");
        double angle = scanner.nextDouble();
        try {
            Triangle triangle = new Triangle(side1, side2, angle, TriangleSpecification.SSA);
            System.out.println(triangle);
        } catch (TriangleException e) {
            System.out.println("Error Creating Triangle: " + e.getMessage());
        }
    }

    private static void createASATriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Angle of the Triangle: ");
        double angle1 = scanner.nextDouble();
        System.out.println("Enter the Side of the Triangle: ");
        double side = scanner.nextDouble();
        System.out.println("Enter the Second Angle of the Triangle: ");
        double angle2 = scanner.nextDouble();
        try {
            Triangle triangle = new Triangle(angle1, side, angle2, TriangleSpecification.ASA);
            System.out.println(triangle);
        } catch (TriangleException e) {
            System.out.println("Error Creating Triangle: " + e.getMessage());
        }
    }

    private static void createTriangle() {
        System.out.println("Select How You Want To Define The Triangle: ");
        for (TriangleSpecification specification : TriangleSpecification.values()) {
            System.out.println(specification.toString() + " -> " + specification.ordinal());
        }
        System.out.println("Enter the Triangle Specification: ");
        Scanner scanner = new Scanner(System.in);
        int triangleSpecification = scanner.nextInt();
        while (triangleSpecification < 0 || triangleSpecification >= TriangleSpecification.values().length) {
            System.out.println("Invalid Triangle Specification. Please Enter a Valid Triangle Specification: ");
            triangleSpecification = scanner.nextInt();
        }
        switch (TriangleSpecification.values()[triangleSpecification]) {
            case SSS:
                System.out.println("SSS Triangle Selected");
                createSSSTriangle();
                break;
            case SAS:
                System.out.println("SAS Triangle Selected");
                createSASTriangle();
                break;
            case AAS:
                System.out.println("AAS Triangle Selected");
                createAASTriangle();
                break;
            case SSA:
                System.out.println("SSA Triangle Selected");
                createSSATriangle();
                break;
            case ASA:
                System.out.println("ASA Triangle Selected");
                createASATriangle();
                break;
        }
    }

    private static void createSquare() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Side of the Square: ");
        double side = scanner.nextDouble();
        try {
            Square square = new Square(side);
            System.out.println(square);
        } catch (RectangleException e) {
            System.out.println("Error Creating Square: " + e.getMessage());
        }
    }

    private static void createRectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Width of the Rectangle: ");
        double width = scanner.nextDouble();
        System.out.println("Enter the Length of the Rectangle: ");
        double length = scanner.nextDouble();
        try {
            Rectangle rectangle = new Rectangle(width, length);
            System.out.println(rectangle);
        } catch (RectangleException e) {
            System.out.println("Error Creating Rectangle: " + e.getMessage());
        }
    }

    private static void createPolygon() {
        System.out.println("Select The Type of Polygon You Want to Create: ");
        for (PolygonTypes type : PolygonTypes.values()) {
            System.out.println(type.toString() + " -> " + type.ordinal());
        }
        System.out.println("Enter the Polygon Type: ");
        Scanner scanner = new Scanner(System.in);
        int polygonType = scanner.nextInt();
        while (polygonType < 0 || polygonType >= PolygonTypes.values().length) {
            System.out.println("Invalid Polygon Type. Please Enter a Valid Polygon Type: ");
            polygonType = scanner.nextInt();
        }
        switch (PolygonTypes.values()[polygonType]) {
            case TRIANGLE:
                System.out.println("Triangle Selected");
                createTriangle();
                break;
            case RECTANGLE:
                System.out.println("Rectangle Selected");
                createRectangle();
                break;
            case SQUARE:
                System.out.println("Square Selected");
                createSquare();
                break;
        }
    }

    public static void main(String[] args)  {
        System.out.println("Select The Type of Shape You Want to Create: ");
        for (IShape.ShapeTypes type :  IShape.ShapeTypes.values()) {
            System.out.println(type.toString() + " -> " + type.ordinal());
        }
        System.out.println("Enter the Shape Type: ");
        boolean validShapeType = false;
        Scanner scanner = new Scanner(System.in);
        int shapeType = scanner.nextInt();
        while (!validShapeType) {
            if (shapeType < 0 || shapeType >= IShape.ShapeTypes.values().length) {
                System.out.println("Invalid Shape Type. Please Enter a Valid Shape Type: ");
                shapeType = scanner.nextInt();
                continue;
            }
            if (shapeType >0) {
                System.out.println("Shape Type Not Supported Yet. Please Enter a Valid Shape Type: ");
                shapeType = scanner.nextInt();
                continue;
            }
            validShapeType = true;
        }

        boolean validDimension = false;
        while (!validDimension) {
            System.out.println("Enter the Dimension of the Shape: ");
            int dimension = scanner.nextInt();
            if (dimension < 2) {
                System.out.println("Invalid Dimension. Dimension must be greater than 1. Please Enter a Valid Dimension: ");
                continue;
            }
            if (dimension > 2) {
                System.out.println("Dimension Not Supported Yet. Please Enter a Valid Dimension: ");
                continue;
            }
            validDimension = true;
        }

        IShape.ShapeTypes selectedShapeType = IShape.ShapeTypes.values()[shapeType];
        switch (selectedShapeType) {
            case POLYTOPE:
                System.out.println("Polytope Selected");
                createPolygon();
                break;
            case NONPOLYTOPE:
                System.out.println("Non-Polytope Shapes Not Supported Yet");
                break;
        }

    }
}