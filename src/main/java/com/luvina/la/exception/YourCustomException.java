/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * YourCustomException.java, July 5, 2023 nvduc
 */
package com.luvina.la.exception;

public class YourCustomException  extends RuntimeException{
    public YourCustomException (String message) {
        super(message);
    }
    public YourCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
