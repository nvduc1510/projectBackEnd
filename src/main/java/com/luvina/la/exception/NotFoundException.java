/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * NotFoundException.java, July 5, 2023 nvduc
 */
package com.luvina.la.exception;

/**
 * Lớp ngoại lệ (exception) đại diện cho tình huống không tìm thấy thông tin yêu cầu.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructor của lớp `NotFoundException` với thông báo lỗi cụ thể.
     * @param message Thông báo lỗi để mô tả tình huống không tìm thấy thông tin yêu cầu.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
