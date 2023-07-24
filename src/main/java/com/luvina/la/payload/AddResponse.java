/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * AddResponse.java, July 08, 2023 nvduc
 */
package com.luvina.la.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

/**
 * Lớp đại diện cho phản hồi sau quá trình thêm mới.
 * Chứa thông tin về mã code, ID của nhân viên và các thông điệp liên quan.
 *
 * @Author nvduc
 */
@Data
@AllArgsConstructor
public class AddResponse {
    private String code;
    private long employeeId;
    private Map<String, Object> message;
}
