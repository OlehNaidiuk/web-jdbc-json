package com.naidiuk.webJdbcJson.errors;

public class JDBCDriverException extends RuntimeException {
     public JDBCDriverException(String message, Throwable cause) {
         super(message, cause);
     }
}
