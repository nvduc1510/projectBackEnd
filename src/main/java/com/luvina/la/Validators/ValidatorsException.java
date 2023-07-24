package com.luvina.la.Validators;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ValidatorsException extends  Exception {
    private String code;
    private List<String> params;

    public  ValidatorsException(String code){
        this.code = code;
    }

}
