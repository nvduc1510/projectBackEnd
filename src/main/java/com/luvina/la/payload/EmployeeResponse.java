/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 5, 2023 nvduc
 */
package com.luvina.la.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
* Đại diện cho thông tin lỗi liên quan đến nhân viên trong hệ thống.
* @author nvduc
*/
@Data
@AllArgsConstructor
public class EmployeeResponse extends  Exception{
    private String code;
    private List<String> params;
    /**
     * Tạo một đối tượng EmployeeResponse với mã code cụ thể.
     *
     * @param code Mã code cho lỗi EmployeeResponse.
     */
    public  EmployeeResponse(String code){
        this.code = code;
    }
}
