/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * YourCustomException.java, July 5, 2023 nvduc
 */
package com.luvina.la.exception;

/**
 * Lớp ngoại lệ (exception) tùy chỉnh cho các tình huống đặc biệt mà bạn muốn xử lý trong ứng dụng.
 */
public class YourCustomException extends RuntimeException {

    /**
     * Constructor của lớp `YourCustomException` với thông báo lỗi cụ thể.
     * @param message Thông báo lỗi để mô tả tình huống ngoại lệ tùy chỉnh.
     */
    public YourCustomException(String message) {
        super(message);
    }

    /**
     * Constructor của lớp `YourCustomException` với thông báo lỗi và nguyên nhân cụ thể.
     * @param message Thông báo lỗi để mô tả tình huống ngoại lệ tùy chỉnh.
     * @param cause Nguyên nhân gốc của ngoại lệ.
     */
    public YourCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
