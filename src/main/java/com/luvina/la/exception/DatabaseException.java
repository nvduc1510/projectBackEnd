/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * DatabaseException.java, July 5, 2023 nvduc
 */
package com.luvina.la.exception;
/**
 * Lớp ngoại lệ (exception) đại diện cho các lỗi liên quan đến cơ sở dữ liệu.
 */
public class DatabaseException extends RuntimeException {

    /**
     * Constructor của lớp `DatabaseException` với thông báo lỗi cụ thể.
     * @param message Thông báo lỗi để mô tả vấn đề liên quan đến cơ sở dữ liệu.
     */
    public DatabaseException(String message) {
        super(message);
    }
}


