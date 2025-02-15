package org.example.shapes;

public class ShapeExceptions extends Exception {
    int errorCode;
    public ShapeExceptions(String message) {
        super(message);
        this.errorCode = errorCode + 5000;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return "Error Code: " + errorCode + " - " + getMessage();
    }

    public String getFrontEndMessage() {
        return "There was an error processing your request. Please try again later. (Error Code: " + errorCode + ")";
    }

    public String toString() {
        return getFrontEndMessage();
    }
}
