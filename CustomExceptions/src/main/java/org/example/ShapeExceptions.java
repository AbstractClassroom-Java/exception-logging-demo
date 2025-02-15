package org.example;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShapeExceptions extends Exception {

    private String errorCodeString;

    public ShapeExceptions(String errorCodeString) {
        super(formatErrorCode(errorCodeString));
        this.errorCodeString = appendErrorCode(errorCodeString);
    }

    public String getErrorCode() {
        return errorCodeString;
    }

    public String getFrontEndMessage() {
        return "There was an error processing your request. Please try again later. (Error Code: " + errorCodeString + ")";
    }

    private static String appendErrorCode(String errorCode) {
        return "shapes." + errorCode;
    }

    private static String formatErrorCode(String errorCode) {
        String msg = "There was an error processing your request. Please try again later.";
        msg += " (Error Code: " + appendErrorCode(errorCode) + ")";
        return sha256(msg).substring(0, 10).toUpperCase();
    }

    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
