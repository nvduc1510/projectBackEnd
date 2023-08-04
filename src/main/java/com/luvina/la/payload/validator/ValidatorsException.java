/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 19, 2023 nvduc
 */
package com.luvina.la.payload.validator;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
/**
 * Lớp ngoại lệ (exception) cho các trường hợp xác thực không hợp lệ.
 */
@Data
@AllArgsConstructor
public class ValidatorsException extends Exception {

    private String code; // Mã lỗi đại diện cho loại lỗi cụ thể.
    private List<String> params; // Danh sách tham số dùng để xây dựng thông báo lỗi.

    /**
     * Constructor của lớp `ValidatorsException` với mã lỗi được chỉ định.
     * @param code Mã lỗi đại diện cho loại lỗi cụ thể.
     */
    public ValidatorsException(String code) {
        this.code = code;
    }

    // ... (Không cần thêm phần comment cho các getter/setter do đã sử dụng @Data)
}