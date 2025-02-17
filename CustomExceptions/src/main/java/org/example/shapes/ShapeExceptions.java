package org.example.shapes;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShapeExceptions extends Exception {

    public static final String loggingUnit = "SHAPES";
    public ShapeExceptions(String fullErrorMessage, String loggingErrorCode) {
        super(generateLogMessage(fullErrorMessage, loggingErrorCode));
    }

    private static String generateLogMessage(String errorMessage, String errorCode) {
        String updatedErrorCode = updateErrorCode(ShapeExceptions.loggingUnit, errorCode);
        String hashedErrorCode = generateSHA256HashSubString(updatedErrorCode);
        sendToLoggingService(updatedErrorCode, hashedErrorCode, errorMessage);
        return "There was an error processing your request. Please try again later. (Error Code: " + hashedErrorCode + ")";
    }


    protected static String updateErrorCode(String currentErrorCode, String appendError) {
        return currentErrorCode + "." + appendError;
    }

    private static String generateSHA256HashSubString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString().substring(0, 10).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "12385774";
        }
    }
    private static void sendToLoggingService(String errorCode, String hashedErrorCode, String errorMessage) {
        try {
            URL url = new URL("https://2qtzp0kvw8.execute-api.us-east-1.amazonaws.com/prod/cse_220/demo/logging/cloudwatch");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Authorization", "Bearer accessToken"); // if needed

            String errorJSON = "{\"logStream\": \"user_actions\", \"errorMessage\": ";
            errorJSON += "\"errorCode: " + errorCode + ", errorMessage: " + errorMessage + ", hashedErrorCode: " + hashedErrorCode + "\"}";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = errorJSON.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new Exception("Error sending error message to logging service. Response code: " + hashedErrorCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException("Error sending error message to logging service." + " Please call support with error code: " + hashedErrorCode);
        }
    }

}
