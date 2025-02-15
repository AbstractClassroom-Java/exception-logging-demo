package org.example.shapes;

public class ShapeExceptions extends Exception {
    private final String fullErrorMessage;
    private final String errorCode;
    private final String customerMessage;

    public ShapeExceptions(ShapeExceptions e) {
        super(e.getFrontEndMessage());
        this.fullErrorMessage = e.fullErrorMessage;
        this.errorCode = e.errorCode;
        this.customerMessage = e.customerMessage;
    }

    public String getFrontEndMessage() {
        return "There was an error processing your request. Please try again later. (Error Code: " + errorCode + ")";
    }

    public String toString() {
        return getFrontEndMessage();
    }
}
