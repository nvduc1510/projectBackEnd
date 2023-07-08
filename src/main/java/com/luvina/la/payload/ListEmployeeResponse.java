/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * ListEmployeeResponse.java, July 5, 2023 nvduc
 */
package com.luvina.la.payload;

import com.luvina.la.dto.ListEmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
/**
 * Lớp đại diện cho phản hồi danh sách nhân viên.
 * Chứa thông tin về mã code, tổng số bản ghi và danh sách các đối tượng ListEmployeeDTO.
 *
 * @Author nvduc
 */
@Data
@AllArgsConstructor
public class ListEmployeeResponse {
    private String code;
    private long totalRecords;
    private List<ListEmployeeDTO> employees;
}
