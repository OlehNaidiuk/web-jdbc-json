package com.naidiuk.webJdbcJson.errors;

public class JDBCConnectionException extends RuntimeException {
    public JDBCConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
